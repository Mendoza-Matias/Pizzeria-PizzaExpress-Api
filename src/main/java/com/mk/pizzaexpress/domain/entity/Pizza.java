package com.mk.pizzaexpress.domain.entity;

import com.mk.pizzaexpress.domain.entity.enums.Medida;
import com.mk.pizzaexpress.domain.entity.enums.TipoDePizza;
import com.mk.pizzaexpress.domain.entity.pedidos.PedidoPizza;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="pizzas")

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pizza extends Producto{

    @Column(name = "tipo_pizza")
    private TipoDePizza tipoDePizza;

    @Column(name = "medida")
    private Medida medida;

    //Manejo las pizzas que han sido pedidas con su cantidad

    @OneToMany(mappedBy = "pizza")
    private List <PedidoPizza> pedidosPizzas;

    @JoinColumn(name = "receta_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Receta receta;
}
