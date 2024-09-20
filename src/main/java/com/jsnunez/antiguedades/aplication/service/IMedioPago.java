package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IMedioPago {
    Optional<MedioPago> findById(Long id);
    List<MedioPago> getAll();
    MedioPago save(MedioPago medioPago);
    MedioPago update(Long id, MedioPago medioPago);
    void deleteById(Long id);
}

