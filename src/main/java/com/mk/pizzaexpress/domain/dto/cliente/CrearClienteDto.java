package com.mk.pizzaexpress.domain.dto.cliente;

import com.mk.pizzaexpress.domain.dto.direccion.DireccionDto;
import com.mk.pizzaexpress.domain.entity.direccion.Direccion;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CrearClienteDto {

    private int id;

    @NotNull
    @Size(max = 20)
    private String nombre;

    @NotNull
    @Size(max = 45)
    private String email;

    @NotNull
    @Positive
    @Size(max = 11)
    private int telefono;

    @NotNull
    private Direccion direccion;

    @Size(max = 8)
    @Positive
    private String clave;
}
