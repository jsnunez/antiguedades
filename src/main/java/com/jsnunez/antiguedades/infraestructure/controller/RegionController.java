package com.jsnunez.antiguedades.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsnunez.antiguedades.domain.entities.Region;

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

import com.jsnunez.antiguedades.aplication.service.IRegion;
@RestController
@RequestMapping("/api/regions")
public class RegionController {
    @Autowired
    private IRegion iRegion;

    @GetMapping
    public List<Region> list() {
        return iRegion.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Region> show(@PathVariable Long id) {
        return iRegion.findById(id);
    }

    @PostMapping
    public ResponseEntity<Region> createRegion(@RequestBody Region region) {
        return new ResponseEntity<>(iRegion.save(region), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Region> updateRegion(@PathVariable Long id, @RequestBody Region region) {
        Region updatedRegion = iRegion.update(id, region);
        return updatedRegion != null ? new ResponseEntity<>(updatedRegion, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Long id) {
        if (iRegion.findById(id).isPresent()) {
            iRegion.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
