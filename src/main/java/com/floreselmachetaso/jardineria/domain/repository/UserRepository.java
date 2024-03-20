package com.floreselmachetaso.jardineria.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.floreselmachetaso.jardineria.persistence.entities.User;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long>{
    
    Optional<User> findByUsername(String username);
    
}
