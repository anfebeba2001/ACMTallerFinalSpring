package com.acm.tallerfinal.dtos;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UsuarioDTO {
    private Integer idUsuario;
    private String nombre;
    private String apellido;
    private String username;
    private String email;
    private LocalDateTime fechaRegistro;
    private String telefono;
    private RolUsuarioDTO rol;
    private CiudadDTO ciudad;
}