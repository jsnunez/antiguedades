package com.jsnunez.antiguedades.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsnunez.antiguedades.domain.entities.Antiguedad;

public interface AntiguedadRepository extends JpaRepository<Antiguedad,Long> {

}
