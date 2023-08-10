package org.example.demo.service;

import org.example.demo.dao.UserRepository;
import org.example.demo.dtos.LoginRequest;
import org.example.demo.dtos.UserDetailsImpl;
import org.example.demo.entities.User;
import org.example.demo.exceptions.IncorrectCredentialsException;
import org.example.demo.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService, IUserService, UserDetailsPasswordService {

    private UserRepository repository;

    private TokenUtil tokenUtil;

    @Autowired
    private ApplicationContext context;
    private AuthenticationManager authenticationManager;

    public UserServiceImpl(UserRepository repository, TokenUtil tokenUtil) {
        this.repository = repository;
        this.tokenUtil = tokenUtil;
    }

    public AuthenticationManager getAuthenticationManager(){
        if(authenticationManager!=null){
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
        Optional<User> optional = repository.findUserByUsername(username);
        if (!optional.isPresent()) {
            throw new UsernameNotFoundException("user not found by username=" + username);
        }
        return optional.get();
    }

    public UserDetails toUserDetails(User user) {
        UserDetailsImpl details = new UserDetailsImpl();
        details.setUsername(user.getUsername());
        details.setPassword(user.getPassword());
        Set<String> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = toAuthorities(roles);
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
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(requestData.getUsername(), requestData.getPassword());
        Authentication authenticate = getAuthenticationManager().authenticate(token);
        String jwtToken = tokenUtil.encode(requestData.getUsername());
        return jwtToken;
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        User found = findByUsername(user.getUsername());
        found.setPassword(newPassword);
        found = repository.save(found);
        return toUserDetails(found);
    }
}
