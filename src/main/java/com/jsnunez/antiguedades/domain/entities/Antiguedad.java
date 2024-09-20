package com.jsnunez.antiguedades.domain.entities;

import java.util.Date;

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
@Table(name = "antiguedades")
public class Antiguedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String descripcion;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private long precio;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String estadoConservacion;

    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Persona propietario;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "epoca_id")
    private EpocaAntigueda epocaAntigueda;
   
}
