package com.jsnunez.antiguedades.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.IMedioPago;
import com.jsnunez.antiguedades.domain.entities.MedioPago;
import com.jsnunez.antiguedades.infraestructure.repository.*;

@Service
public class MedioPagoService implements IMedioPago {

    @Autowired
    private MedioPagoRepository medioPagoRepository;

    @Override
    public Optional<MedioPago> findById(Long id) {
        return medioPagoRepository.findById(id);
    }

    @Override
    public List<MedioPago> getAll() {
        return medioPagoRepository.findAll();
    }

    @Override
    public MedioPago save(MedioPago medioPago) {
        return medioPagoRepository.save(medioPago);
    }

    @Override
    public MedioPago update(Long id, MedioPago medioPago) {
        return medioPagoRepository.findById(id)
            .map(existingMedio -> {
                existingMedio.setTipo(medioPago.getTipo());
                return medioPagoRepository.save(existingMedio);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        medioPagoRepository.deleteById(id);
    }
}
