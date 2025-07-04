package com.acm.tallerfinal.Mappers;

import com.acm.tallerfinal.dtos.UsuarioCreacionDTO;
import com.acm.tallerfinal.dtos.UsuarioDTO;
import com.acm.tallerfinal.entity.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-03T21:51:11-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Autowired
    private RolUsuarioMapper rolUsuarioMapper;
    @Autowired
    private CiudadMapper ciudadMapper;

    @Override
    public UsuarioDTO toDto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setIdUsuario( usuario.getIdUsuario() );
        usuarioDTO.setNombre( usuario.getNombre() );
        usuarioDTO.setApellido( usuario.getApellido() );
        usuarioDTO.setUsername( usuario.getUsername() );
        usuarioDTO.setEmail( usuario.getEmail() );
        usuarioDTO.setFechaRegistro( usuario.getFechaRegistro() );
        usuarioDTO.setTelefono( usuario.getTelefono() );
        usuarioDTO.setRol( rolUsuarioMapper.toDto( usuario.getRol() ) );
        usuarioDTO.setCiudad( ciudadMapper.toDto( usuario.getCiudad() ) );

        return usuarioDTO;
    }

    @Override
    public Usuario toEntity(UsuarioCreacionDTO usuarioCreacionDTO) {
        if ( usuarioCreacionDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setNombre( usuarioCreacionDTO.getNombre() );
        usuario.setApellido( usuarioCreacionDTO.getApellido() );
        usuario.setUsername( usuarioCreacionDTO.getUsername() );
        usuario.setEmail( usuarioCreacionDTO.getEmail() );
        usuario.setTelefono( usuarioCreacionDTO.getTelefono() );

        return usuario;
    }
}
