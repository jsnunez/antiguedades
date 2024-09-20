package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IEstacionPago {
    Optional<EstacionPago> findById(Long id);
    List<EstacionPago> getAll();
    EstacionPago save(EstacionPago estacionPago);
    EstacionPago update(Long id, EstacionPago estacionPago);
    void deleteById(Long id);
}
