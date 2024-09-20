package com.jsnunez.antiguedades.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "coleccionistas")
public class Coleccionista {
    
 
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne 
    private Persona persona;
    @Column(columnDefinition = "INT", nullable = false)
    int canidadCompras;
    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    double totalCompras;
    
    
    // Getters y Setters
}

