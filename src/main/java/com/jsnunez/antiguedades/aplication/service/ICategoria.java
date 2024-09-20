package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface ICategoria {
    Optional<Categoria> findById(Long id);
    List<Categoria> getAll();
    Categoria save(Categoria categoria);
    Categoria update(Long id, Categoria categoria);
    void deleteById(Long id);
}
