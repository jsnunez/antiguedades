package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface ITransaccionMedioPago {
    Optional<TransaccionMedioPago> findById(Long id);
    List<TransaccionMedioPago> getAll();
    TransaccionMedioPago save(TransaccionMedioPago transaccionMedioPago);
    TransaccionMedioPago update(Long id, TransaccionMedioPago transaccionMedioPago);
    void deleteById(Long id);
}

