package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface ISucursal {
    Optional<Sucursal> findById(Long id);
    List<Sucursal> getAll();
    Sucursal save(Sucursal sucursal);
    Sucursal update(Long id, Sucursal sucursal);
    void deleteById(Long id);
}
