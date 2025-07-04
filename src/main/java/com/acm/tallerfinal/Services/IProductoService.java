package com.acm.tallerfinal.Services;

import com.acm.tallerfinal.dtos.ProductoCreacionDTO;
import com.acm.tallerfinal.dtos.ProductoDTO;

import java.util.List;

public interface IProductoService {
    List<ProductoDTO> listarProductos();
    ProductoDTO obtenerProducto(Integer id);
    ProductoDTO crearProducto(ProductoCreacionDTO productoCreacionDTO);
}