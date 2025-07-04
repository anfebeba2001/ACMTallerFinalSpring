package com.acm.tallerfinal.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UsuarioCreacionDTO {
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 32, message = "El nombre no puede tener más de 32 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(max = 32, message = "El apellido no puede tener más de 32 caracteres")
    private String apellido;

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    private String username;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El formato del email no es válido")
    private String email;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Pattern(regexp = "^\\d{10}$", message = "El teléfono debe tener 10 dígitos")
    private String telefono;

    @NotNull(message = "El ID del rol no puede ser nulo")
    private Integer idRol;

    @NotNull(message = "El ID de la ciudad no puede ser nulo")
    private Integer idCiudad;
}