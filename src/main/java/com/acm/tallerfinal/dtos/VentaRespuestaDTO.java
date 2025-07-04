package com.acm.tallerfinal.dtos;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class VentaRespuestaDTO {
    private Integer idVenta;
    private LocalDateTime fechaVenta;
    private BigDecimal total;
    private String clienteUsername;
    private List<VentaDetalleDTO> detalle;
}