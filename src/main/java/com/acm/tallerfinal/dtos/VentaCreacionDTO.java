package com.acm.tallerfinal.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

@Data
public class VentaCreacionDTO {
    @NotNull(message = "El ID del cliente no puede ser nulo")
    private Integer idCliente;

    @NotEmpty(message = "La lista de ítems no puede estar vacía")
    private List<@Valid ItemVentaDTO> items; // @Valid para validar los objetos de la lista
}