package com.mk.pizzaexpress.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "recetas")
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(mappedBy = "receta")
    private Pizza pizza;

    @ManyToMany
    @JoinTable(
            name ="receta_ingrediente",
            joinColumns = {
                    @JoinColumn(name = "receta_id"),
            },
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )
    private List<Ingrediente> ingredientes;

}
