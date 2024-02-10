package com.mk.pizzaexpress.domain.entity.pedidos;

import com.mk.pizzaexpress.domain.entity.Pedido;
import com.mk.pizzaexpress.domain.entity.Pizza;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "pedido_pizzas")

@Builder
@Data
@AllArgsConstructor
public class PedidoPizza {

    //Representa la cantidad de pizzas que pueden ser pedidas

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

    private int cantidad;
}
