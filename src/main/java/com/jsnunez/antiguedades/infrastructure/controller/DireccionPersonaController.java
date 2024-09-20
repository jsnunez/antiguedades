package com.jsnunez.antiguedades.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsnunez.antiguedades.domain.entities.DireccionPersona;

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

import com.jsnunez.antiguedades.aplication.service.IDireccionPersona;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionPersonaController {
    @Autowired
    private IDireccionPersona iDireccionPersona;

    @GetMapping
    public List<DireccionPersona> list() {
        return iDireccionPersona.getAll();
    }

    @GetMapping("/{id}")
    public Optional<DireccionPersona> show(@PathVariable Long id) {
        return iDireccionPersona.findById(id);
    }

    @PostMapping
    public ResponseEntity<DireccionPersona> createDireccion(@RequestBody DireccionPersona direccion) {
        return new ResponseEntity<>(iDireccionPersona.save(direccion), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DireccionPersona> updateDireccion(@PathVariable Long id, @RequestBody DireccionPersona direccion) {
        DireccionPersona updatedDireccion = iDireccionPersona.update(id, direccion);
        return updatedDireccion != null ? new ResponseEntity<>(updatedDireccion, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDireccion(@PathVariable Long id) {
        if (iDireccionPersona.findById(id).isPresent()) {
            iDireccionPersona.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
