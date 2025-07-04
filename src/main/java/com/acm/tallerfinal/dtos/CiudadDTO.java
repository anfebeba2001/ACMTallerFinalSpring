package com.acm.tallerfinal.dtos;

import lombok.Data;

@Data
public class CiudadDTO {
    private Integer idCiudad;
    private String nombre;
    private DepartamentoDTO departamento;
}