package com.jsnunez.antiguedades.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.ITransaccion;
import com.jsnunez.antiguedades.domain.entities.Transaccion;
import com.jsnunez.antiguedades.infrastructure.repository.*;
@Service
public class TransaccionService implements ITransaccion {

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Override
    public Optional<Transaccion> findById(Long id) {
        return transaccionRepository.findById(id);
    }

    @Override
    public List<Transaccion> getAll() {
        return transaccionRepository.findAll();
    }

    @Override
    public Transaccion save(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    @Override
    public Transaccion update(Long id, Transaccion transaccion) {
        return transaccionRepository.findById(id)
            .map(existingTransaccion -> {
                existingTransaccion.setFecha(transaccion.getFecha());
                existingTransaccion.setMonto(transaccion.getMonto());
                existingTransaccion.setComprador(transaccion.getComprador());
                existingTransaccion.setVendedor(transaccion.getVendedor());
                return transaccionRepository.save(existingTransaccion);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        transaccionRepository.deleteById(id);
    }
}
