package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IPersona {
    Optional<Persona> findById(Long id);
    List<Persona> getAll();
    Persona save(Persona persona);
    Persona update(Long id, Persona persona);
    void deleteById(Long id);
}

