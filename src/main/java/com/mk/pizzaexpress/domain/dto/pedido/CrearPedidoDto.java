package com.mk.pizzaexpress.domain.dto.pedido;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
public class CrearPedidoDto {

    @Size(max = 45)
    private String nombrePizza;

    @Size(max = 45)
    private String marcaBebida;

    @PositiveOrZero
    private int cantidadDePizzas;

    @PositiveOrZero
    private int cantidadDeBebidas;
}
