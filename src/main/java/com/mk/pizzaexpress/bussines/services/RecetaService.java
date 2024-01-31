package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.receta.CrearRecetaDto;
import com.mk.pizzaexpress.domain.dto.receta.RecetaDto;
import com.mk.pizzaexpress.domain.dto.receta.RecetaPorTipoDePizzaDto;

import java.util.List;


public interface RecetaService {


    RecetaDto listarUnaRecetaPorId(int id);
    RecetaDto crearReceta(CrearRecetaDto receta);
    RecetaDto editarReceta(int id,CrearRecetaDto receta);
    RecetaDto eliminarUnaReceta(int id);
}
