package com.mk.pizzaexpress.domain.entity;

import com.mk.pizzaexpress.domain.entity.enums.Medida;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "bebidas")
public class Bebida extends Producto{

    @Column(name = "marca")
    private String marca;

    @Column(name = "litros")
    private float litros;

    @Column(name = "numero_stock")
    private int stock;

    @Column(name = "medida")
    private Medida medida;

    @ManyToMany(mappedBy = "bebidas")
    private List<Pedido> pedidos;

}
