package com.jsnunez.antiguedades.aplication.service;
import java.util.List;
import java.util.Optional;

import com.jsnunez.antiguedades.domain.entities.*;

public interface IPais {
    Optional<Pais> findById(Long id);
    List<Pais> getAll();
    Pais save(Pais pais);
    Pais update(Long id, Pais pais);
    void deleteById(Long id);
}
