package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.producto.pizza.CrearPizzaDto;
import com.mk.pizzaexpress.domain.dto.producto.pizza.PizzaDto;

import java.io.IOException;
import java.util.List;
public interface PizzaService {
    List <PizzaDto> listarTodasLasPizzas();
    PizzaDto obtenerUnaPizzaPorSuNombre(String nombre);
    PizzaDto crearUnaPizza(CrearPizzaDto crearPizza);
    PizzaDto modificarElPrecioDeUnaPizza(int pizzaId , int precio);
    PizzaDto eliminarUnaPizza(int pizzaId) throws IOException;
    boolean existePizzaConNombre(String nombre);
    String obtenerPublicId(String urlImagen);


}
