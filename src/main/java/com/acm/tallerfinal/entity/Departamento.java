package com.acm.tallerfinal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "\"Departamento\"")
@Data
@NoArgsConstructor
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idDepartamento\"")
    private Integer idDepartamento;

    @Column(name = "nombre", nullable = false, length = 32)
    private String nombre;
}