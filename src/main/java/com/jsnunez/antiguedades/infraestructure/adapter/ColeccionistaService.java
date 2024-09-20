package com.jsnunez.antiguedades.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.IColeccionista;
import com.jsnunez.antiguedades.domain.entities.Coleccionista;
import com.jsnunez.antiguedades.infraestructure.repository.*;
@Service
public class ColeccionistaService implements IColeccionista {

    @Autowired
    private ColeccionistaRepository coleccionistaRepository;

    @Override
    public Optional<Coleccionista> findById(Long id) {
        return coleccionistaRepository.findById(id);
    }

    @Override
    public List<Coleccionista> getAll() {
        return coleccionistaRepository.findAll();
    }

    @Override
    public Coleccionista save(Coleccionista coleccionista) {
        return coleccionistaRepository.save(coleccionista);
    }

    @Override
    public Coleccionista update(Long id, Coleccionista coleccionista) {
        return coleccionistaRepository.findById(id)
            .map(existingColeccionista -> {
                existingColeccionista.setCantidadCompras(coleccionista.getCantidadCompras());
                existingColeccionista.setTotalCompras(coleccionista.getTotalCompras());
                existingColeccionista.setPersona(coleccionista.getPersona());
                return coleccionistaRepository.save(existingColeccionista);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        coleccionistaRepository.deleteById(id);
    }
}
