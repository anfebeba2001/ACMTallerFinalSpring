package com.acm.tallerfinal.Mappers;

import com.acm.tallerfinal.dtos.RolUsuarioDTO;
import com.acm.tallerfinal.entity.RolUsuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-03T21:51:11-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class RolUsuarioMapperImpl implements RolUsuarioMapper {

    @Override
    public RolUsuarioDTO toDto(RolUsuario rolUsuario) {
        if ( rolUsuario == null ) {
            return null;
        }

        RolUsuarioDTO rolUsuarioDTO = new RolUsuarioDTO();

        rolUsuarioDTO.setIdRol( rolUsuario.getIdRol() );
        rolUsuarioDTO.setRol( rolUsuario.getRol() );

        return rolUsuarioDTO;
    }

    @Override
    public RolUsuario toEntity(RolUsuarioDTO rolUsuarioDTO) {
        if ( rolUsuarioDTO == null ) {
            return null;
        }

        RolUsuario rolUsuario = new RolUsuario();

        rolUsuario.setIdRol( rolUsuarioDTO.getIdRol() );
        rolUsuario.setRol( rolUsuarioDTO.getRol() );

        return rolUsuario;
    }
}
