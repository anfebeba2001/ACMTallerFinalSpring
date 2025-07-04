package com.acm.tallerfinal.Mappers;

import com.acm.tallerfinal.dtos.CategoriaDTO;
import com.acm.tallerfinal.dtos.ProductoCreacionDTO;
import com.acm.tallerfinal.dtos.ProductoDTO;
import com.acm.tallerfinal.entity.Categoria;
import com.acm.tallerfinal.entity.Producto;
import com.acm.tallerfinal.entity.ProductoCategoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ProductoMapper {

    @Mapping(source = "productoCategorias", target = "categorias")
    ProductoDTO toDto(Producto producto);

    @Mapping(target = "idProducto", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "fechaActualizacion", ignore = true)
    Producto toEntity(ProductoCreacionDTO productoCreacionDTO);


    default CategoriaDTO map(ProductoCategoria productoCategoria) {
        return productoCategoria.getCategoria() != null ? toCategoriaDTO(productoCategoria.getCategoria()) : null;
    }

    CategoriaDTO toCategoriaDTO(Categoria categoria);
}