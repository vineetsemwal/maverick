package org.example.demo.service;

import org.example.demo.dao.UserRepository;
import org.example.demo.dtos.*;
import org.example.demo.entities.User;
import org.example.demo.util.UserUtil;
import org.example.demo.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private AuthenticationManager authenticationManager;

    public UserServiceImpl(UserRepository repository, TokenUtil tokenUtil, UserUtil userUtil) {
        this.userRepo = repository;
        this.tokenUtil = tokenUtil;
        this.userUtil = userUtil;
    }

    public PasswordEncoder getPasswordEncoder(){
        if(passwordEncoder!=null){
            return passwordEncoder;
        }
        return context.getBean(PasswordEncoder.class);
    }

    public AuthenticationManager getAuthenticationManager() {
        if (authenticationManager != null) {
            return authenticationManager;
        }
        return context.getBean(AuthenticationManager.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        return toUserDetails(user);
    }

    User findByUsername(String username) {
        Optional<User> optional = userRepo.findUserByUsername(username);
        if (!optional.isPresent()) {
            throw new UsernameNotFoundException("user not found by username=" + username);
        }
        return optional.get();
    }

    @Override
    public AppUserDetails findUserDetailsByUsername(String username) {
        User user = findByUsername(username);
        return userUtil.toUserDetails(user);
    }

    public UserDetails toUserDetails(User user) {
        UserDetailsImpl details = new UserDetailsImpl();
        details.setUsername(user.getUsername());
        details.setPassword(user.getPassword());
        String roles = user.getRoles();
        Collection<String> roleList = Arrays.asList(roles);
        List<SimpleGrantedAuthority> authorities = toAuthorities(roleList);
        details.setAuthorities(authorities);
        return details;
    }

    public List<SimpleGrantedAuthority> toAuthorities(Collection<String> roles) {
        List<SimpleGrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.toUpperCase())).collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String generateTokenAfterCredentialsCheck(LoginRequest requestData) {
        //String encodedPassword=getPasswordEncoder().encode(requestData.getPassword());
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(requestData.getUsername(),requestData.getPassword());
        System.out.println("****authenticated to be done");
        Authentication authenticate = getAuthenticationManager().authenticate(token);
        System.out.println("****authentication done");
        String jwtToken = tokenUtil.encode(requestData.getUsername());
        return jwtToken;
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        User found = findByUsername(user.getUsername());
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
        User user = new User();
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
