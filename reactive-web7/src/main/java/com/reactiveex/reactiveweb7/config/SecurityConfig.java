package com.reactiveex.reactiveweb7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {
/*
* Step1 Configure Authentications
* Test it with postman by passing user id and password
* */
    @Bean
    public ReactiveUserDetailsService userDetailsService(){
        var user = User.withUsername("singh.rakesh")
                .password("Welcome123")
                .authorities("read")
                .build();
        return new MapReactiveUserDetailsService(user);

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*step-2 Configure Authorization */
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){

        return http
                .httpBasic()
                .and()
                .authorizeExchange()
                .pathMatchers("/test1/**").authenticated()
                .pathMatchers("/test2/**").permitAll()
                .and()
                .build();
    }

