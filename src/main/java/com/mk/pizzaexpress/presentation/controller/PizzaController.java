package com.mk.pizzaexpress.presentation.controller;

import com.mk.pizzaexpress.bussines.services.servicesImpl.ImagenesServiceImpl;
import com.mk.pizzaexpress.bussines.services.servicesImpl.PizzaServiceImpl;
import com.mk.pizzaexpress.domain.dto.producto.pizza.CrearPizzaDto;
import com.mk.pizzaexpress.domain.dto.producto.pizza.PizzaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    @Autowired
    private PizzaServiceImpl pizzaServiceImpl;

    @Autowired
    private ImagenesServiceImpl imagenesServiceImpl;

    @PreAuthorize("permitAll")
    @GetMapping
    ResponseEntity<List<PizzaDto>> listarTodasLasPizzas(){
        return ResponseEntity.status(HttpStatus.OK).body(pizzaServiceImpl.listarTodasLasPizzas());
    }

    @PreAuthorize("permitAll")
    @GetMapping("{nombre}")
    ResponseEntity<PizzaDto> BuscarUnaPizzaPorNombre(@PathVariable(name = "nombre") String nombre){
        return ResponseEntity.status(HttpStatus.OK).body(pizzaServiceImpl.obtenerUnaPizzaPorSuNombre(nombre));
    }
    @PostMapping
    ResponseEntity<PizzaDto> crearPizza(@RequestBody CrearPizzaDto crearPizzaDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pizzaServiceImpl.crearUnaPizza(crearPizzaDto));
    }
    @PreAuthorize("permitAll")
    @PostMapping("{id}/imagen")
    ResponseEntity<PizzaDto> agregarImagenDePizza(@PathVariable(name = "id") int id , @RequestParam(name = "imagen") MultipartFile imagen){
        return ResponseEntity.status(HttpStatus.OK).body(imagenesServiceImpl.agregarImagenDePizza(id,imagen));
    }

    @PreAuthorize("permitAll")
    @PutMapping("{id}/precio")
    ResponseEntity<PizzaDto> modificarPrecioDePizza(@PathVariable(name = "id") int id , @RequestBody int precio){
        return ResponseEntity.status(HttpStatus.OK).body(pizzaServiceImpl.modificarElPrecioDeUnaPizza(id,precio));
    }

    @PreAuthorize("permitAll")
    @DeleteMapping("{id}/eliminar")
    ResponseEntity<PizzaDto> eliminarPizza (@PathVariable(name = "id") int id) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(pizzaServiceImpl.eliminarUnaPizza(id));
    }
}
