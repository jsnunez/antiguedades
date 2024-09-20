package com.jsnunez.antiguedades.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsnunez.antiguedades.domain.entities.TipoMovCaja;

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

import com.jsnunez.antiguedades.aplication.service.ITipoMovCaja;
@RestController
@RequestMapping("/api/tipos-movimiento")
public class TipoMovimientoController {
    @Autowired
    private ITipoMovCaja iTipoMovimiento;

    @GetMapping
    public List<TipoMovCaja> list() {
        return iTipoMovimiento.getAll();
    }

    @GetMapping("/{id}")
    public Optional<TipoMovCaja> show(@PathVariable Long id) {
        return iTipoMovimiento.findById(id);
    }

    @PostMapping
    public ResponseEntity<TipoMovCaja> createTipoMovimiento(@RequestBody TipoMovCaja tipoMovimiento) {
        return new ResponseEntity<>(iTipoMovimiento.save(tipoMovimiento), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoMovCaja> updateTipoMovimiento(@PathVariable Long id, @RequestBody TipoMovCaja tipoMovimiento) {
        TipoMovCaja updatedTipoMovimiento = iTipoMovimiento.update(id, tipoMovimiento);
        return updatedTipoMovimiento != null ? new ResponseEntity<>(updatedTipoMovimiento, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoMovimiento(@PathVariable Long id) {
        if (iTipoMovimiento.findById(id).isPresent()) {
            iTipoMovimiento.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
