package com.jsnunez.antiguedades.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsnunez.antiguedades.domain.entities.Transaccion;

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

import com.jsnunez.antiguedades.aplication.service.ITransaccion;
@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {
    @Autowired
    private ITransaccion iTransaccion;

    @GetMapping
    public List<Transaccion> list() {
        return iTransaccion.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Transaccion> show(@PathVariable Long id) {
        return iTransaccion.findById(id);
    }

    @PostMapping
    public ResponseEntity<Transaccion> createTransaccion(@RequestBody Transaccion transaccion) {
        return new ResponseEntity<>(iTransaccion.save(transaccion), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaccion> updateTransaccion(@PathVariable Long id, @RequestBody Transaccion transaccion) {
        Transaccion updatedTransaccion = iTransaccion.update(id, transaccion);
        return updatedTransaccion != null ? new ResponseEntity<>(updatedTransaccion, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaccion(@PathVariable Long id) {
        if (iTransaccion.findById(id).isPresent()) {
            iTransaccion.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
