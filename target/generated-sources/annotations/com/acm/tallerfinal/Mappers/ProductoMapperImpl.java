package com.acm.tallerfinal.Mappers;

import com.acm.tallerfinal.dtos.CategoriaDTO;
import com.acm.tallerfinal.dtos.ProductoCreacionDTO;
import com.acm.tallerfinal.dtos.ProductoDTO;
import com.acm.tallerfinal.entity.Categoria;
import com.acm.tallerfinal.entity.Producto;
import com.acm.tallerfinal.entity.ProductoCategoria;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-03T21:51:11-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class ProductoMapperImpl implements ProductoMapper {

    @Override
    public ProductoDTO toDto(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setCategorias( productoCategoriaListToCategoriaDTOList( producto.getProductoCategorias() ) );
        productoDTO.setIdProducto( producto.getIdProducto() );
        productoDTO.setNombre( producto.getNombre() );
        productoDTO.setPrecio( producto.getPrecio() );
        productoDTO.setDescripcion( producto.getDescripcion() );
        productoDTO.setFechaCreacion( producto.getFechaCreacion() );
        productoDTO.setFechaActualizacion( producto.getFechaActualizacion() );

        return productoDTO;
    }

    @Override
    public Producto toEntity(ProductoCreacionDTO productoCreacionDTO) {
        if ( productoCreacionDTO == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setNombre( productoCreacionDTO.getNombre() );
        producto.setPrecio( productoCreacionDTO.getPrecio() );
        producto.setDescripcion( productoCreacionDTO.getDescripcion() );

        return producto;
    }

    @Override
    public CategoriaDTO toCategoriaDTO(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaDTO categoriaDTO = new CategoriaDTO();

        categoriaDTO.setIdCategoria( categoria.getIdCategoria() );
        categoriaDTO.setNombre( categoria.getNombre() );

        return categoriaDTO;
    }

    protected List<CategoriaDTO> productoCategoriaListToCategoriaDTOList(List<ProductoCategoria> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoriaDTO> list1 = new ArrayList<CategoriaDTO>( list.size() );
        for ( ProductoCategoria productoCategoria : list ) {
            list1.add( map( productoCategoria ) );
        }

        return list1;
    }
}
