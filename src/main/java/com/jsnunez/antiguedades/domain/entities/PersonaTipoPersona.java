package com.jsnunez.antiguedades.domain.entities;


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
@Table(name = "personatipopersona")
public class PersonaTipoPersona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
    
    @ManyToOne
    @JoinColumn(name = "tipopersona_id")
    private TipoPersona tipoPersona;

    
}
