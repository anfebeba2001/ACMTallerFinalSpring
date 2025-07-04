package com.acm.tallerfinal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "\"Venta\"")
@Data
@NoArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idVenta\"")
    private Integer idVenta;

    @Column(name = "\"fechaVenta\"", nullable = false)
    private LocalDateTime fechaVenta;

    @Column(name = "total", nullable = false)
    private Long total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"idClienteFK\"", nullable = false)
    private Usuario cliente;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VentaProducto> ventaProductos;
}