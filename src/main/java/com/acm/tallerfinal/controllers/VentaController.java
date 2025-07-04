package com.acm.tallerfinal.controllers;


import com.acm.tallerfinal.Services.IVentaService;
import com.acm.tallerfinal.dtos.VentaCreacionDTO;
import com.acm.tallerfinal.dtos.VentaRespuestaDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {


    private final IVentaService ventaService;

    public VentaController(IVentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<VentaRespuestaDTO> registrarVenta(@Valid @RequestBody VentaCreacionDTO ventaCreacionDTO) {
        VentaRespuestaDTO ventaRegistrada = ventaService.registrarVenta(ventaCreacionDTO);
        return new ResponseEntity<>(ventaRegistrada, HttpStatus.CREATED);
    }
}