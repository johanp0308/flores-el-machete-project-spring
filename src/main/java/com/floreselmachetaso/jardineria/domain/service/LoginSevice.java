package com.floreselmachetaso.jardineria.domain.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.floreselmachetaso.jardineria.persistence.DTO.UserDTO;

public interface LoginSevice {
    
    ResponseEntity<UserDTO> loginUser(String username, String password);
    ResponseEntity<UserDTO> registerUser(String username, String password);
    Map<String,Object> validateTokeN(String token);
}
