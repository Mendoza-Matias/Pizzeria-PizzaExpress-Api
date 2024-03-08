package com.mk.pizzaexpress.domain.dto.producto.pizza;

import com.mk.pizzaexpress.domain.entity.enums.Medida;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
public class DatosPizzaDto {

    private int id;

    private String nombre;

    private Medida medida;
}
