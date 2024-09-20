package com.jsnunez.antiguedades.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.IGaleria;
import com.jsnunez.antiguedades.domain.entities.Galeria;
import com.jsnunez.antiguedades.infraestructure.repository.*;
@Service
public class GaleriaService implements IGaleria {

    @Autowired
    private GaleriaRepository galeriaRepository;

    @Override
    public Optional<Galeria> findById(Long id) {
        return galeriaRepository.findById(id);
    }

    @Override
    public List<Galeria> getAll() {
        return galeriaRepository.findAll();
    }

    @Override
    public Galeria save(Galeria galeria) {
        return galeriaRepository.save(galeria);
    }

    @Override
    public Galeria update(Long id, Galeria galeria) {
        return galeriaRepository.findById(id)
            .map(existingGaleria -> {
                existingGaleria.setAntiguedad(galeria.getAntiguedad());
                existingGaleria.setDescripcion(galeria.getDescripcion());
                existingGaleria.setUrlImagen(galeria.getDescripcion());
                return galeriaRepository.save(existingGaleria);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        galeriaRepository.deleteById(id);
    }
}
