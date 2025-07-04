package com.acm.tallerfinal.Mappers;

import com.acm.tallerfinal.dtos.CiudadDTO;
import com.acm.tallerfinal.entity.Ciudad;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DepartamentoMapper.class})
public interface CiudadMapper {
    CiudadDTO toDto(Ciudad ciudad);
    Ciudad toEntity(CiudadDTO ciudadDTO);
}