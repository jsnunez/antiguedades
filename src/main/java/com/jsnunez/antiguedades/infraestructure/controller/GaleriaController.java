package com.jsnunez.antiguedades.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsnunez.antiguedades.domain.entities.Galeria;

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

import com.jsnunez.antiguedades.aplication.service.IGaleria;@RestController
@RequestMapping("/api/galerias")
public class GaleriaController {
    @Autowired
    private IGaleria iGaleria;

    @GetMapping
    public List<Galeria> list() {
        return iGaleria.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Galeria> show(@PathVariable Long id) {
        return iGaleria.findById(id);
    }

    @PostMapping
    public ResponseEntity<Galeria> createGaleria(@RequestBody Galeria galeria) {
        return new ResponseEntity<>(iGaleria.save(galeria), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Galeria> updateGaleria(@PathVariable Long id, @RequestBody Galeria galeria) {
        Galeria updatedGaleria = iGaleria.update(id, galeria);
        return updatedGaleria != null ? new ResponseEntity<>(updatedGaleria, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGaleria(@PathVariable Long id) {
        if (iGaleria.findById(id).isPresent()) {
            iGaleria.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
