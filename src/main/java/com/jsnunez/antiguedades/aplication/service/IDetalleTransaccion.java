package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IDetalleTransaccion {
    Optional<DetalleTransaccion> findById(Long id);
    List<DetalleTransaccion> getAll();
    DetalleTransaccion save(DetalleTransaccion detalleTransaccion);
    DetalleTransaccion update(Long id, DetalleTransaccion detalleTransaccion);
    void deleteById(Long id);
}
