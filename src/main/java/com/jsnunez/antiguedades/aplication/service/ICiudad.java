package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface ICiudad {
    Optional<Ciudad> findById(Long id);
    List<Ciudad> getAll();
    Ciudad save(Ciudad ciudad);
    Ciudad update(Long id, Ciudad ciudad);
    void deleteById(Long id);
}

