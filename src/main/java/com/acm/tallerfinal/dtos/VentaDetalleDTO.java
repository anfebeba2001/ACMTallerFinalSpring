package com.acm.tallerfinal.dtos;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class VentaDetalleDTO {
    private Integer idProducto;
    private String nombreProducto;
    private BigDecimal precioUnitario;
    private Long cantidad;
    private BigDecimal subtotal;
}