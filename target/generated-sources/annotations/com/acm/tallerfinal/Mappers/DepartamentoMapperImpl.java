package com.acm.tallerfinal.Mappers;

import com.acm.tallerfinal.dtos.DepartamentoDTO;
import com.acm.tallerfinal.entity.Departamento;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-03T21:51:10-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class DepartamentoMapperImpl implements DepartamentoMapper {

    @Override
    public DepartamentoDTO toDto(Departamento departamento) {
        if ( departamento == null ) {
            return null;
        }

        DepartamentoDTO departamentoDTO = new DepartamentoDTO();

        departamentoDTO.setIdDepartamento( departamento.getIdDepartamento() );
        departamentoDTO.setNombre( departamento.getNombre() );

        return departamentoDTO;
    }

    @Override
    public Departamento toEntity(DepartamentoDTO departamentoDTO) {
        if ( departamentoDTO == null ) {
            return null;
        }

        Departamento departamento = new Departamento();

        departamento.setIdDepartamento( departamentoDTO.getIdDepartamento() );
        departamento.setNombre( departamentoDTO.getNombre() );

        return departamento;
    }
}
