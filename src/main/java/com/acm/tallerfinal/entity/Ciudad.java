package com.acm.tallerfinal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"Ciudad\"")
@Data
@NoArgsConstructor
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idCiudad\"")
    private Integer idCiudad;

    @Column(name = "nombre", nullable = false, length = 32)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"idDepartamentoFK\"", nullable = false)
    private Departamento departamento;
}