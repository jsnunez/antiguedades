package com.jsnunez.antiguedades.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsnunez.antiguedades.domain.entities.EpocaAntigueda;

public interface EpocaRepository extends JpaRepository<EpocaAntigueda,Long> {

}
