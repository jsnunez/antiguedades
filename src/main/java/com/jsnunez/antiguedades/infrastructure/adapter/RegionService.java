package com.jsnunez.antiguedades.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.IRegion;
import com.jsnunez.antiguedades.domain.entities.Region;
import com.jsnunez.antiguedades.infrastructure.repository.*;
@Service
public class RegionService implements IRegion {

    @Autowired
    private RegionRepository regionRepository;

    @Override
    public Optional<Region> findById(Long id) {
        return regionRepository.findById(id);
    }

    @Override
    public List<Region> getAll() {
        return regionRepository.findAll();
    }

    @Override
    public Region save(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public Region update(Long id, Region region) {
        return regionRepository.findById(id)
            .map(existingRegion -> {
                existingRegion.setNombre(region.getNombre());
                existingRegion.setPais(region.getPais());
                return regionRepository.save(existingRegion);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        regionRepository.deleteById(id);
    }
}