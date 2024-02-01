package com.mk.pizzaexpress.bussines.mapper.implMapper;

import com.mk.pizzaexpress.bussines.mapper.IMapper;
import com.mk.pizzaexpress.domain.dto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.bebida.CrearBebidaDto;
import com.mk.pizzaexpress.domain.entity.Bebida;

public interface BebidaMapper extends IMapper<Bebida, BebidaDto> {

    Bebida aBebidaDeCrearBebidaDto(CrearBebidaDto crearBebidaDto);
}
