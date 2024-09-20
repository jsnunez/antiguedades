package com.jsnunez.antiguedades.aplication.service;
import com.jsnunez.antiguedades.domain.entities.*;

import java.util.List;
import java.util.Optional;

public interface IEmpleado {
    Optional<Empleado> findById(Long id);
    List<Empleado> getAll();
    Empleado save(Empleado empleado);
    Empleado update(Long id, Empleado empleado);
    void deleteById(Long id);
}
