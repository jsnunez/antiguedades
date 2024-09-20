package com.jsnunez.antiguedades.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsnunez.antiguedades.domain.entities.Antiguedad;

public interface AntiguedadRepository extends JpaRepository<Antiguedad,Long> {

}
