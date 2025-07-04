package com.acm.tallerfinal.controllers;


import com.acm.tallerfinal.Mappers.CategoriaMapper;
import com.acm.tallerfinal.dtos.CategoriaDTO;
import com.acm.tallerfinal.repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final  CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaController(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
        List<CategoriaDTO> categorias = categoriaMapper.toDtoList(categoriaRepository.findAll());
        return ResponseEntity.ok(categorias);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoriaDTO> crearCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        var categoriaGuardada = categoriaRepository.save(categoriaMapper.toEntity(categoriaDTO));
        return ResponseEntity.status(201).body(categoriaMapper.toDto(categoriaGuardada));
    }
}