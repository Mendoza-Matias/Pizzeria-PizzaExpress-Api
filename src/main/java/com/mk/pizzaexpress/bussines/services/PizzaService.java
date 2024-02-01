package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.pizza.CrearPizzaDto;
import com.mk.pizzaexpress.domain.dto.pizza.PizzaDto;

import java.util.List;


public interface PizzaService {

    List<PizzaDto> listarTodasLasPizzas();

    PizzaDto buscarPizzaPorNombre(String nombre);

    PizzaDto crearUnaPizza(CrearPizzaDto pizza , int idReceta);

    PizzaDto modificarPrecioDePizza(int id , float precio);

    PizzaDto eliminarUnaPizza(int id);

    boolean existePizzaConNombre(String nombre);
}
