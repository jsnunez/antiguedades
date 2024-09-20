package com.jsnunez.antiguedades.infrastructure.adapter;

import java.util.List;

import com.jsnunez.antiguedades.aplication.service.IVenta;
import com.jsnunez.antiguedades.domain.DTO.ClienteDTO;
import com.jsnunez.antiguedades.domain.DTO.VentaDTO;

public class VentasService implements IVenta{

    @Override
    public List<VentaDTO> obtenerHistorialVentasPorCliente(Long clienteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerHistorialVentasPorCliente'");
    }

    @Override
    public double calcularTotalVentas(String inicio, String fin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularTotalVentas'");
    }

    @Override
    public List<ClienteDTO> obtenerClientesMasActivos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerClientesMasActivos'");
    }

    @Override
    public List<VentaDTO> listarAntiguedadesVendidas(String desde, String hasta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarAntiguedadesVendidas'");
    }

}
