package com.acm.tallerfinal.controllers;

import com.acm.tallerfinal.Services.IProductoService;
import com.acm.tallerfinal.dtos.ProductoCreacionDTO;
import com.acm.tallerfinal.dtos.ProductoDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listarProductos() {
        return ResponseEntity.ok(productoService.listarProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerProducto(@PathVariable Integer id) {
        return ResponseEntity.ok(productoService.obtenerProducto(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProductoDTO> crearProducto(@Valid @RequestBody ProductoCreacionDTO productoCreacionDTO) {
        ProductoDTO productoCreado = productoService.crearProducto(productoCreacionDTO);
        return new ResponseEntity<>(productoCreado, HttpStatus.CREATED);
    }
}