package com.mk.pizzaexpress.domain.entity.recetas;

import com.mk.pizzaexpress.domain.entity.pedidos.productos.Pizza;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "recetas")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @OneToOne(mappedBy = "receta")
    private Pizza pizza;

    @OneToMany(mappedBy = "receta")
    private List<RecetaIngrediente> recetaIngredientes;

}
