package com.jsnunez.antiguedades.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.IEstacionPago;
import com.jsnunez.antiguedades.domain.entities.EstacionPago;
import com.jsnunez.antiguedades.infraestructure.repository.*;
@Service
public class EstacionPagoService implements IEstacionPago {

    @Autowired
    private EstacionPagoRepository estacionPagoRepository;

    @Override
    public Optional<EstacionPago> findById(Long id) {
        return estacionPagoRepository.findById(id);
    }

    @Override
    public List<EstacionPago> getAll() {
        return estacionPagoRepository.findAll();
    }

    @Override
    public EstacionPago save(EstacionPago estacionPago) {
        return estacionPagoRepository.save(estacionPago);
    }

    @Override
    public EstacionPago update(Long id, EstacionPago estacionPago) {
        return estacionPagoRepository.findById(id)
            .map(existingEstacion -> {
                existingEstacion.setNombre(estacionPago.getNombre());
                return estacionPagoRepository.save(existingEstacion);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        estacionPagoRepository.deleteById(id);
    }
}
