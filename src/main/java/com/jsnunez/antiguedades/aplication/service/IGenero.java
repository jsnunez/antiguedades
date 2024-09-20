package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IGenero {
    Optional<Genero> findById(Long id);
    List<Genero> getAll();
    Genero save(Genero genero);
    Genero update(Long id, Genero genero);
    void deleteById(Long id);
}
