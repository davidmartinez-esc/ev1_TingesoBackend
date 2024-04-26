package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recargo_aplicado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecargoAplicadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String tipoDeRecargo;
    private int porcentajeRecargo;

    private int idIngreso;
}
