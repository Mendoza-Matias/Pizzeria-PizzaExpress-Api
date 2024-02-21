package com.mk.pizzaexpress.domain.entity.pedidos;

import com.mk.pizzaexpress.domain.entity.productos.Bebida;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "pedido_bebidas")

@Data
@Builder
@AllArgsConstructor
public class PedidoBebida {

    //Representa la cantidad de bebidas que pueden ser pedidas

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "bebida_id")
    private Bebida bebida;

    private int cantidad;
}
