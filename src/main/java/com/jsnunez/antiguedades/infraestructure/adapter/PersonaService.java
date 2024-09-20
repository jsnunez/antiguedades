package com.jsnunez.antiguedades.infraestructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.IPersona;
import com.jsnunez.antiguedades.domain.entities.Persona;
import com.jsnunez.antiguedades.infraestructure.repository.*;
@Service
public class PersonaService implements IPersona {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Optional<Persona> findById(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    @Override
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona update(Long id, Persona persona) {
        return personaRepository.findById(id)
            .map(existingPersona -> {
                existingPersona.setNombre(persona.getNombre());
                existingPersona.setApellido(persona.getApellido());
                existingPersona.setEmail(persona.getEmail());
                return personaRepository.save(existingPersona);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }
}
