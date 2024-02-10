package com.mk.pizzaexpress.bussines.services;


import com.mk.pizzaexpress.domain.dto.producto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.producto.bebida.CrearBebidaDto;

import java.util.List;


public interface BebidaService {

    List<BebidaDto> listarTodasLasBebidas();

    BebidaDto buscarBebidaPorNombre(String nombre);

    BebidaDto crearUnaBebida(CrearBebidaDto crearBebidaDto);

    BebidaDto modificarPrecioDeBebida(int id , float precio);

    BebidaDto actualizarStockDeBebida(int id , int nuevoStock);

    BebidaDto eliminarUnaBebida(int id);

    boolean existeBebidaDeMarca(String marca);
}
