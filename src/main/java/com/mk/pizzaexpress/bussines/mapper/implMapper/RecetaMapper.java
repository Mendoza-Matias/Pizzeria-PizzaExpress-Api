package com.mk.pizzaexpress.bussines.mapper.implMapper;

import com.mk.pizzaexpress.bussines.mapper.IMapper;
import com.mk.pizzaexpress.domain.dto.receta.CrearRecetaDto;
import com.mk.pizzaexpress.domain.dto.receta.RecetaDto;
import com.mk.pizzaexpress.domain.entity.Receta;

public interface RecetaMapper extends IMapper<Receta, RecetaDto> {

    Receta aRecetaDecrearRecetaDto(CrearRecetaDto crearRecetaDto);
}
