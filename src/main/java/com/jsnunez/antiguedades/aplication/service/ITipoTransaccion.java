package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface ITipoTransaccion {
    Optional<TipoTransaccion> findById(Long id);
    List<TipoTransaccion> getAll();
    TipoTransaccion save(TipoTransaccion tipoTransaccion);
    TipoTransaccion update(Long id, TipoTransaccion tipoTransaccion);
    void deleteById(Long id);
}

