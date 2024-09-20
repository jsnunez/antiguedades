package com.jsnunez.antiguedades.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jsnunez.antiguedades.domain.entities.RankingAntiguedad;

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

import com.jsnunez.antiguedades.aplication.service.IRankingAntiguedad;
@RestController
@RequestMapping("/api/ranking-antiguedades")
public class RankingAntiguedadController {
    @Autowired
    private IRankingAntiguedad iRankingAntiguedad;

    @GetMapping
    public List<RankingAntiguedad> list() {
        return iRankingAntiguedad.getAll();
    }

    @GetMapping("/{id}")
    public Optional<RankingAntiguedad> show(@PathVariable Long id) {
        return iRankingAntiguedad.findById(id);
    }

    @PostMapping
    public ResponseEntity<RankingAntiguedad> createRanking(@RequestBody RankingAntiguedad ranking) {
        return new ResponseEntity<>(iRankingAntiguedad.save(ranking), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RankingAntiguedad> updateRanking(@PathVariable Long id, @RequestBody RankingAntiguedad ranking) {
        RankingAntiguedad updatedRanking = iRankingAntiguedad.update(id, ranking);
        return updatedRanking != null ? new ResponseEntity<>(updatedRanking, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRanking(@PathVariable Long id) {
        if (iRankingAntiguedad.findById(id).isPresent()) {
            iRankingAntiguedad.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
