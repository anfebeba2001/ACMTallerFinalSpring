package com.acm.tallerfinal.Mappers;

import com.acm.tallerfinal.dtos.RolUsuarioDTO;
import com.acm.tallerfinal.entity.RolUsuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolUsuarioMapper {
    RolUsuarioDTO toDto(RolUsuario rolUsuario);
    RolUsuario toEntity(RolUsuarioDTO rolUsuarioDTO);
}