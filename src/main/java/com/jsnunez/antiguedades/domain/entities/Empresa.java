package com.jsnunez.antiguedades.domain.entities;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "empresa")
public class Empresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private String nombre;
    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private String nit;

    @OneToMany(mappedBy = "empresa")
    private List<Sucursal> sucursales;

}
