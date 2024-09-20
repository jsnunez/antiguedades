package com.jsnunez.antiguedades.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.IDespacho;
import com.jsnunez.antiguedades.domain.entities.Despacho;
import com.jsnunez.antiguedades.infraestructure.repository.*;
@Service
public class DespachoService implements IDespacho {

    @Autowired
    private DespachoRepository despachoRepository;

    @Override
    public Optional<Despacho> findById(Long id) {
        return despachoRepository.findById(id);
    }

    @Override
    public List<Despacho> getAll() {
        return despachoRepository.findAll();
    }

    @Override
    public Despacho save(Despacho despacho) {
        return despachoRepository.save(despacho);
    }

    @Override
    public Despacho update(Long id, Despacho despacho) {
        return despachoRepository.findById(id)
            .map(existingDespacho -> {
                existingDespacho.setEstado(despacho.getEstado());
                existingDespacho.setFechaDespacho(despacho.getFechaDespacho());
                existingDespacho.setTransaccion(despacho.getTransaccion());
                return despachoRepository.save(existingDespacho);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        despachoRepository.deleteById(id);
    }
}
