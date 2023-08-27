package org.example.registry;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import reactor.core.publisher.Mono;

@EnableWebFluxSecurity
@Configuration
public class AppSecurityConfig {
    @Autowired
    private UserDetailsService userService;
    @Autowired
    private UserDetailsPasswordService userPasswordService;
    @Autowired
    private ReactiveAuthenticationManager authenticationManager;
    @Autowired
    private ServerSecurityContextRepository securityContextRepository;


    @Bean
    public ReactiveUserDetailsService userDetailsService() {
        ReactiveUserDetailsService reactiveUserDetailsService = username -> {
            UserDetails user = userService.loadUserByUsername(username);
            System.out.println("user fetched=" + username + " user=" + user);
            return Mono.just(user);
        };

        return reactiveUserDetailsService;
    }


    @Bean
    protected SecurityWebFilterChain configure(ServerHttpSecurity http) throws Exception {
        return http
                .httpBasic(httpBasic -> httpBasic.disable())
                .csrf(csrf -> csrf.disable())
                .cors((cors)->corsConfiguration())
                .formLogin(form -> form.disable())
                .authenticationManager((authenticationManager))
                .securityContextRepository(securityContextRepository)
                .passwordManagement(pass -> passwordEncoder())
                .authorizeExchange(exchange -> exchange
                        .pathMatchers("/user/login").permitAll()
                        .pathMatchers("/p/**").permitAll()
                        .pathMatchers("/user/registeration").permitAll()
                        .pathMatchers("/a/**").hasRole("ADMIN")
                        .pathMatchers("/c/**").hasAnyRole("CUSTOMER", "ADMIN")
                )
                .build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();// use in operation/production
        // return new BCryptPasswordEncoder();
    }


    @Bean
    public CorsConfigurationSource corsConfiguration() {
        UrlBasedCorsConfigurationSource configuration = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://ourfrontend.com");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        configuration.registerCorsConfiguration("/**", corsConfiguration);
        return configuration;
    }

}
