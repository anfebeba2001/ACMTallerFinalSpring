package com.acm.tallerfinal.dtos;


import lombok.Data;

@Data
public class AlmacenProductoDTO {
    private Integer idAlmacen;
    private String nombreAlmacen;
    private Integer idProducto;
    private String nombreProducto;
    private Long stock;
}
