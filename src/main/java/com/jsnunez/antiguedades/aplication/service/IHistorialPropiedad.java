package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IHistorialPropiedad {
    Optional<HistorialPropiedad> findById(Long id);
    List<HistorialPropiedad> getAll();
    HistorialPropiedad save(HistorialPropiedad historialPropiedad);
    HistorialPropiedad update(Long id, HistorialPropiedad historialPropiedad);
    void deleteById(Long id);
}


