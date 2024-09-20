package com.jsnunez.antiguedades.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsnunez.antiguedades.domain.entities.EpocaAntigueda;

public interface EpocaRepository extends JpaRepository<EpocaAntigueda,Long> {

}
