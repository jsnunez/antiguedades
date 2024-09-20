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
@Table(name = "historialpropiedad")
public class HistorialPropiedad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Date fechaCambio;
    
    @ManyToOne
    @JoinColumn(name = "antiguedad_id")
    private Antiguedad antiguedad;
    
    @ManyToOne
    @JoinColumn(name = "propietarioAnterior_id")
    private Persona propietarioAnterior;
    
    @ManyToOne
    @JoinColumn(name = "propietarioActual_id")
    private Persona propietarioActual;


}

