package com.acm.tallerfinal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "\"Producto\"")
@Data
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idProducto\"")
    private Integer idProducto;

    @Column(name = "nombre", nullable = false, length = 32)
    private String nombre;

    @Column(name = "precio", nullable = false, precision = 8, scale = 2)
    private BigDecimal precio;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "\"fechaCreacion\"", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "\"fechaActualizacion\"", nullable = false)
    private LocalDateTime fechaActualizacion;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductoCategoria> productoCategorias;
}