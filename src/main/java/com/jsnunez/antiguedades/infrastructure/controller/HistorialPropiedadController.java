package com.jsnunez.antiguedades.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsnunez.antiguedades.domain.entities.HistorialPropiedad;

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

import com.jsnunez.antiguedades.aplication.service.IHistorialPropiedad;
@RestController
@RequestMapping("/api/historial-propiedades")
public class HistorialPropiedadController {
    @Autowired
    private IHistorialPropiedad iHistorialPropiedad;

    @GetMapping
    public List<HistorialPropiedad> list() {
        return iHistorialPropiedad.getAll();
    }

    @GetMapping("/{id}")
    public Optional<HistorialPropiedad> show(@PathVariable Long id) {
        return iHistorialPropiedad.findById(id);
    }

    @PostMapping
    public ResponseEntity<HistorialPropiedad> createHistorialPropiedad(@RequestBody HistorialPropiedad historialPropiedad) {
        return new ResponseEntity<>(iHistorialPropiedad.save(historialPropiedad), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistorialPropiedad> updateHistorialPropiedad(@PathVariable Long id, @RequestBody HistorialPropiedad historialPropiedad) {
        HistorialPropiedad updatedHistorialPropiedad = iHistorialPropiedad.update(id, historialPropiedad);
        return updatedHistorialPropiedad != null ? new ResponseEntity<>(updatedHistorialPropiedad, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistorialPropiedad(@PathVariable Long id) {
        if (iHistorialPropiedad.findById(id).isPresent()) {
            iHistorialPropiedad.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
