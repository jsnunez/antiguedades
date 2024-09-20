package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface ITipoPersona {
    Optional<TipoPersona> findById(Long id);
    List<TipoPersona> getAll();
    TipoPersona save(TipoPersona tipoPersona);
    TipoPersona update(Long id, TipoPersona tipoPersona);
    void deleteById(Long id);
}

