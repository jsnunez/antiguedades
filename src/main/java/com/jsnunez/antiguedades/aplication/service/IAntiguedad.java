package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.DTO.AntiguedadDTO;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;
import java.util.Map;


public interface IAntiguedad {
    Optional<Antiguedad> findById(Long id);
    List<Antiguedad> getAll();
    Antiguedad save(Antiguedad antiguedad);
    Antiguedad update(Long id,Antiguedad antiguedad);
    void deleteById(Long id); 

    List<AntiguedadDTO> listarDisponibles();
    List<AntiguedadDTO> buscarPorCategoriaYPrecio(String categoria, double precioMinimo, double precioMaximo);
    List<AntiguedadDTO> listarPopulares();
    Map<String, Integer> generarInformeInventario();
}
