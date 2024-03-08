package com.mk.pizzaexpress.bussines.services;


import com.mk.pizzaexpress.domain.dto.producto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.producto.bebida.CrearBebidaDto;

import java.io.IOException;
import java.util.List;


public interface BebidaService {

    List<BebidaDto> listarTodasLasBebidas();
    BebidaDto obtenerBebidaPorMarca(String marca);
    BebidaDto crearUnaBebida(CrearBebidaDto crearBebidaDto);
    BebidaDto modificarPrecioDeBebida(int bebidaId , int precio);
    BebidaDto eliminarUnaBebida(int bebidaId) throws IOException;
    boolean existeBebidaDeMarca(String marca);
    String obtenerPublicIdDeImagen(String urlImagen);
}
