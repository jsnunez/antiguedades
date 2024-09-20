package com.jsnunez.antiguedades.domain.entities;

import java.sql.Date;

import jakarta.persistence.Column;
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
@Table(name = "movcaja")
public class MovCaja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private long monto;

    @Temporal(TemporalType.DATE)
    private Date fechaMovimiento;
    @ManyToOne
    @JoinColumn(name = "tipoMovimiento_id")
    private TipoMovCaja tipoMovCaja;

    @ManyToOne
    @JoinColumn(name = "estacionPago_id")
    private EstacionPago estacionPago;

}
