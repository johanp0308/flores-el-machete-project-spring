package com.floreselmachetaso.jardineria.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.floreselmachetaso.jardineria.domain.repository.UserRepository;
import com.floreselmachetaso.jardineria.persistence.DTO.UserDTO;
import com.floreselmachetaso.jardineria.persistence.entities.UserEntity;

@RestController
// @CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/registerUser")

public class UserEntityController {
    private final UserRepository userRepository;

    @Autowired
    public UserEntityController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public UserEntity saveUser(@RequestBody UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());

        return userRepository.save(userEntity);
    }


}