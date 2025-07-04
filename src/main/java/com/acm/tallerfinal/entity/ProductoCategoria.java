package com.acm.tallerfinal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"ProductoCategoria\"")
@Data
@NoArgsConstructor
public class ProductoCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"idProducto\"", nullable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"idCategoria\"", nullable = false)
    private Categoria categoria;
}