package com.mk.pizzaexpress.domain.entity.productos;

import com.mk.pizzaexpress.domain.entity.enums.Medida;
import com.mk.pizzaexpress.domain.entity.enums.TipoDePizza;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="pizzas")



@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pizza extends Producto {

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo_pizza")
    @Enumerated(EnumType.STRING)
    private TipoDePizza tipoDePizza;

    @Column(name = "medida")
    @Enumerated(EnumType.STRING)
    private Medida medida;

}
