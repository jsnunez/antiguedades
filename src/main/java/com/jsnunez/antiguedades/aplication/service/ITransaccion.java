package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface ITransaccion {
    Optional<Transaccion> findById(Long id);
    List<Transaccion> getAll();
    Transaccion save(Transaccion transaccion);
    Transaccion update(Long id, Transaccion transaccion);
    void deleteById(Long id);
}

