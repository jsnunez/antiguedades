package com.jsnunez.antiguedades.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsnunez.antiguedades.domain.entities.Pais;

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

import com.jsnunez.antiguedades.aplication.service.IPais;
@RestController
@RequestMapping("/api/paises")
public class PaisController {
    @Autowired
    private IPais iPais;

    @GetMapping
    public List<Pais> list() {
        return iPais.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Pais> show(@PathVariable Long id) {
        return iPais.findById(id);
    }

    @PostMapping
    public ResponseEntity<Pais> createPais(@RequestBody Pais pais) {
        return new ResponseEntity<>(iPais.save(pais), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pais> updatePais(@PathVariable Long id, @RequestBody Pais pais) {
        Pais updatedPais = iPais.update(id, pais);
        return updatedPais != null ? new ResponseEntity<>(updatedPais, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePais(@PathVariable Long id) {
        if (iPais.findById(id).isPresent()) {
            iPais.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
