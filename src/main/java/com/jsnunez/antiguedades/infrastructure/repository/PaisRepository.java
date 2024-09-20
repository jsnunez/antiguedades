package com.jsnunez.antiguedades.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsnunez.antiguedades.domain.entities.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {
}

