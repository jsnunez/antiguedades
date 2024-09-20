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
@Table(name = "despachos")
public class Despacho {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String estado;
    
    @Temporal(TemporalType.DATE)
    private Date fechaDespacho;
    
    @ManyToOne
    @JoinColumn(name = "transaccion_id")
    private Transaccion transaccion;

}
