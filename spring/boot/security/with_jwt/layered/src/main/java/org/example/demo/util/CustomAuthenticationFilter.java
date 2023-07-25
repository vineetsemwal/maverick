package org.example.demo.util;

import org.example.demo.exceptions.InvalidTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private TokenUtil tokenUtil;

    private UserDetailsService userService;

    @Autowired
    public CustomAuthenticationFilter(UserDetailsService service, TokenUtil tokenUtil){
        this.userService=service;
        this.tokenUtil=tokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("Authorization");
        try {
            String uri=request.getRequestURI();
            if( uri.startsWith("/p/")||uri.startsWith("/login"))
            {
                filterChain.doFilter(request, response);
                return;
            }
            if(token==null||token.isEmpty()){
                throw new InvalidTokenException("invalid token, can't be null or empty");
            }
            token=token.substring(7);

            String username = tokenUtil.decode(token);
            UserDetails user = userService.loadUserByUsername(username);
            System.out.println("user details fetched from token="+user.getUsername()+","+user.getPassword()+"-"+user.getAuthorities());


            UsernamePasswordAuthenticationToken newAuthentication = new UsernamePasswordAuthenticationToken(username, user.getPassword(), user.getAuthorities());
            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(newAuthentication);
            filterChain.doFilter(request, response);

        } catch (UsernameNotFoundException | InvalidTokenException e) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("You are not authorized");
        }

    }
}
