package com.floreselmachetaso.jardineria.domain.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
class WebSecurityConfig {
    
    @Autowired
    JWTAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize ->
                        authorize.requestMatchers(Constanst.USER_SIGNIN).permitAll()
                                .requestMatchers(Constanst.SWAGGER_DOCS).permitAll()
                                .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(login -> login.permitAll()
                    .successHandler(succesionHanler())    
                )
                .httpBasic(htb -> htb.disable());
        return http.build();
    }


    public AuthenticationSuccessHandler succesionHanler(){
        return ((request,response,authentication)->{
            response.sendRedirect("/home");
        });
    }

}
