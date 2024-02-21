package com.mk.pizzaexpress.domain.entity.productos;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "ingredientes")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="numero_stock")
    private int stock;

}
