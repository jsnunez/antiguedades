package com.jsnunez.antiguedades.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.IDireccionPersona;
import com.jsnunez.antiguedades.domain.entities.DireccionPersona;
import com.jsnunez.antiguedades.infraestructure.repository.*;
@Service
public class DireccionPersonaService implements IDireccionPersona {

    @Autowired
    private DireccionPersonaRepository direccionPersonaRepository;

    @Override
    public Optional<DireccionPersona> findById(Long id) {
        return direccionPersonaRepository.findById(id);
    }

    @Override
    public List<DireccionPersona> getAll() {
        return direccionPersonaRepository.findAll();
    }

    @Override
    public DireccionPersona save(DireccionPersona direccionPersona) {
        return direccionPersonaRepository.save(direccionPersona);
    }

    @Override
    public DireccionPersona update(Long id, DireccionPersona direccionPersona) {
        return direccionPersonaRepository.findById(id)
            .map(existingDireccion -> {
                existingDireccion.setNumero(direccionPersona.getNumero());
                existingDireccion.setTipoDireccion(direccionPersona.getTipoDireccion());
                return direccionPersonaRepository.save(existingDireccion);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        direccionPersonaRepository.deleteById(id);
    }
}
