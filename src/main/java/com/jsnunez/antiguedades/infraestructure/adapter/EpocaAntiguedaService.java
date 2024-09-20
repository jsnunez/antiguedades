package com.jsnunez.antiguedades.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.IEpoca;
import com.jsnunez.antiguedades.domain.entities.EpocaAntigueda;
import com.jsnunez.antiguedades.infraestructure.repository.*;

@Service
public class EpocaAntiguedaService implements IEpoca {

    @Autowired
    private EpocaRepository epocaAntiguedaRepository;

    @Override
    public Optional<EpocaAntigueda> findById(Long id) {
        return epocaAntiguedaRepository.findById(id);
    }

    @Override
    public List<EpocaAntigueda> getAll() {
        return epocaAntiguedaRepository.findAll();
    }

    @Override
    public EpocaAntigueda save(EpocaAntigueda epocaAntigueda) {
        return epocaAntiguedaRepository.save(epocaAntigueda);
    }

    @Override
    public EpocaAntigueda update(Long id, EpocaAntigueda epocaAntigueda) {
        return epocaAntiguedaRepository.findById(id)
            .map(existingEpoca -> {
                existingEpoca.setNombre(epocaAntigueda.getNombre());
                return epocaAntiguedaRepository.save(existingEpoca);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        epocaAntiguedaRepository.deleteById(id);
    }
}
