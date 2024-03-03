package com.mk.pizzaexpress.domain.entity.recetas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "receta_ingredientes")

@Data
@Builder
@AllArgsConstructor
public class RecetaIngrediente {

    //Representa la la cantidad de ingredientes de mi receta
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "receta_id")
    private Receta receta;

    @ManyToOne
    @JoinColumn(name = "ingrediente_id")
    private Ingrediente ingrediente;

    @Column(name = "cantidad")
    private int cantidad;
}
