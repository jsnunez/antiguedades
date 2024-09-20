package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IDespacho {
    Optional<Despacho> findById(Long id);
    List<Despacho> getAll();
    Despacho save(Despacho despacho);
    Despacho update(Long id, Despacho despacho);
    void deleteById(Long id);
}
