package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IMovCaja {
    Optional<MovCaja> findById(Long id);
    List<MovCaja> getAll();
    MovCaja save(MovCaja movCaja);
    MovCaja update(Long id, MovCaja movCaja);
    void deleteById(Long id);
}
