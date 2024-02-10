package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.producto.pizza.CrearPizzaDto;
import com.mk.pizzaexpress.domain.dto.producto.pizza.PizzaDto;
import com.mk.pizzaexpress.domain.entity.enums.Medida;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface PizzaService {

    List<PizzaDto> listarTodasLasPizzas();

    PizzaDto buscarPizzaPorNombre(String nombre);

    PizzaDto listarUnaPizza(int id);

    String almacenarImagen(byte[] imagen, String carpeta);

    PizzaDto crearUnaPizza(CrearPizzaDto pizza,MultipartFile imagen);

    PizzaDto editarUnaPizza(int id , CrearPizzaDto crearPizzaDto);

    PizzaDto editarImagenDepizza(int id , MultipartFile imagen);

    PizzaDto agreagarReceta(int pizzaId , int recetaId);

    PizzaDto modificarPrecioDePizza(int id , float precio);

    PizzaDto eliminarUnaPizza(int id);

    boolean existePizzaConNombre(String nombre);

    boolean esPizzaDeMedida(Medida medida);


}
