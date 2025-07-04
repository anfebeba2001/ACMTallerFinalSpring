package com.acm.tallerfinal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "venta_producto") 
@Data
@NoArgsConstructor
public class VentaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "cantidad", nullable = false)
    private Long cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"idVenta\"", nullable = false)
    private Venta venta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"idProducto\"", nullable = false)
    private Producto producto;
}