package com.jsnunez.antiguedades.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.IContactoPersona;
import com.jsnunez.antiguedades.domain.entities.ContactoPersona;
import com.jsnunez.antiguedades.infrastructure.repository.*;
@Service
public class ContactoPersonaService implements IContactoPersona {

    @Autowired
    private ContactoPersonaRepository contactoPersonaRepository;

    @Override
    public Optional<ContactoPersona> findById(Long id) {
        return contactoPersonaRepository.findById(id);
    }

    @Override
    public List<ContactoPersona> getAll() {
        return contactoPersonaRepository.findAll();
    }

    @Override
    public ContactoPersona save(ContactoPersona contactoPersona) {
        return contactoPersonaRepository.save(contactoPersona);
    }

    @Override
    public ContactoPersona update(Long id, ContactoPersona contactoPersona) {
        return contactoPersonaRepository.findById(id)
            .map(existingContacto -> {
                existingContacto.setNumero(contactoPersona.getNumero());
                existingContacto.setPersona(contactoPersona.getPersona());
                existingContacto.setClaseContacto(contactoPersona.getClaseContacto());
                return contactoPersonaRepository.save(existingContacto);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        contactoPersonaRepository.deleteById(id);
    }
}
