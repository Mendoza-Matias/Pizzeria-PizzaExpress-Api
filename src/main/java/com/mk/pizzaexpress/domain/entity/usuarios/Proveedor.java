package com.mk.pizzaexpress.domain.entity.usuarios;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Table(name = "proveedores")

@Builder
@AllArgsConstructor
public class Proveedor extends Usuario{
}
