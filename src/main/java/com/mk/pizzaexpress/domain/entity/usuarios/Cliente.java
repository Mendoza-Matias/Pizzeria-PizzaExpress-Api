package com.mk.pizzaexpress.domain.entity.usuarios;

import com.mk.pizzaexpress.domain.entity.Pedido;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "clientes")


@Getter
@Setter
@Builder
@AllArgsConstructor
public class Cliente extends Usuario{

    @Column(name="telefono")
    int telefono;

    @Column(name = "direccion")
    String direccion;

    @Column(name = "localidad")
    String localidad;


    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

}
