package com.mk.pizzaexpress.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@MappedSuperclass
public abstract class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nombre;

    private double precio;

    private byte[] imagen;

    private String urlImagen;
}
