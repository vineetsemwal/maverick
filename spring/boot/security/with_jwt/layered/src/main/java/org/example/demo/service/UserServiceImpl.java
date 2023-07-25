package org.example.demo.service;

import org.example.demo.dao.UserRepository;
import org.example.demo.dtos.LoginRequest;
import org.example.demo.dtos.UserDetailsImpl;
import org.example.demo.entities.User;
import org.example.demo.exceptions.IncorrectCredentialsException;
import org.example.demo.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService, IUserService {

    private UserRepository repository;

    private TokenUtil tokenUtil;

    public UserServiceImpl(UserRepository repository, TokenUtil tokenUtil) {
        this.repository = repository;
        this.tokenUtil=tokenUtil;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=findByUsername(username);
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
        List<SimpleGrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.toUpperCase())).collect(Collectors.toList());
        details.setAuthorities(authorities);
        return details;
    }


    @Override
    public String login(LoginRequest requestData) {
        User user=findByUsername(requestData.getUsername());
        if(!user.getPassword().equals(requestData.getPassword().trim())){
            throw new IncorrectCredentialsException("username or password is incorrect");
        }
        Set<String>roles= user.getRoles();
        String token = tokenUtil.encode(requestData.getUsername(), roles);
        return token;
    }

}
