package com.jsnunez.antiguedades.domain.entities;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "empleado")
public class Empleado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String apellido;
    
    @Temporal(TemporalType.DATE)
    private Date fechaContratacion;
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String puesto;
    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private Long salario;
    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private long comision;

      @OneToOne 
    private Persona persona;
    
}
