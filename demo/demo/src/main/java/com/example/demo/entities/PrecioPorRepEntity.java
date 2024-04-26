package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "precio_reparacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrecioPorRepEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombreDeLaRep;
    private int precioGasolina;
    private int precioDiesel;
    private int precioHibrido;
    private int precioElectrico;


}
