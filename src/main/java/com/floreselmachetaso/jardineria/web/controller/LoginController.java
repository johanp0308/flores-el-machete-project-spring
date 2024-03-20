package com.floreselmachetaso.jardineria.web.controller;

import org.springframework.web.bind.annotation.RestController;

import com.floreselmachetaso.jardineria.domain.repository.UserRepository;
import com.floreselmachetaso.jardineria.persistence.DTO.UserDTO;
import com.floreselmachetaso.jardineria.persistence.entities.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @GetMapping("/start")
    public String getMethodName(@RequestParam String param) {
        return new String("Hola");
    }
    

    @PostMapping("/registerUser")
    public ResponseEntity<?> postMethodName(@RequestBody UserDTO userdto) {
        
        UserEntity userEnti =  UserEntity.builder()
            .username(userdto.getUsername())
            .password(passwordEncoder.encode(userdto.getPassword()))
            .build();

            userRepository.save(userEnti);

        return ResponseEntity.ok(userRepository.save(userEnti));
    }
    
}
