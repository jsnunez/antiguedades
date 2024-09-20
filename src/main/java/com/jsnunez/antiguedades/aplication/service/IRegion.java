package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IRegion {
    Optional<Region> findById(Long id);
    List<Region> getAll();
    Region save(Region region);
    Region update(Long id, Region region);
    void deleteById(Long id);
}

