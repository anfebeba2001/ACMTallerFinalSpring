package com.acm.tallerfinal.Mappers;


import com.acm.tallerfinal.dtos.DepartamentoDTO;
import com.acm.tallerfinal.entity.Departamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartamentoMapper {
    DepartamentoDTO toDto(Departamento departamento);
    Departamento toEntity(DepartamentoDTO departamentoDTO);
}