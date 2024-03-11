package com.mk.pizzaexpress.config.security;

import com.mk.pizzaexpress.config.filter.JwtAuthenticationFilter;
import com.mk.pizzaexpress.config.security.exception.CustomAccessDeniedHandler;
import com.mk.pizzaexpress.config.security.exception.CustomAuthenticationEntryPoint;
import com.mk.pizzaexpress.persistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class HttpSecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Autowired
    private UsuarioRepository userRepository;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                 .authenticationProvider(authenticationProvider)
                 .addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class)
                 .exceptionHandling( httpSecurityExceptionHandlingConfigurer -> {
                     httpSecurityExceptionHandlingConfigurer.authenticationEntryPoint(customAuthenticationEntryPoint).
                             accessDeniedHandler(customAccessDeniedHandler);
                 });


         return http.build();
    }


}
