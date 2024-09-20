package com.jsnunez.antiguedades.domain.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "galeria")
public class Galeria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String urlImagen;
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name = "antiguedad_id")
    private Antiguedad antiguedad;

}
