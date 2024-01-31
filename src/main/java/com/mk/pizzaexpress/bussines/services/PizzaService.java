package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.pizza.CrearPizzaDto;
import com.mk.pizzaexpress.domain.dto.pizza.PizzaDto;

import java.util.List;


public interface PizzaService {

    List<PizzaDto> listarTodasLasPizzas();

    PizzaDto crearUnaPizza(CrearPizzaDto pizza);

    PizzaDto eliminarUnaPizza(int id);
}
