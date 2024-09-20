package com.jsnunez.antiguedades.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.ICiudad;
import com.jsnunez.antiguedades.domain.entities.Ciudad;
import com.jsnunez.antiguedades.infraestructure.repository.*;
@Service
public class CiudadService implements ICiudad {

    @Autowired
    private CiudadRepository ciudadRepository;

    @Override
    public Optional<Ciudad> findById(Long id) {
        return ciudadRepository.findById(id);
    }

    @Override
    public List<Ciudad> getAll() {
        return ciudadRepository.findAll();
    }

    @Override
    public Ciudad save(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    @Override
    public Ciudad update(Long id, Ciudad ciudad) {
        return ciudadRepository.findById(id)
            .map(existingCiudad -> {
                existingCiudad.setNombre(ciudad.getNombre());
                existingCiudad.setRegion(ciudad.getRegion());
                return ciudadRepository.save(existingCiudad);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        ciudadRepository.deleteById(id);
    }
}
