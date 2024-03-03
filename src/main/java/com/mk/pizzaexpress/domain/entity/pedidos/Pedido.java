package com.mk.pizzaexpress.domain.entity.pedidos;

import com.mk.pizzaexpress.domain.entity.enums.EstadoPedido;
import com.mk.pizzaexpress.domain.entity.pedidos.productos.Bebida;
import com.mk.pizzaexpress.domain.entity.pedidos.productos.Pizza;
import com.mk.pizzaexpress.domain.entity.usuarios.Cliente;
import com.mk.pizzaexpress.domain.entity.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne()
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

    @ManyToOne
    @JoinColumn(name = "bebida_id")
    private Bebida bebida;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "estado_pedido")
    private EstadoPedido estadoPedido;

}
