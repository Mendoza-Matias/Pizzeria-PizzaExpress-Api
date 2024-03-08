package com.mk.pizzaexpress.domain.entity.productos;

import com.mk.pizzaexpress.domain.entity.enums.Medida;
import com.mk.pizzaexpress.domain.entity.enums.TipoDeBebida;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bebidas")


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Bebida extends Producto {

    @Column(name = "marca")
    private String marca;

    @Column(name = "tipo_bebida")
    @Enumerated(EnumType.STRING)
    TipoDeBebida tipoDeBebida;

    @Column(name = "litros")
    private float litros;

    @Column(name = "medida")
    @Enumerated(EnumType.STRING)
    private Medida medida;
}
