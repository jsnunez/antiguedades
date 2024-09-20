package com.jsnunez.antiguedades.domain.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipotransaaccion")
public class TipoTransaccion {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  private String tipo;
}
