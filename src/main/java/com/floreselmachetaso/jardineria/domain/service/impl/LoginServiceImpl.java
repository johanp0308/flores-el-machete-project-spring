package com.floreselmachetaso.jardineria.domain.service.impl;

import java.util.Map;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.floreselmachetaso.jardineria.domain.repository.UserRepository;
import com.floreselmachetaso.jardineria.domain.security.JWTAuthorizationFilter;
import com.floreselmachetaso.jardineria.domain.security.JWTAuthtenticationConfig;
import com.floreselmachetaso.jardineria.domain.service.LoginSevice;
import com.floreselmachetaso.jardineria.persistence.DTO.UserDTO;
import com.floreselmachetaso.jardineria.persistence.entities.UserEntity;

@Service
public class LoginServiceImpl implements LoginSevice{
    
    private final UserRepository userRepository;
    
    @Autowired
    public LoginServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    private JWTAuthorizationFilter jwtAuthorizationFilter;
    
    @Autowired
    private JWTAuthtenticationConfig jwtAuthtenticationConfig;

    @Override
    public ResponseEntity<UserDTO> loginUser(String username, String password) {
        Optional<UserEntity> oUser = userRepository.findByUsername(username);
        if (oUser.get() != null) {
            UserEntity userEntity = oUser.get();
            String token = jwtAuthtenticationConfig.getJWTToken(userEntity.getUsername());
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(userEntity.getUsername());
            userDTO.setToken(token);
            return ResponseEntity.ok(userDTO);
        }
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserDTO> registerUser(String username, String password) {
        Optional<UserEntity> oUser = userRepository.findByUsername(username);
        if()
    }

    @Override
    public Map<String, Object> validateTokeN(String token) {
        
    }

}
