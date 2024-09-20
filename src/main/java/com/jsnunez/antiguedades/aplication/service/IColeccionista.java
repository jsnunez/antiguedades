package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IColeccionista {
    Optional<Coleccionista> findById(Long id);
    List<Coleccionista> getAll();
    Coleccionista save(Coleccionista coleccionista);
    Coleccionista update(Long id, Coleccionista coleccionista);
    void deleteById(Long id);
}
