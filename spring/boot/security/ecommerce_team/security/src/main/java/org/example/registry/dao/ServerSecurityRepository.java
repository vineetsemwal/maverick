package org.example.registry.dao;

import io.jsonwebtoken.security.SignatureException;
import org.example.registry.exceptions.InvalidTokenException;
import org.example.registry.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class ServerSecurityRepository implements ServerSecurityContextRepository {

    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private UserDetailsService userService;

    @Autowired
    private ReactiveAuthenticationManager authenticationManager;

    @Override
    public Mono<Void> save(ServerWebExchange exchange, SecurityContext context) {
        throw new UnsupportedOperationException("save not implemented yet");
    }

    @Override
    public Mono<SecurityContext> load(ServerWebExchange exchange) {
        System.out.println("***inside load");
        ServerHttpRequest request=exchange.getRequest();
        String token = request.getHeaders().getFirst("Authorization");
        try {
            String uri=request.getURI().getPath();
            System.out.println("request parameter="+request.getQueryParams().get("username")+" uri="+uri+" method="+request.getMethod());
            if( uri.startsWith("/p/")||uri.startsWith("/user/login")||uri.startsWith("/user/registeration"))
            {
                return Mono.empty();
            }
            if(token==null||token.isEmpty()){
                throw new InvalidTokenException("invalid token, can't be null or empty");
            }
            token=token.substring(7);
            String username = tokenUtil.decode(token);
            UserDetails user = userService.loadUserByUsername(username);
            System.out.println("****user details fetched from token="+user);
            UsernamePasswordAuthenticationToken newAuthentication = new UsernamePasswordAuthenticationToken(username, user.getPassword(), user.getAuthorities());
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(newAuthentication);
            return this.authenticationManager.authenticate(newAuthentication).map(SecurityContextImpl::new);

        } catch (UsernameNotFoundException | InvalidTokenException | SignatureException e) {
            ServerHttpResponse response=exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            System.out.println("*****exception in processing token");
            return Mono.empty();
        }


    }
}
