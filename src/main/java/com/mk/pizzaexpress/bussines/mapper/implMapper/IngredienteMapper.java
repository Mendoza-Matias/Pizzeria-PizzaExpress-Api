package com.mk.pizzaexpress.bussines.mapper.implMapper;

import com.mk.pizzaexpress.bussines.mapper.IMapper;
import com.mk.pizzaexpress.domain.dto.ingrediente.CrearIngredienteDto;
import com.mk.pizzaexpress.domain.dto.ingrediente.IngredienteDto;
import com.mk.pizzaexpress.domain.entity.Ingrediente;

public interface IngredienteMapper extends IMapper<Ingrediente, IngredienteDto> {

    Ingrediente aIngredienteDeCrearIngredienteDto(CrearIngredienteDto crearIngredienteDto);
}
