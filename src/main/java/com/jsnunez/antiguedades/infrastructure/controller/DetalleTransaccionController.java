package com.jsnunez.antiguedades.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsnunez.antiguedades.domain.entities.DetalleTransaccion;
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

import com.jsnunez.antiguedades.aplication.service.IDetalleTransaccion;
@RestController
@RequestMapping("/api/detalle-transacciones")
public class DetalleTransaccionController {
    @Autowired
    private IDetalleTransaccion iDetalleTransaccion;

    @GetMapping
    public List<DetalleTransaccion> list() {
        return iDetalleTransaccion.getAll();
    }

    @GetMapping("/{id}")
    public Optional<DetalleTransaccion> show(@PathVariable Long id) {
        return iDetalleTransaccion.findById(id);
    }

    @PostMapping
    public ResponseEntity<DetalleTransaccion> createDetalleTransaccion(@RequestBody DetalleTransaccion detalleTransaccion) {
        return new ResponseEntity<>(iDetalleTransaccion.save(detalleTransaccion), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleTransaccion> updateDetalleTransaccion(@PathVariable Long id, @RequestBody DetalleTransaccion detalleTransaccion) {
        DetalleTransaccion updatedDetalle = iDetalleTransaccion.update(id, detalleTransaccion);
        return updatedDetalle != null ? new ResponseEntity<>(updatedDetalle, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalleTransaccion(@PathVariable Long id) {
        if (iDetalleTransaccion.findById(id).isPresent()) {
            iDetalleTransaccion.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
