package com.jsnunez.antiguedades.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsnunez.antiguedades.domain.entities.EpocaAntigueda;

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

import com.jsnunez.antiguedades.aplication.service.IEpoca;
@RestController
@RequestMapping("/api/epocas")
public class EpocaAntiguedadController {
    @Autowired
    private IEpoca iEpocaAntiguedad;

    @GetMapping
    public List<EpocaAntigueda> list() {
        return iEpocaAntiguedad.getAll();
    }

    @GetMapping("/{id}")
    public Optional<EpocaAntigueda> show(@PathVariable Long id) {
        return iEpocaAntiguedad.findById(id);
    }

    @PostMapping
    public ResponseEntity<EpocaAntigueda> createEpoca(@RequestBody EpocaAntigueda epoca) {
        return new ResponseEntity<>(iEpocaAntiguedad.save(epoca), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EpocaAntigueda> updateEpoca(@PathVariable Long id, @RequestBody EpocaAntigueda epoca) {
        EpocaAntigueda updatedEpoca = iEpocaAntiguedad.update(id, epoca);
        return updatedEpoca != null ? new ResponseEntity<>(updatedEpoca, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEpoca(@PathVariable Long id) {
        if (iEpocaAntiguedad.findById(id).isPresent()) {
            iEpocaAntiguedad.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
