package com.jsnunez.antiguedades.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsnunez.antiguedades.domain.entities.TipoPersona;

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

import com.jsnunez.antiguedades.aplication.service.ITipoPersona;
@RestController
@RequestMapping("/api/tipos-persona")
public class PersonaTipoController {
    @Autowired
    private ITipoPersona iPersonaTipo;

    @GetMapping
    public List<TipoPersona> list() {
        return iPersonaTipo.getAll();
    }

    @GetMapping("/{id}")
    public Optional<TipoPersona> show(@PathVariable Long id) {
        return iPersonaTipo.findById(id);
    }

    @PostMapping
    public ResponseEntity<TipoPersona> createPersonaTipo(@RequestBody TipoPersona personaTipo) {
        return new ResponseEntity<>(iPersonaTipo.save(personaTipo), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPersona> updatePersonaTipo(@PathVariable Long id, @RequestBody TipoPersona personaTipo) {
        TipoPersona updatedPersonaTipo = iPersonaTipo.update(id, personaTipo);
        return updatedPersonaTipo != null ? new ResponseEntity<>(updatedPersonaTipo, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonaTipo(@PathVariable Long id) {
        if (iPersonaTipo.findById(id).isPresent()) {
            iPersonaTipo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
