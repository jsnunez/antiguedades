package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IClaseContacto {
    Optional<ClaseContacto> findById(Long id);
    List<ClaseContacto> getAll();
    ClaseContacto save(ClaseContacto claseContacto);
    ClaseContacto update(Long id, ClaseContacto claseContacto);
    void deleteById(Long id);
}
