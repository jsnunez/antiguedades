package com.jsnunez.antiguedades.domain.DTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AntiguedadDTO {
    private String nombre;
    private String categoria;
    private double precio;
    private String estadoConservacion;

}
