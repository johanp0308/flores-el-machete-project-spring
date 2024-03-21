package com.floreselmachetaso.jardineria.domain.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTAuthorizationFilter jwtAuthorizationFilter;
    
    @Autowired
    private JWTAuthtenticationConfig jwtAuthtenticationConfig;

    @Override
    public UserDTO loginUser(String username, String password) {
        Optional<UserEntity> oUser = userRepository.findByUsername(username);
        if (oUser.get() != null) {
            UserEntity userEntity = oUser.get();
            if(passwordEncoder.matches(password, userEntity.getPassword())){
                String token = jwtAuthtenticationConfig.getJWTToken(userEntity.getUsername());
                UserDTO userDTO = new UserDTO();
                userDTO.setUsername(userEntity.getUsername());
                userDTO.setToken(token);
                return userDTO;
            }
        }
        return null;
    }

    @Override
    public UserDTO registerUser(String username, String password) {
        Optional<UserEntity> oUser = userRepository.findByUsername(username);
        if(oUser.get() == null){
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(username);
            userEntity.setPassword(passwordEncoder.encode(password));
            UserEntity response = userRepository.save(userEntity); 
            if (response != null) {
                UserDTO userDTO = new UserDTO();
                userDTO.setUsername(username);
                userDTO.setToken(jwtAuthtenticationConfig.getJWTToken(response.getUsername()));
                return userDTO;
            }
        }
        return null;
    }

    @Override
    public Map<String, Object> validateTokeN(String token) {
        boolean valid = false;
        Boolean isJWTValid = jwtAuthorizationFilter.isJWTValid(token);
        if (isJWTValid) {
            String username = jwtAuthorizationFilter.getClaims(token).getSubject();
            UserEntity userEntity = userRepository.findByUsername(username).orElse(null);
            if (userEntity != null) {
                valid = true;
            }

        }
        Map<String,Object> repsonse = new HashMap<>();
        repsonse.put("is_token_valid", valid);
        return repsonse;
    }

}
