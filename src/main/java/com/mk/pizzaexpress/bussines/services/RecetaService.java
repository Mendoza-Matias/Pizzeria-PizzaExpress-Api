package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.receta.CrearRecetaDto;
import com.mk.pizzaexpress.domain.dto.receta.RecetaDto;
import com.mk.pizzaexpress.domain.dto.receta.RecetaPorTipoDePizzaDto;

import java.util.List;


public interface RecetaService {


    RecetaDto listarUnaRecetaPorId(int id);
    RecetaDto buscarRecetaPorPizza(int id);
    RecetaDto crearReceta(CrearRecetaDto crearRecetaDto, int idPizza , List<Integer> ingredientesIds);
    RecetaDto editarReceta(int id,CrearRecetaDto crearRecetaDto,int idPizza,List<Integer> ingredienteIds);
    RecetaDto eliminarUnaReceta(int id);
    boolean existeRecetaConNombre(String nombre);
}
