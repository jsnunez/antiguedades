package com.jsnunez.antiguedades.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.IAntiguedad;
import com.jsnunez.antiguedades.domain.entities.Antiguedad;
import com.jsnunez.antiguedades.infraestructure.repository.*;

@Service
public class AntiguedadService implements IAntiguedad {

    @Autowired
    private AntiguedadRepository antiguedadRepository;

    @Override
    public Optional<Antiguedad> findById(Long id) {
        return antiguedadRepository.findById(id);
    }

    @Override
    public List<Antiguedad> getAll() {
        return antiguedadRepository.findAll();
    }

    @Override
    public Antiguedad save(Antiguedad antiguedad) {
        return antiguedadRepository.save(antiguedad);
    }

    @Override
    public Antiguedad update(Long id, Antiguedad antiguedad) {
        return antiguedadRepository.findById(id)
            .map(existingAntiguedad -> {
                existingAntiguedad.setNombre(antiguedad.getNombre());
                existingAntiguedad.setDescripcion(antiguedad.getDescripcion());
                existingAntiguedad.setPrecio(antiguedad.getPrecio());
                existingAntiguedad.setEstadoConservacion(antiguedad.getEstadoConservacion());
                existingAntiguedad.setFechaRegistro(antiguedad.getFechaRegistro());
                existingAntiguedad.setCategoria(antiguedad.getCategoria());
                existingAntiguedad.setPropietario(antiguedad.getPropietario());
                existingAntiguedad.setSucursal(antiguedad.getSucursal());
                existingAntiguedad.setEpocaAntigueda(antiguedad.getEpocaAntigueda());
                return antiguedadRepository.save(existingAntiguedad);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        antiguedadRepository.deleteById(id);
    }
}

