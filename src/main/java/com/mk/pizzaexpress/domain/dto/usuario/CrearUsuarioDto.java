package com.mk.pizzaexpress.domain.dto.usuario;

import com.mk.pizzaexpress.domain.entity.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CrearUsuarioDto {

   private int id;

   private String nombre;

   private String email;

   private String clave;

   private Rol rol;

}
