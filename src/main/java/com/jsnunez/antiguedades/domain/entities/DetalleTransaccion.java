package com.jsnunez.antiguedades.domain.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class DetalleTransaccion {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transaccion_id")
    private Transaccion transaccion;   
    @ManyToOne
    @JoinColumn(name = "antiguedad_id")
    private Antiguedad antiguedad;
   
}
