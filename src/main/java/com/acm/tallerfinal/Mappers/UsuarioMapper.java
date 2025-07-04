package com.acm.tallerfinal.Mappers;

import com.acm.tallerfinal.dtos.UsuarioCreacionDTO;
import com.acm.tallerfinal.dtos.UsuarioDTO;
import com.acm.tallerfinal.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RolUsuarioMapper.class, CiudadMapper.class})
public interface UsuarioMapper {

    UsuarioDTO toDto(Usuario usuario);

    // Ignoramos campos que se manejarán en la capa de servicio
    @Mapping(target = "idUsuario", ignore = true)
    @Mapping(target = "password", ignore = true) // La contraseña se codifica y asigna en el servicio
    @Mapping(target = "fechaRegistro", ignore = true)
    @Mapping(target = "rol", ignore = true) // El objeto Rol se asigna en el servicio
    @Mapping(target = "ciudad", ignore = true) // El objeto Ciudad se asigna en el servicio
    Usuario toEntity(UsuarioCreacionDTO usuarioCreacionDTO);
}