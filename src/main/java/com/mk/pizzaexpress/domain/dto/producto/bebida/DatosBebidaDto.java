package com.mk.pizzaexpress.domain.dto.producto.bebida;


import lombok.*;

@Data
@AllArgsConstructor
@Builder
@Getter
@Setter
public class DatosBebidaDto {

    private int id;

    private String marca;

    private float litros;
}
