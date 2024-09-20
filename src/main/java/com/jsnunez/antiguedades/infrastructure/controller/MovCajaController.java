package com.jsnunez.antiguedades.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsnunez.antiguedades.domain.entities.MovCaja;

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

import com.jsnunez.antiguedades.aplication.service.IMovCaja;
@RestController
@RequestMapping("/api/movimientos-caja")
public class MovCajaController {
    @Autowired
    private IMovCaja iMovCaja;

    @GetMapping
    public List<MovCaja> list() {
        return iMovCaja.getAll();
    }

    @GetMapping("/{id}")
    public Optional<MovCaja> show(@PathVariable Long id) {
        return iMovCaja.findById(id);
    }

    @PostMapping
    public ResponseEntity<MovCaja> createMovimiento(@RequestBody MovCaja movimiento) {
        return new ResponseEntity<>(iMovCaja.save(movimiento), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovCaja> updateMovimiento(@PathVariable Long id, @RequestBody MovCaja movimiento) {
        MovCaja updatedMovimiento = iMovCaja.update(id, movimiento);
        return updatedMovimiento != null ? new ResponseEntity<>(updatedMovimiento, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable Long id) {
        if (iMovCaja.findById(id).isPresent()) {
            iMovCaja.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
