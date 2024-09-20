package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IGaleria {
    Optional<Galeria> findById(Long id);
    List<Galeria> getAll();
    Galeria save(Galeria galeria);
    Galeria update(Long id, Galeria galeria);
    void deleteById(Long id);
}

