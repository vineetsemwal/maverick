package org.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class AppSecurityConfig {

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.cors()//.configurationSource(corsConfiguration())
                .and()
                .csrf().disable().httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/p/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/c/**").hasAnyRole("CUSTOMER","ADMIN")
                .antMatchers("/a/**").hasAnyRole("ADMIN")
                .and()
                .formLogin().permitAll().defaultSuccessUrl("/success")
                .and()
                .logout().clearAuthentication(true).deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);

        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

/*
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
*/

}
