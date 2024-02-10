package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.ingrediente.CrearIngredienteDto;
import com.mk.pizzaexpress.domain.dto.ingrediente.IngredienteDto;
import com.mk.pizzaexpress.domain.entity.Receta;

import java.util.List;


public interface IngredienteService {

    List<IngredienteDto> listarTodosLosIngredientes();

    IngredienteDto crearUnIngrediente(CrearIngredienteDto crearIngredienteDto , List<Integer> recetasId);

    IngredienteDto actualizarStockDeIngrediente(int id , int cantidad);

    boolean existeElIngredienteConNombre(String nombre);

}
