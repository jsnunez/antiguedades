package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IEmpresa {
    Optional<Empresa> findById(Long id);
    List<Empresa> getAll();
    Empresa save(Empresa empresa);
    Empresa update(Long id, Empresa empresa);
    void deleteById(Long id);
}
