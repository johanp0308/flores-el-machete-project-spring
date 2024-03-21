package com.floreselmachetaso.jardineria.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.floreselmachetaso.jardineria.persistence.entities.UserEntity;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity,Long>{
    
    Optional<UserEntity> findByUsername(String username);
    
}
