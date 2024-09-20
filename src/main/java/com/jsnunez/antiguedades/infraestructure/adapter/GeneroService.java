package com.jsnunez.antiguedades.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.IGenero;
import com.jsnunez.antiguedades.domain.entities.Genero;
import com.jsnunez.antiguedades.infraestructure.repository.*;
@Service
public class GeneroService implements IGenero {

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public Optional<Genero> findById(Long id) {
        return generoRepository.findById(id);
    }

    @Override
    public List<Genero> getAll() {
        return generoRepository.findAll();
    }

    @Override
    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

    @Override
    public Genero update(Long id, Genero genero) {
        return generoRepository.findById(id)
            .map(existingGenero -> {
                existingGenero.setNombre(genero.getNombre());
                return generoRepository.save(existingGenero);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        generoRepository.deleteById(id);
    }
}
