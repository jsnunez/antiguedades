package com.jsnunez.antiguedades.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsnunez.antiguedades.aplication.service.IEmpleado;
import com.jsnunez.antiguedades.domain.entities.Empleado;
import com.jsnunez.antiguedades.infrastructure.repository.*;
@Service
public class EmpleadoService implements IEmpleado {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Optional<Empleado> findById(Long id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public List<Empleado> getAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado update(Long id, Empleado empleado) {
        return empleadoRepository.findById(id)
            .map(existingEmpleado -> {
                existingEmpleado.setNombre(empleado.getNombre());
                existingEmpleado.setApellido(empleado.getApellido());
                existingEmpleado.setPuesto(empleado.getPuesto());
                return empleadoRepository.save(existingEmpleado);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        empleadoRepository.deleteById(id);
    }
}
