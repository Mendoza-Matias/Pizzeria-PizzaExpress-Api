package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.ingrediente.CrearIngredienteDto;
import com.mk.pizzaexpress.domain.dto.ingrediente.IngredienteDto;

import java.util.List;


public interface IngredienteService {

    List<IngredienteDto> listarTodosLosIngredientes();

    IngredienteDto crearUnIngrediente(CrearIngredienteDto ingrediente);

    IngredienteDto editarIngrediente(int id,CrearIngredienteDto ingrediente);

    IngredienteDto elimiarIngrediente(int id);

    IngredienteDto actualizarStockIngrediente(int id , int cantidad);
}
