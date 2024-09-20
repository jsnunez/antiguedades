package com.jsnunez.antiguedades.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsnunez.antiguedades.domain.entities.Despacho;

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

import com.jsnunez.antiguedades.aplication.service.IDespacho;
@RestController
@RequestMapping("/api/despachos")
public class DespachoController {
    @Autowired
    private IDespacho iDespacho;

    @GetMapping
    public List<Despacho> list() {
        return iDespacho.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Despacho> show(@PathVariable Long id) {
        return iDespacho.findById(id);
    }

    @PostMapping
    public ResponseEntity<Despacho> createDespacho(@RequestBody Despacho despacho) {
        return new ResponseEntity<>(iDespacho.save(despacho), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Despacho> updateDespacho(@PathVariable Long id, @RequestBody Despacho despacho) {
        Despacho updatedDespacho = iDespacho.update(id, despacho);
        return updatedDespacho != null ? new ResponseEntity<>(updatedDespacho, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDespacho(@PathVariable Long id) {
        if (iDespacho.findById(id).isPresent()) {
            iDespacho.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
