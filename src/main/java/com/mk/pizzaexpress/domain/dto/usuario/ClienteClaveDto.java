package com.mk.pizzaexpress.domain.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ClienteClaveDto {

    String email;
    String clave;
    String nuevaClave;
}
