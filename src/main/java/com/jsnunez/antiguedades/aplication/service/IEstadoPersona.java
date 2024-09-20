package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IEstadoPersona {
    Optional<EstadoPersona> findById(Long id);
    List<EstadoPersona> getAll();
    EstadoPersona save(EstadoPersona estadoPersona);
    EstadoPersona update(Long id, EstadoPersona estadoPersona);
    void deleteById(Long id);
}
