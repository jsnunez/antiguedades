package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IDireccionPersona {
    Optional<DireccionPersona> findById(Long id);
    List<DireccionPersona> getAll();
    DireccionPersona save(DireccionPersona direccionPersona);
    DireccionPersona update(Long id, DireccionPersona direccionPersona);
    void deleteById(Long id);
}
