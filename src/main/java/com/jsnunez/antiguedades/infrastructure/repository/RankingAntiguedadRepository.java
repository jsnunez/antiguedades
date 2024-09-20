package com.jsnunez.antiguedades.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsnunez.antiguedades.domain.entities.*;

public interface RankingAntiguedadRepository extends JpaRepository<RankingAntiguedad, Long> {
}


