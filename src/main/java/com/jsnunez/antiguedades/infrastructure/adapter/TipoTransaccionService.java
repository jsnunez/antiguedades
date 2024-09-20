package com.jsnunez.antiguedades.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.ITipoTransaccion;
import com.jsnunez.antiguedades.domain.entities.TipoTransaccion;
import com.jsnunez.antiguedades.infrastructure.repository.*;
@Service
public class TipoTransaccionService implements ITipoTransaccion {

    @Autowired
    private TipoTransaccionRepository tipoTransaccionRepository;

    @Override
    public Optional<TipoTransaccion> findById(Long id) {
        return tipoTransaccionRepository.findById(id);
    }

    @Override
    public List<TipoTransaccion> getAll() {
        return tipoTransaccionRepository.findAll();
    }

    @Override
    public TipoTransaccion save(TipoTransaccion tipoTransaccion) {
        return tipoTransaccionRepository.save(tipoTransaccion);
    }

    @Override
    public TipoTransaccion update(Long id, TipoTransaccion tipoTransaccion) {
        return tipoTransaccionRepository.findById(id)
            .map(existingTipo -> {
                existingTipo.setTipo(tipoTransaccion.getTipo());
                return tipoTransaccionRepository.save(existingTipo);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        tipoTransaccionRepository.deleteById(id);
    }
}
