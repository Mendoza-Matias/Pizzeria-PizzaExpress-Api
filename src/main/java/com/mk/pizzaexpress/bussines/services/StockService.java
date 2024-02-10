package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.producto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.producto.pizza.PizzaDto;

public interface StockService {

    void restarStockDeIngredientesParaPizza (PizzaDto pizza);

    void restarStockDeBebidas (BebidaDto bebida);
}
