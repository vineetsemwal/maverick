package org.example.registry.service;

import org.example.registry.dao.UserRepository;
import org.example.registry.dtos.*;
import org.example.registry.entities.UserEntity;
import org.example.registry.util.UserUtil;
import org.example.registry.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService, IUserService, UserDetailsPasswordService {
    private UserRepository userRepo;
    private TokenUtil tokenUtil;
    private UserUtil userUtil;

    @Autowired
    private ApplicationContext context;
    private PasswordEncoder passwordEncoder;
    private ReactiveAuthenticationManager authenticationManager;

    public UserServiceImpl(UserRepository repository, TokenUtil tokenUtil, UserUtil userUtil) {
        this.userRepo = repository;
        this.tokenUtil = tokenUtil;
        this.userUtil = userUtil;
    }

    public PasswordEncoder getPasswordEncoder() {
        if (passwordEncoder != null) {
            return passwordEncoder;
        }
        return passwordEncoder=context.getBean(PasswordEncoder.class);
    }

    public ReactiveAuthenticationManager getAuthenticationManager() {
        if (authenticationManager != null) {
            return authenticationManager;
        }
        return authenticationManager=context.getBean(ReactiveAuthenticationManager.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = findByUsername(username);
        return toUserDetails(user);
    }

    UserEntity findByUsername(String username) {
        Optional<UserEntity> optional = userRepo.findUserByUsername(username);
        if (!optional.isPresent()) {
            throw new UsernameNotFoundException("user not found by username=" + username);
        }
        return optional.get();
    }

    @Override
    public Mono<AppUserDetails> findUserDetailsByUsername(String username) {
        UserEntity user = findByUsername(username);
        return Mono.just(userUtil.toUserDetails(user));
    }

    public UserDetails toUserDetails(UserEntity user) {
        Collection<String> roleList = Arrays.asList(user.getRoles());
        List<SimpleGrantedAuthority> authorities = toAuthorities(roleList);
        User details = new User(user.getUsername(), user.getPassword(), authorities);
        String roles = user.getRoles();
        return details;
    }

    public List<SimpleGrantedAuthority> toAuthorities(Collection<String> roles) {
        List<SimpleGrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.trim().toUpperCase())).collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String generateTokenAfterCredentialsCheck(LoginRequest requestData) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(requestData.getUsername(), requestData.getPassword());
        System.out.println("****authenticated to be done");
        getAuthenticationManager().authenticate(token).block();
        return tokenUtil.encode(requestData.getUsername());
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        UserEntity found = findByUsername(user.getUsername());
        found.setPassword(newPassword);
        found = userRepo.save(found);
        return toUserDetails(found);
    }

    @Override
    @Transactional
    public AppUserDetails registerUser(AddUser requestData) {
        return registerUser(requestData, "USER");
    }

    @Override
    @Transactional
    public AppUserDetails registerAdmin(AddUser requestData) {
        return registerUser(requestData, "ADMIN");
    }

    public AppUserDetails registerUser(AddUser requestData, String role) {
        UserEntity user = new UserEntity();
        user.setUsername(requestData.getUsername());
        String encodedPassword = getPasswordEncoder().encode(requestData.getPassword());
        user.setPassword(encodedPassword);
        user.setEmail(requestData.getEmail());
        user.setRoles(role);
        user.setCreatedAt(LocalDateTime.now());
        user = userRepo.save(user);
        return userUtil.toUserDetails(user);

    }
}
