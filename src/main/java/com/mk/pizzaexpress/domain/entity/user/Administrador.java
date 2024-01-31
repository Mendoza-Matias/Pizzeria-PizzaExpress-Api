package com.mk.pizzaexpress.domain.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "administradores")
public class Administrador extends Usuario{
}
