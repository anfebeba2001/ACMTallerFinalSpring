package com.acm.tallerfinal.Mappers;

import com.acm.tallerfinal.dtos.AlmacenDTO;
import com.acm.tallerfinal.entity.Almacen;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-03T21:51:11-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class AlmacenMapperImpl implements AlmacenMapper {

    @Autowired
    private CiudadMapper ciudadMapper;

    @Override
    public AlmacenDTO toDto(Almacen almacen) {
        if ( almacen == null ) {
            return null;
        }

        AlmacenDTO almacenDTO = new AlmacenDTO();

        almacenDTO.setIdAlmacen( almacen.getIdAlmacen() );
        almacenDTO.setNombre( almacen.getNombre() );
        almacenDTO.setCiudad( ciudadMapper.toDto( almacen.getCiudad() ) );

        return almacenDTO;
    }

    @Override
    public Almacen toEntity(AlmacenDTO almacenDTO) {
        if ( almacenDTO == null ) {
            return null;
        }

        Almacen almacen = new Almacen();

        almacen.setIdAlmacen( almacenDTO.getIdAlmacen() );
        almacen.setNombre( almacenDTO.getNombre() );
        almacen.setCiudad( ciudadMapper.toEntity( almacenDTO.getCiudad() ) );

        return almacen;
    }
}
