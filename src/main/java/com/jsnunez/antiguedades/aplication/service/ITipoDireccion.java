package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface ITipoDireccion {
    Optional<TipoDireccion> findById(Long id);
    List<TipoDireccion> getAll();
    TipoDireccion save(TipoDireccion tipoDireccion);
    TipoDireccion update(Long id, TipoDireccion tipoDireccion);
    void deleteById(Long id);
}
