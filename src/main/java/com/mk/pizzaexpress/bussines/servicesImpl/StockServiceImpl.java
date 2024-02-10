package com.mk.pizzaexpress.bussines.servicesImpl;

import com.mk.pizzaexpress.bussines.services.PedidoService;
import com.mk.pizzaexpress.bussines.services.StockService;
import com.mk.pizzaexpress.domain.dto.producto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.producto.pizza.PizzaDto;
import com.mk.pizzaexpress.persistence.repository.BebidaRepository;
import com.mk.pizzaexpress.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StockServiceImpl implements StockService {

    @Autowired
    PedidoService pedidoService;

    @Autowired
    PizzaRepository pizzaRepository;

    @Autowired
    BebidaRepository bebidaRepository;


    @Override
    public void restarStockDeIngredientesParaPizza(PizzaDto pizza) {

    }

    @Override
    public void restarStockDeBebidas(BebidaDto bebida) {

    }
}
