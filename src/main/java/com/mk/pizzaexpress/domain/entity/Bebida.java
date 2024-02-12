package com.mk.pizzaexpress.domain.entity;

import com.mk.pizzaexpress.domain.entity.enums.Medida;
import com.mk.pizzaexpress.domain.entity.enums.TipoDeBebida;
import com.mk.pizzaexpress.domain.entity.pedidos.PedidoBebida;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "bebidas")

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bebida extends Producto{

    @Column(name = "marca")
    private String marca;

    @Column(name = "tipo_bebida")
    TipoDeBebida tipoDeBebida;

    @Column(name = "litros")
    private float litros;

    @Column(name = "numero_stock")
    private int stock;

    @Column(name = "medida")
    private Medida medida;

    @OneToMany(mappedBy = "bebida")
    private List<PedidoBebida> pedidosBebida;

}
