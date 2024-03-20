package com.floreselmachetaso.jardineria.web.controller;

import org.springframework.web.bind.annotation.RestController;

import com.floreselmachetaso.jardineria.domain.repository.UserRepository;
import com.floreselmachetaso.jardineria.domain.security.JWTAuthorizationFilter;
import com.floreselmachetaso.jardineria.domain.security.JWTAuthtenticationConfig;
import com.floreselmachetaso.jardineria.persistence.DTO.UserDTO;
import com.floreselmachetaso.jardineria.persistence.entities.UserEntity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTAuthtenticationConfig jwtAuthtenticationConfig;

    @PostMapping
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {

        Optional<UserEntity> newUser = userRepository.findByUsername(username);
        UserEntity userPer = newUser.get();
        
        if (userPer != null && userPer.getPassword().equals(password)) {
            String token = jwtAuthtenticationConfig.getJWTToken(username);
            userRepository.save(userPer);
            return token;
        } else {
            throw new RuntimeException("Invalid Information");
        }
    }
    
}
