package com.jsnunez.antiguedades.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsnunez.antiguedades.domain.entities.*;
public interface GeneroRepository extends JpaRepository<Genero, Long> {
}


