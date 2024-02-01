package com.mk.pizzaexpress.domain.entity.user;

import com.mk.pizzaexpress.domain.entity.enums.Rol;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@MappedSuperclass
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name = "email")
    private String email;

    @Column(name = "clave")
    private String clave;

    @Column(name = "rol")
    private Rol rol;

}
