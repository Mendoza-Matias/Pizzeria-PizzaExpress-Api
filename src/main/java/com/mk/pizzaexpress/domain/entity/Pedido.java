package com.mk.pizzaexpress.domain.entity;

import com.mk.pizzaexpress.domain.entity.enums.EstadoPedido;
import com.mk.pizzaexpress.domain.entity.user.Cliente;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "numero_pedido")
    private int numeroDePedido;

    @Column(name = "estado_pedido")
    private EstadoPedido estadoPedido;

    @ManyToOne()
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "pedido_bebidas",
            joinColumns = { @JoinColumn(name = "pedido_id")},
            inverseJoinColumns = {@JoinColumn(name="bebida_id")}

    )
    private List<Bebida> bebidas;

    @ManyToMany
    @JoinTable(
            name = "pedido_pizzas",
            joinColumns = {@JoinColumn(name="pedido_id")},
            inverseJoinColumns = {@JoinColumn(name="pizza_id")}
    )
    private List<Pizza> pizzas;




}
