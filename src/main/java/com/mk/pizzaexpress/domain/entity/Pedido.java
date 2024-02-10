package com.mk.pizzaexpress.domain.entity;

import com.mk.pizzaexpress.domain.entity.enums.EstadoPedido;
import com.mk.pizzaexpress.domain.entity.pedidos.PedidoBebida;
import com.mk.pizzaexpress.domain.entity.pedidos.PedidoPizza;
import com.mk.pizzaexpress.domain.entity.usuarios.Cliente;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@Entity
@Table(name="pedidos")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(mappedBy = "pedido" , cascade = CascadeType.ALL)
    private List<PedidoBebida> bebidas;

    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL)
    private List<PedidoPizza> pizzas;

}
