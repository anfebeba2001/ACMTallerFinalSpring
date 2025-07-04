package com.acm.tallerfinal.Mappers;

import com.acm.tallerfinal.dtos.AlmacenDTO;
import com.acm.tallerfinal.entity.Almacen;
import org.mapstruct.Mapper;

// Usa CiudadMapper para resolver la ciudad anidada
@Mapper(componentModel = "spring", uses = {CiudadMapper.class})
public interface AlmacenMapper {
    AlmacenDTO toDto(Almacen almacen);
    Almacen toEntity(AlmacenDTO almacenDTO);
}
