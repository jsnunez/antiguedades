package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IAntiguedad {
    Optional<Antiguedad> findById(Long id);
    List<Antiguedad> getAll();
    Antiguedad save(Antiguedad antiguedad);
    Antiguedad update(Long id,Antiguedad antiguedad);
    void deleteById(Long id); 
}
