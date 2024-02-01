package com.mk.pizzaexpress.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@MappedSuperclass
public abstract class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private double precio;

    @Column(name = "imagen")
    private byte[] imagen;

    @Column(name = "urlImagen")
    private String urlImagen;
}
