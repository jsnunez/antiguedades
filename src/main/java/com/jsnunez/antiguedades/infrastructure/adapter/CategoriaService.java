package com.jsnunez.antiguedades.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.ICategoria;
import com.jsnunez.antiguedades.domain.entities.Categoria;
import com.jsnunez.antiguedades.infrastructure.repository.*;
@Service
public class CategoriaService implements ICategoria {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Long id, Categoria categoria) {
        return categoriaRepository.findById(id)
            .map(existingCategoria -> {
                existingCategoria.setNombre(categoria.getNombre());
                return categoriaRepository.save(existingCategoria);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
