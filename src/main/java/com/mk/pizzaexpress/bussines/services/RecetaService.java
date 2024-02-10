package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.receta.CrearRecetaDto;
import com.mk.pizzaexpress.domain.dto.receta.RecetaDto;
import com.mk.pizzaexpress.domain.dto.receta.recetaIngrediente.RecetaIngredienteDto;

import java.util.List;

public interface RecetaService {
    RecetaDto listarUnaRecetaPorId(int id);
    RecetaDto buscarRecetaPorPizza(int id);
    RecetaDto crearReceta(int pizzaId , CrearRecetaDto crearRecetaDto);
    RecetaDto eliminarUnaReceta(int id);
    boolean existeRecetaConNombre(String nombre);
    RecetaDto agregarIngredientesALaReceta(int recetaId , List<RecetaIngredienteDto> ingredientesYCantidad);
}
