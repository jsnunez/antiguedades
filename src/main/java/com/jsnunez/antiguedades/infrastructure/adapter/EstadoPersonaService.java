package com.jsnunez.antiguedades.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.IEstadoPersona;
import com.jsnunez.antiguedades.domain.entities.EstadoPersona;
import com.jsnunez.antiguedades.infrastructure.repository.*;
@Service
public class EstadoPersonaService implements IEstadoPersona {

    @Autowired
    private EstadoPersonaRepository estadoPersonaRepository;

    @Override
    public Optional<EstadoPersona> findById(Long id) {
        return estadoPersonaRepository.findById(id);
    }

    @Override
    public List<EstadoPersona> getAll() {
        return estadoPersonaRepository.findAll();
    }

    @Override
    public EstadoPersona save(EstadoPersona estadoPersona) {
        return estadoPersonaRepository.save(estadoPersona);
    }

    @Override
    public EstadoPersona update(Long id, EstadoPersona estadoPersona) {
        return estadoPersonaRepository.findById(id)
            .map(existingEstado -> {
                existingEstado.setEstado(estadoPersona.getEstado());
                return estadoPersonaRepository.save(existingEstado);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        estadoPersonaRepository.deleteById(id);
    }
}
