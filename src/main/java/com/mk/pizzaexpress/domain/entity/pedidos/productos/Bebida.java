package com.mk.pizzaexpress.domain.entity.pedidos.productos;

import com.mk.pizzaexpress.domain.entity.enums.Medida;
import com.mk.pizzaexpress.domain.entity.enums.TipoDeBebida;
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
public class Bebida extends Producto {

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


}