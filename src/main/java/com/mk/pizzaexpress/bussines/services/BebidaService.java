package com.mk.pizzaexpress.bussines.services;


import com.mk.pizzaexpress.domain.dto.producto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.producto.bebida.CrearBebidaDto;

import java.io.IOException;
import java.util.List;


public interface BebidaService {

    List<BebidaDto> listarTodasLasBebidas();
    BebidaDto buscarBebidaPorNombre(String nombre);
    BebidaDto crearUnaBebida(CrearBebidaDto crearBebidaDto);
    BebidaDto modificarPrecioDeBebida(int id , int precio);
    BebidaDto actualizarStockDeBebida(int id, int stock);
    BebidaDto eliminarUnaBebida(int id) throws IOException;
    boolean existeBebidaDeMarca(String marca);
    String obtenerPublicId(String urlImagen);
}
