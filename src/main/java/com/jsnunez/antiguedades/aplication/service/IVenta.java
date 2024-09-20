package com.jsnunez.antiguedades.aplication.service;
import java.util.List;
import com.jsnunez.antiguedades.domain.DTO.*;
public interface IVenta {
    List<VentaDTO> obtenerHistorialVentasPorCliente(Long clienteId);
    double calcularTotalVentas(String inicio, String fin);
    List<ClienteDTO> obtenerClientesMasActivos();
    List<VentaDTO> listarAntiguedadesVendidas(String desde, String hasta);
}
