package com.jsnunez.antiguedades.domain.entities;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "transacciones")
public class Transaccion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name = "comprador_id")
    private Persona comprador;
    
    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Persona vendedor;
    
    private Double monto;
    
    @ManyToOne
    @JoinColumn(name = "estacionPago_id")
    private EstacionPago estacionPago;

    @ManyToOne
    @JoinColumn(name = "tipoTransaccion_id")
    private TipoTransaccion tipoTransaccion;

    // Getters y Setters
}

