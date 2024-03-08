package com.mk.pizzaexpress.domain.entity.direccion;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "direcciones")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "localidad")
    private String localidad;

    @Column(name = "provincia")
    private String provincia;
}
