package com.jsnunez.antiguedades.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsnunez.antiguedades.domain.entities.TipoTransaccion;

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

import com.jsnunez.antiguedades.aplication.service.ITipoTransaccion;
@RestController
@RequestMapping("/api/tipos-transaccion")
public class TipoTransaccionController {
    @Autowired
    private ITipoTransaccion iTipoTransaccion;

    @GetMapping
    public List<TipoTransaccion> list() {
        return iTipoTransaccion.getAll();
    }

    @GetMapping("/{id}")
    public Optional<TipoTransaccion> show(@PathVariable Long id) {
        return iTipoTransaccion.findById(id);
    }

    @PostMapping
    public ResponseEntity<TipoTransaccion> createTipoTransaccion(@RequestBody TipoTransaccion tipoTransaccion) {
        return new ResponseEntity<>(iTipoTransaccion.save(tipoTransaccion), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoTransaccion> updateTipoTransaccion(@PathVariable Long id, @RequestBody TipoTransaccion tipoTransaccion) {
        TipoTransaccion updatedTipoTransaccion = iTipoTransaccion.update(id, tipoTransaccion);
        return updatedTipoTransaccion != null ? new ResponseEntity<>(updatedTipoTransaccion, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoTransaccion(@PathVariable Long id) {
        if (iTipoTransaccion.findById(id).isPresent()) {
            iTipoTransaccion.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
