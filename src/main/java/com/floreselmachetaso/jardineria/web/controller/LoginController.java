package com.floreselmachetaso.jardineria.web.controller;

import org.springframework.web.bind.annotation.RestController;

import com.floreselmachetaso.jardineria.domain.repository.UserRepository;
import com.floreselmachetaso.jardineria.persistence.DTO.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1")
public class LoginController {

    private final UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    @GetMapping("/start")
    public String getMethodName(@RequestParam String param) {
        return new String("Hola");
    }
    

    @PostMapping("/registerUser")
    public ResponseEntity<?> postMethodName(@RequestBody UserDTO userdto) {
        
        User userEnti = (User) User.builder()
            .username(userdto.getUsername())
            .password(userdto.getPassword())
            .build();

        ;

        
        return ResponseEntity.ok(userRepository.save(userEnti)).;
    }
    
}
