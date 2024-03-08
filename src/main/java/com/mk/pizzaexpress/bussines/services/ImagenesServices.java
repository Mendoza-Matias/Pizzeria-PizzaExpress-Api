package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.producto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.producto.pizza.ImagenPizzaDto;
import com.mk.pizzaexpress.domain.dto.producto.pizza.PizzaDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImagenesServices {
    String almacenarImagen(byte[] imagen , String carpeta);
    PizzaDto agregarImagenDePizza(int pizzaId , MultipartFile imagen);
    BebidaDto agregarImagenDeBebida(int bebidaId, MultipartFile imagen);

}
