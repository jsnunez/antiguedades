package com.jsnunez.antiguedades.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.IClaseContacto;
import com.jsnunez.antiguedades.domain.entities.ClaseContacto;
import com.jsnunez.antiguedades.infraestructure.repository.*;
@Service
public class ClaseContactoService implements IClaseContacto {

    @Autowired
    private ClaseContactoRepository claseContactoRepository;

    @Override
    public Optional<ClaseContacto> findById(Long id) {
        return claseContactoRepository.findById(id);
    }

    @Override
    public List<ClaseContacto> getAll() {
        return claseContactoRepository.findAll();
    }

    @Override
    public ClaseContacto save(ClaseContacto claseContacto) {
        return claseContactoRepository.save(claseContacto);
    }

    @Override
    public ClaseContacto update(Long id, ClaseContacto claseContacto) {
        return claseContactoRepository.findById(id)
            .map(existingClase -> {
                existingClase.setNombre(claseContacto.getNombre());
                return claseContactoRepository.save(existingClase);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        claseContactoRepository.deleteById(id);
    }
}
