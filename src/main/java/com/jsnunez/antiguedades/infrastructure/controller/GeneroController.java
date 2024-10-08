package com.jsnunez.antiguedades.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsnunez.antiguedades.domain.entities.Genero;

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

import com.jsnunez.antiguedades.aplication.service.IGenero;
@RestController
@RequestMapping("/api/generos")
public class GeneroController {
    @Autowired
    private IGenero iGenero;

    @GetMapping
    public List<Genero> list() {
        return iGenero.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Genero> show(@PathVariable Long id) {
        return iGenero.findById(id);
    }

    @PostMapping
    public ResponseEntity<Genero> createGenero(@RequestBody Genero genero) {
        return new ResponseEntity<>(iGenero.save(genero), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genero> updateGenero(@PathVariable Long id, @RequestBody Genero genero) {
        Genero updatedGenero = iGenero.update(id, genero);
        return updatedGenero != null ? new ResponseEntity<>(updatedGenero, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenero(@PathVariable Long id) {
        if (iGenero.findById(id).isPresent()) {
            iGenero.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
