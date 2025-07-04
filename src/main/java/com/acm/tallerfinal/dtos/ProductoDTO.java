package com.acm.tallerfinal.dtos;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductoDTO {
    private Integer idProducto;
    private String nombre;
    private BigDecimal precio;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private List<CategoriaDTO> categorias; // Incluimos las categorías asociadas
}