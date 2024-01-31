package com.mk.pizzaexpress.bussines.services;


import com.mk.pizzaexpress.domain.dto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.bebida.BebidaPorPrecioDto;

import java.util.List;


public interface BebidaService {

    List<BebidaDto> listarTodasLasBebidas();
    BebidaDto crearUnaBebida(BebidaDto bebida);

    BebidaDto editarUnaBebida(int id , BebidaDto bebida);

    BebidaDto eliminarUnaBebida(int id);
}
