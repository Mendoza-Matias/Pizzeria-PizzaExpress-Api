package com.mk.pizzaexpress.domain.dto.usuario;

import com.mk.pizzaexpress.domain.entity.enums.Rol;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CrearUsuarioDto {
   private int id;

   @NotNull
   @Size(max = 20)
   private String nombre;

   @NotNull
   @Size(max = 45)
   private String email;

   @NotNull
   @Size(max = 8)
   private String clave;

}
