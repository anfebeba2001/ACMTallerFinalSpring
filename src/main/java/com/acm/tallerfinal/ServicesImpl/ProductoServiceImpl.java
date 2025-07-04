package com.acm.tallerfinal.ServicesImpl;

import com.acm.tallerfinal.Exceptions.ResourceNotFoundException;
import com.acm.tallerfinal.Mappers.ProductoMapper;
import com.acm.tallerfinal.Services.IProductoService;
import com.acm.tallerfinal.dtos.ProductoCreacionDTO;
import com.acm.tallerfinal.dtos.ProductoDTO;
import com.acm.tallerfinal.entity.Categoria;
import com.acm.tallerfinal.entity.Producto;
import com.acm.tallerfinal.entity.ProductoCategoria;
import com.acm.tallerfinal.repository.CategoriaRepository;
import com.acm.tallerfinal.repository.ProductoCategoriaRepository;
import com.acm.tallerfinal.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements IProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProductoCategoriaRepository productoCategoriaRepository;
    private final ProductoMapper productoMapper;

    public ProductoServiceImpl(ProductoRepository productoRepository, CategoriaRepository categoriaRepository, ProductoCategoriaRepository productoCategoriaRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
        this.productoCategoriaRepository = productoCategoriaRepository;
        this.productoMapper = productoMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDTO> listarProductos() {
        return productoRepository.findAll().stream()
                .map(productoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoDTO obtenerProducto(Integer id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + id));
        return productoMapper.toDto(producto);
    }

    @Override
    @Transactional
    public ProductoDTO crearProducto(ProductoCreacionDTO productoCreacionDTO) {
        Producto producto = productoMapper.toEntity(productoCreacionDTO);
        producto.setFechaCreacion(LocalDateTime.now());
        producto.setFechaActualizacion(LocalDateTime.now());

        Producto productoGuardado = productoRepository.save(producto);

        productoCreacionDTO.getIdsCategorias().forEach(idCategoria -> {
            Categoria categoria = categoriaRepository.findById(idCategoria)
                    .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con ID: " + idCategoria));

            ProductoCategoria productoCategoria = new ProductoCategoria();
            productoCategoria.setProducto(productoGuardado);
            productoCategoria.setCategoria(categoria);
            productoCategoriaRepository.save(productoCategoria);
        });

        return obtenerProducto(productoGuardado.getIdProducto());
    }
}