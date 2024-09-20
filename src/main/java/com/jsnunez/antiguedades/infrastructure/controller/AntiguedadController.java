package com.jsnunez.antiguedades.infrastructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.jsnunez.antiguedades.domain.DTO.AntiguedadDTO;
import com.jsnunez.antiguedades.domain.DTO.ClienteDTO;
import com.jsnunez.antiguedades.domain.DTO.VentaDTO;
import com.jsnunez.antiguedades.domain.entities.Antiguedad;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsnunez.antiguedades.aplication.service.IAntiguedad;
import com.jsnunez.antiguedades.aplication.service.IVenta;

@RestController
@RequestMapping("/api/antiguedades")
public class AntiguedadController {
    @Autowired
    private IAntiguedad iAntiguedad;

    @GetMapping
    public List<Antiguedad> list() {
return iAntiguedad.getAll();    }

    @GetMapping("/{id}")
    public Optional<Antiguedad> show(@PathVariable Long id) {
        return iAntiguedad.findById(id);
    }

    @PostMapping
    public ResponseEntity<Antiguedad> createAntiguedad(@RequestBody Antiguedad antiguedad) {
        return new ResponseEntity<>(iAntiguedad.save(antiguedad), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Antiguedad> updateAntiguedad(@PathVariable Long id, @RequestBody Antiguedad antiguedad) {
        Antiguedad updatedAntiguedad = iAntiguedad.update(id, antiguedad);
        return updatedAntiguedad != null ? new ResponseEntity<>(updatedAntiguedad, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAntiguedad(@PathVariable Long id) {
        if (iAntiguedad.findById(id).isPresent()) {
            iAntiguedad.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @Autowired
    // private IVenta iVenta; // Suponiendo que tienes un servicio para manejar ventas

    @GetMapping("/disponibles")
    public List<Antiguedad> listarAntiguedadesDisponibles() {
        return iAntiguedad.listarDisponibles();
    }

    @GetMapping("/categoria/{categoria}/rango-precio")
    public List<Antiguedad> buscarPorCategoriaYPrecio(
            @PathVariable int categoria,
            @RequestParam Long precioMinimo,
            @RequestParam Long precioMaximo) {
        return iAntiguedad.buscarPorCategoriaYPrecio(categoria, precioMinimo, precioMaximo);
    }

    // @GetMapping("/historial-ventas/{clienteId}")
    // public List<VentaDTO> mostrarHistorialVentas(@PathVariable Long clienteId) {
    //     return iVenta.obtenerHistorialVentasPorCliente(clienteId);
    // }

    // @GetMapping("/total-ventas")
    // public double totalVentasEnPeriodo(@RequestParam  String inicio,
    //                                     @RequestParam  String fin) {
    //     return iVenta.calcularTotalVentas(inicio, fin);
    // }

    // @GetMapping("/clientes-activos")
    // public List<ClienteDTO> clientesMasActivos() {
    //     return iVenta.obtenerClientesMasActivos();
    // }

    // @GetMapping("/populares")
    // public List<AntiguedadDTO> listarAntiguedadesPopulares() {
    //     return iAntiguedad.listarPopulares();
    // }

    // @GetMapping("/vendidas")
    // public List<VentaDTO> listarAntiguedadesVendidas(
    //         @RequestParam String desde,
    //         @RequestParam String hasta) {
    //     return iVenta.listarAntiguedadesVendidas(desde, hasta);
    // }

    // @GetMapping("/inventario")
    // public Map<String, Integer> informeInventario() {
    //     return iAntiguedad.generarInformeInventario();
    // }
}


