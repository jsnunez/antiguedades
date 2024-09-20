package com.jsnunez.antiguedades.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.ITipoPersona;
import com.jsnunez.antiguedades.domain.entities.TipoPersona;
import com.jsnunez.antiguedades.infrastructure.repository.*;
@Service
public class TipoPersonaService implements ITipoPersona {

    @Autowired
    private TipoPersonaRepository tipoPersonaRepository;

    @Override
    public Optional<TipoPersona> findById(Long id) {
        return tipoPersonaRepository.findById(id);
    }

    @Override
    public List<TipoPersona> getAll() {
        return tipoPersonaRepository.findAll();
    }

    @Override
    public TipoPersona save(TipoPersona tipoPersona) {
        return tipoPersonaRepository.save(tipoPersona);
    }

    @Override
    public TipoPersona update(Long id, TipoPersona tipoPersona) {
        return tipoPersonaRepository.findById(id)
            .map(existingTipo -> {
                existingTipo.setTipo(tipoPersona.getTipo());
                return tipoPersonaRepository.save(existingTipo);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        tipoPersonaRepository.deleteById(id);
    }
}
