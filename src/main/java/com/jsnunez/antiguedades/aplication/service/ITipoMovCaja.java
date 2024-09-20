package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;
public interface ITipoMovCaja {
    Optional<TipoMovCaja> findById(Long id);
    List<TipoMovCaja> getAll();
    TipoMovCaja save(TipoMovCaja tipoMovCaja);
    TipoMovCaja update(Long id, TipoMovCaja tipoMovCaja);
    void deleteById(Long id);
}

