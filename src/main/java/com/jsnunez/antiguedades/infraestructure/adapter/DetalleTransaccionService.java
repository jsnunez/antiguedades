package com.jsnunez.antiguedades.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.IAntiguedad;
import com.jsnunez.antiguedades.domain.entities.Antiguedad;
import com.jsnunez.antiguedades.infraestructure.repository.*;
@Service
public class DetalleTransaccionService implements IDetalleTransaccion {

    @Autowired
    private DetalleTransaccionRepository detalleTransaccionRepository;

    @Override
    public Optional<DetalleTransaccion> findById(Long id) {
        return detalleTransaccionRepository.findById(id);
    }

    @Override
    public List<DetalleTransaccion> getAll() {
        return detalleTransaccionRepository.findAll();
    }

    @Override
    public DetalleTransaccion save(DetalleTransaccion detalleTransaccion) {
        return detalleTransaccionRepository.save(detalleTransaccion);
    }

    @Override
    public DetalleTransaccion update(Long id, DetalleTransaccion detalleTransaccion) {
        return detalleTransaccionRepository.findById(id)
            .map(existingDetalle -> {
                existingDetalle.setTransaccion(detalleTransaccion.getTransaccion());
                existingDetalle.setAntiguedad(detalleTransaccion.getAntiguedad());
                return detalleTransaccionRepository.save(existingDetalle);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        detalleTransaccionRepository.deleteById(id);
    }
}
