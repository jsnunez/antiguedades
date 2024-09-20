package com.jsnunez.antiguedades.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsnunez.antiguedades.domain.entities.*;

public interface EstacionPagoRepository extends JpaRepository<EstacionPago, Long> {
}

