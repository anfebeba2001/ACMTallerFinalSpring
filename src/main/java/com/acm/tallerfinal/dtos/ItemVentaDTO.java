package com.acm.tallerfinal.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ItemVentaDTO {
    @NotNull(message = "El ID del producto no puede ser nulo")
    private Integer idProducto;

    @NotNull(message = "La cantidad no puede ser nula")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Long cantidad;
}