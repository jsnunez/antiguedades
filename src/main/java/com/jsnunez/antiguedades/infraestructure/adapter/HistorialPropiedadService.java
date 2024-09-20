package com.jsnunez.antiguedades.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.IHistorialPropiedad;
import com.jsnunez.antiguedades.domain.entities.HistorialPropiedad;
import com.jsnunez.antiguedades.infraestructure.repository.*;
@Service
public class HistorialPropiedadService implements IHistorialPropiedad {

    @Autowired
    private HistorialPropiedadRepository historialPropiedadRepository;

    @Override
    public Optional<HistorialPropiedad> findById(Long id) {
        return historialPropiedadRepository.findById(id);
    }

    @Override
    public List<HistorialPropiedad> getAll() {
        return historialPropiedadRepository.findAll();
    }

    @Override
    public HistorialPropiedad save(HistorialPropiedad historialPropiedad) {
        return historialPropiedadRepository.save(historialPropiedad);
    }

    @Override
    public HistorialPropiedad update(Long id, HistorialPropiedad historialPropiedad) {
        return historialPropiedadRepository.findById(id)
            .map(existingHistorial -> {
                existingHistorial.setAntiguedad(historialPropiedad.getAntiguedad());
                existingHistorial.setFechaCambio(historialPropiedad.getFechaCambio());
                existingHistorial.setPropietarioActual(historialPropiedad.getPropietarioActual());
                existingHistorial.setPropietarioAnterior(historialPropiedad.getPropietarioAnterior());
                return historialPropiedadRepository.save(existingHistorial);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        historialPropiedadRepository.deleteById(id);
    }
}
