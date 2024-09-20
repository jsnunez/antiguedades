package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IPersonaTipoPersona {
    Optional<PersonaTipoPersona> findById(Long id);
    List<PersonaTipoPersona> getAll();
    PersonaTipoPersona save(PersonaTipoPersona personaTipoPersona);
    PersonaTipoPersona update(Long id, PersonaTipoPersona personaTipoPersona);
    void deleteById(Long id);
}
