package com.jsnunez.antiguedades.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.IMovCaja;
import com.jsnunez.antiguedades.domain.entities.MovCaja;
import com.jsnunez.antiguedades.infraestructure.repository.MovCajaRepository;

@Service
public class MovCajaService implements IMovCaja {

    @Autowired
    private MovCajaRepository movCajaRepository;

    @Override
    public Optional<MovCaja> findById(Long id) {
        return movCajaRepository.findById(id);
    }

    @Override
    public List<MovCaja> getAll() {
        return movCajaRepository.findAll();
    }

    @Override
    public MovCaja save(MovCaja movCaja) {
        return movCajaRepository.save(movCaja);
    }

    @Override
    public MovCaja update(Long id, MovCaja movCaja) {
        return movCajaRepository.findById(id)
            .map(existingMovCaja -> {
                existingMovCaja.setTipoMovCaja(movCaja.getTipoMovCaja());
                existingMovCaja.setMonto(movCaja.getMonto());
                existingMovCaja.setFechaMovimiento(movCaja.getFechaMovimiento());
                existingMovCaja.setTipoMovCaja(movCaja.getTipoMovCaja());
                existingMovCaja.setEstacionPago(movCaja.getEstacionPago());
                return movCajaRepository.save(existingMovCaja);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        movCajaRepository.deleteById(id);
    }
}
