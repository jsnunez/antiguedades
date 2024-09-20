package com.jsnunez.antiguedades.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsnunez.antiguedades.domain.entities.TransaccionMedioPago;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsnunez.antiguedades.aplication.service.ITransaccionMedioPago;@RestController
@RequestMapping("/api/transacciones-medios-pago")
public class TransaccionMedioPagoController {
    @Autowired
    private ITransaccionMedioPago iTransaccionMedioPago;

    @GetMapping
    public List<TransaccionMedioPago> list() {
        return iTransaccionMedioPago.getAll();
    }

    @GetMapping("/{id}")
    public Optional<TransaccionMedioPago> show(@PathVariable Long id) {
        return iTransaccionMedioPago.findById(id);
    }

    @PostMapping
    public ResponseEntity<TransaccionMedioPago> createTransaccionMedioPago(@RequestBody TransaccionMedioPago transaccionMedioPago) {
        return new ResponseEntity<>(iTransaccionMedioPago.save(transaccionMedioPago), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransaccionMedioPago> updateTransaccionMedioPago(@PathVariable Long id, @RequestBody TransaccionMedioPago transaccionMedioPago) {
        TransaccionMedioPago updatedTransaccionMedioPago = iTransaccionMedioPago.update(id, transaccionMedioPago);
        return updatedTransaccionMedioPago != null ? new ResponseEntity<>(updatedTransaccionMedioPago, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaccionMedioPago(@PathVariable Long id) {
        if (iTransaccionMedioPago.findById(id).isPresent()) {
            iTransaccionMedioPago.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
