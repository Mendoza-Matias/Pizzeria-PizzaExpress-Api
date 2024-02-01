package com.mk.pizzaexpress.domain.entity;

import com.mk.pizzaexpress.domain.entity.enums.Medida;
import com.mk.pizzaexpress.domain.entity.enums.TipoDePizza;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="pizzas")

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Pizza extends Producto{

    @Column(name = "tipo_pizza")
    private TipoDePizza tipoDePizza;

    @Column(name = "medida")
    private Medida medida;

    @ManyToMany(mappedBy = "pizzas")
    private List <Pedido> pedidos;

    @JoinColumn(name = "receta_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Receta receta;
}
