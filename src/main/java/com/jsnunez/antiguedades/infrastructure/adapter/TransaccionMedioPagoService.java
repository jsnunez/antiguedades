package com.jsnunez.antiguedades.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jsnunez.antiguedades.aplication.service.ITransaccionMedioPago;
import com.jsnunez.antiguedades.domain.entities.TransaccionMedioPago;
import com.jsnunez.antiguedades.infrastructure.repository.*;


@Service
public class TransaccionMedioPagoService implements ITransaccionMedioPago {

    @Autowired
    private TransaccionMedioPagoRepository transaccionMedioPagoRepository;

    @Override
    public Optional<TransaccionMedioPago> findById(Long id) {
        return transaccionMedioPagoRepository.findById(id);
    }

    @Override
    public List<TransaccionMedioPago> getAll() {
        return transaccionMedioPagoRepository.findAll();
    }

    @Override
    public TransaccionMedioPago save(TransaccionMedioPago transaccionMedioPago) {
        return transaccionMedioPagoRepository.save(transaccionMedioPago);
    }

    @Override
    public TransaccionMedioPago update(Long id, TransaccionMedioPago transaccionMedioPago) {
        return transaccionMedioPagoRepository.findById(id)
            .map(existingTransaccion -> {
                existingTransaccion.setMedioPago(transaccionMedioPago.getMedioPago());
                existingTransaccion.setTransaccion(transaccionMedioPago.getTransaccion());
                return transaccionMedioPagoRepository.save(existingTransaccion);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        transaccionMedioPagoRepository.deleteById(id);
    }
}
