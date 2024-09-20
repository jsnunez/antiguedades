package com.jsnunez.antiguedades.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsnunez.antiguedades.domain.entities.Coleccionista;

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

import com.jsnunez.antiguedades.aplication.service.IColeccionista;
@RestController
@RequestMapping("/api/coleccionistas")
public class ColeccionistaController {
    @Autowired
    private IColeccionista iColeccionista;

    @GetMapping
    public List<Coleccionista> list() {
        return iColeccionista.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Coleccionista> show(@PathVariable Long id) {
        return iColeccionista.findById(id);
    }

    @PostMapping
    public ResponseEntity<Coleccionista> createColeccionista(@RequestBody Coleccionista coleccionista) {
        return new ResponseEntity<>(iColeccionista.save(coleccionista), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coleccionista> updateColeccionista(@PathVariable Long id, @RequestBody Coleccionista coleccionista) {
        Coleccionista updatedColeccionista = iColeccionista.update(id, coleccionista);
        return updatedColeccionista != null ? new ResponseEntity<>(updatedColeccionista, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColeccionista(@PathVariable Long id) {
        if (iColeccionista.findById(id).isPresent()) {
            iColeccionista.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
