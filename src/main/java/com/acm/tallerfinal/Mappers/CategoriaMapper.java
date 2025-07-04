package com.acm.tallerfinal.Mappers;

import com.acm.tallerfinal.dtos.CategoriaDTO;
import com.acm.tallerfinal.entity.Categoria;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaDTO toDto(Categoria categoria);
    List<CategoriaDTO> toDtoList(List<Categoria> categorias);
    Categoria toEntity(CategoriaDTO categoriaDTO);
}