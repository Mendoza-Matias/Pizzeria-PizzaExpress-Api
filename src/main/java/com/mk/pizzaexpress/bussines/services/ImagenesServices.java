package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.producto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.producto.pizza.PizzaDto;
import org.springframework.web.multipart.MultipartFile;

public interface ImagenesServices {
    String almacenarImagen(byte[] imagen , String carpeta);
    PizzaDto agregarImagenDePizza(int id , MultipartFile imagen);
    BebidaDto agregarImagenDeBebida(int id, MultipartFile imagen);

}
