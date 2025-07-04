package com.acm.tallerfinal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"AlmacenProducto\"")
@Data
@NoArgsConstructor
public class AlmacenProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "stock", nullable = false)
    private Long stock;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"idAlmacenFK\"", nullable = false)
    private Almacen almacen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"idProductoFK\"", nullable = false)
    private Producto producto;
}