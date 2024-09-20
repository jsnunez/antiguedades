package com.jsnunez.antiguedades.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsnunez.antiguedades.domain.entities.Antiguedad;

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

import com.jsnunez.antiguedades.aplication.service.IAntiguedad;

@RestController
@RequestMapping("/api/antiguedades")
public class AntiguedadController {
    @Autowired
    private IAntiguedad iAntiguedad;

    @GetMapping
    public List<Antiguedad> list() {
return iAntiguedad.getAll();    }

    @GetMapping("/{id}")
    public Optional<Antiguedad> show(@PathVariable Long id) {
        return iAntiguedad.findById(id);
    }

    @PostMapping
    public ResponseEntity<Antiguedad> createAntiguedad(@RequestBody Antiguedad antiguedad) {
        return new ResponseEntity<>(iAntiguedad.save(antiguedad), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Antiguedad> updateAntiguedad(@PathVariable Long id, @RequestBody Antiguedad antiguedad) {
        Antiguedad updatedAntiguedad = iAntiguedad.update(id, antiguedad);
        return updatedAntiguedad != null ? new ResponseEntity<>(updatedAntiguedad, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAntiguedad(@PathVariable Long id) {
        if (iAntiguedad.findById(id).isPresent()) {
            iAntiguedad.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
