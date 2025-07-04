package com.acm.tallerfinal.dtos;
import lombok.Data;

@Data
public class AlmacenDTO {
    private Integer idAlmacen;
    private String nombre;
    private CiudadDTO ciudad;
}