package com.mk.pizzaexpress.domain.entity.pedidos;

import com.mk.pizzaexpress.domain.entity.enums.EstadoPedido;
import com.mk.pizzaexpress.domain.entity.productos.Bebida;
import com.mk.pizzaexpress.domain.entity.productos.Pizza;
import com.mk.pizzaexpress.domain.entity.usuarios.Cliente;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="pedidos")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @Column(name = "cantidadPizza")
    private int cantidadDePizzas;

    @Column(name = "cantidadBebida")
    private int cantidadDeBebidas;

    @Column(name = "estado_pedido")
    @Enumerated(EnumType.STRING)
    private EstadoPedido estadoPedido;

}
