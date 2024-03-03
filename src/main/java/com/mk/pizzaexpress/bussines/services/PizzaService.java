package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.producto.pizza.CrearPizzaDto;
import com.mk.pizzaexpress.domain.dto.producto.pizza.PizzaDto;

import java.io.IOException;
import java.util.List;


public interface PizzaService {

    List<PizzaDto> listarTodasLasPizzas();

    PizzaDto buscarPizzaPorNombre(String nombre);

    PizzaDto crearUnaPizza(CrearPizzaDto pizza);

    PizzaDto agreagarReceta(int pizzaId , int recetaId);

    PizzaDto modificarPrecioDePizza(int id , int precio);

    PizzaDto eliminarUnaPizza(int id) throws IOException;

    boolean existePizzaConNombre(String nombre);

    String obtenerPublicId(String urlImagen);


}
