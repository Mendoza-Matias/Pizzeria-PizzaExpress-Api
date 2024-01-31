package com.mk.pizzaexpress.domain.entity.user;

import com.mk.pizzaexpress.domain.entity.Pedido;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clientes")
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
