package com.mk.pizzaexpress.bussines.mapper.implMapper;

import com.mk.pizzaexpress.bussines.mapper.IMapper;
import com.mk.pizzaexpress.domain.dto.pizza.CrearPizzaDto;
import com.mk.pizzaexpress.domain.dto.pizza.PizzaDto;
import com.mk.pizzaexpress.domain.entity.Pizza;

public interface PizzaMapper extends IMapper<Pizza,PizzaDto> {

    Pizza aPizzaDeCrearPizzaDto(CrearPizzaDto crearPizzaDto);
}
