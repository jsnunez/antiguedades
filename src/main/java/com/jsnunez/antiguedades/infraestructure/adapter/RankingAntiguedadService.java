package com.jsnunez.antiguedades.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.IRankingAntiguedad;
import com.jsnunez.antiguedades.domain.entities.RankingAntiguedad;
import com.jsnunez.antiguedades.infraestructure.repository.*;

@Service
public class RankingAntiguedadService implements IRankingAntiguedad {

    @Autowired
    private RankingAntiguedadRepository rankingAntiguedadRepository;

    @Override
    public Optional<RankingAntiguedad> findById(Long id) {
        return rankingAntiguedadRepository.findById(id);
    }

    @Override
    public List<RankingAntiguedad> getAll() {
        return rankingAntiguedadRepository.findAll();
    }

    @Override
    public RankingAntiguedad save(RankingAntiguedad rankingAntiguedad) {
        return rankingAntiguedadRepository.save(rankingAntiguedad);
    }

    @Override
    public RankingAntiguedad update(Long id, RankingAntiguedad rankingAntiguedad) {
        return rankingAntiguedadRepository.findById(id)
            .map(existingRanking -> {
                existingRanking.setNombre(rankingAntiguedad.getNombre());
                existingRanking.setAntiguedad(rankingAntiguedad.getAntiguedad());
                return rankingAntiguedadRepository.save(existingRanking);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        rankingAntiguedadRepository.deleteById(id);
    }
}

