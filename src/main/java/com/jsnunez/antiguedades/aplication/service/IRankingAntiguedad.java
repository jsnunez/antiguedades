package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IRankingAntiguedad {
    Optional<RankingAntiguedad> findById(Long id);
    List<RankingAntiguedad> getAll();
    RankingAntiguedad save(RankingAntiguedad rankingAntiguedad);
    RankingAntiguedad update(Long id, RankingAntiguedad rankingAntiguedad);
    void deleteById(Long id);
}
