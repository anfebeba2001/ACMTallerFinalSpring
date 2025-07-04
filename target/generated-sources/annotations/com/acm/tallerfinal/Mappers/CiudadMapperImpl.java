package com.acm.tallerfinal.Mappers;

import com.acm.tallerfinal.dtos.CiudadDTO;
import com.acm.tallerfinal.entity.Ciudad;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-03T21:51:11-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class CiudadMapperImpl implements CiudadMapper {

    @Autowired
    private DepartamentoMapper departamentoMapper;

    @Override
    public CiudadDTO toDto(Ciudad ciudad) {
        if ( ciudad == null ) {
            return null;
        }

        CiudadDTO ciudadDTO = new CiudadDTO();

        ciudadDTO.setIdCiudad( ciudad.getIdCiudad() );
        ciudadDTO.setNombre( ciudad.getNombre() );
        ciudadDTO.setDepartamento( departamentoMapper.toDto( ciudad.getDepartamento() ) );

        return ciudadDTO;
    }

    @Override
    public Ciudad toEntity(CiudadDTO ciudadDTO) {
        if ( ciudadDTO == null ) {
            return null;
        }

        Ciudad ciudad = new Ciudad();

        ciudad.setIdCiudad( ciudadDTO.getIdCiudad() );
        ciudad.setNombre( ciudadDTO.getNombre() );
        ciudad.setDepartamento( departamentoMapper.toEntity( ciudadDTO.getDepartamento() ) );

        return ciudad;
    }
}
