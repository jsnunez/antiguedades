package com.jsnunez.antiguedades.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.jsnunez.antiguedades.domain.entities.UserEntity;



public interface UserRepository extends CrudRepository<UserEntity,Long> {
    Optional<UserEntity> findUserEntityByUsername(String username);
}
