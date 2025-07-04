package com.acm.tallerfinal.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductoCreacionDTO {
    @NotBlank(message = "El nombre del producto no puede estar vacío")
    @Size(max = 32)
    private String nombre;

    @NotNull(message = "El precio no puede ser nulo")
    @Positive(message = "El precio debe ser un valor positivo")
    private BigDecimal precio;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    @NotEmpty(message = "El producto debe tener al menos una categoría")
    private List<Integer> idsCategorias;
}