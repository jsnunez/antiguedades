package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IEpoca {
    Optional<EpocaAntigueda> findById(Long id);
    List<EpocaAntigueda> getAll();
    EpocaAntigueda save(EpocaAntigueda antiguedad);
    EpocaAntigueda update(Long id,EpocaAntigueda antiguedad);
    void deleteById(Long id); 
}
