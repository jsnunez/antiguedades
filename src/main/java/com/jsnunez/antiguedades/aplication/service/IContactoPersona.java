package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IContactoPersona {
    Optional<ContactoPersona> findById(Long id);
    List<ContactoPersona> getAll();
    ContactoPersona save(ContactoPersona contactoPersona);
    ContactoPersona update(Long id, ContactoPersona contactoPersona);
    void deleteById(Long id);
}

