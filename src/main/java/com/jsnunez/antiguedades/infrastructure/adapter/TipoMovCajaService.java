package com.jsnunez.antiguedades.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.ITipoMovCaja;
import com.jsnunez.antiguedades.domain.entities.TipoMovCaja;
import com.jsnunez.antiguedades.infrastructure.repository.*;
@Service
public class TipoMovCajaService implements ITipoMovCaja {

    @Autowired
    private TipoMovCajaRepository tipoMovCajaRepository;

    @Override
    public Optional<TipoMovCaja> findById(Long id) {
        return tipoMovCajaRepository.findById(id);
    }

    @Override
    public List<TipoMovCaja> getAll() {
        return tipoMovCajaRepository.findAll();
    }

    @Override
    public TipoMovCaja save(TipoMovCaja tipoMovCaja) {
        return tipoMovCajaRepository.save(tipoMovCaja);
    }

    @Override
    public TipoMovCaja update(Long id, TipoMovCaja tipoMovCaja) {
        return tipoMovCajaRepository.findById(id)
            .map(existingTipo -> {
                existingTipo.setTipo(tipoMovCaja.getTipo());
                return tipoMovCajaRepository.save(existingTipo);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        tipoMovCajaRepository.deleteById(id);
    }
}
