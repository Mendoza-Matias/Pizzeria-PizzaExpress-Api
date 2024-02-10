package com.mk.pizzaexpress.presentation;

import com.mk.pizzaexpress.bussines.servicesImpl.PizzaServiceImpl;
import com.mk.pizzaexpress.domain.dto.producto.pizza.CrearPizzaDto;
import com.mk.pizzaexpress.domain.dto.producto.pizza.PizzaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    @Autowired
    PizzaServiceImpl pizzaServiceImpl;


    @GetMapping
    ResponseEntity<List<PizzaDto>> listarTodasLasPizzas(){
        return ResponseEntity.status(HttpStatus.OK).body(pizzaServiceImpl.listarTodasLasPizzas());
    }

    @GetMapping("{id}")
    ResponseEntity<PizzaDto> listarUnaPizza(@PathVariable(name = "id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(pizzaServiceImpl.listarUnaPizza(id));
    }

    @PostMapping
    ResponseEntity<PizzaDto> crearPizza(@RequestBody CrearPizzaDto crearPizzaDto , @RequestParam(name = "imagen") MultipartFile imagen){
        return ResponseEntity.status(HttpStatus.CREATED).body(pizzaServiceImpl.crearUnaPizza(crearPizzaDto,imagen));
    }

    @PutMapping("editar/{id}")
    ResponseEntity<PizzaDto> editarUnaPizza(@PathVariable(name = "id") int id , @RequestBody CrearPizzaDto crearPizzaDto){
        return ResponseEntity.status(HttpStatus.OK).body(pizzaServiceImpl.editarUnaPizza(id,crearPizzaDto));
    }

    @PutMapping("imagen/{id}")
    ResponseEntity<PizzaDto> editarImagenDePizza(@PathVariable(name = "id") int id , @RequestParam(name = "imagen") MultipartFile imagen){
        return ResponseEntity.status(HttpStatus.OK).body(pizzaServiceImpl.editarImagenDepizza(id,imagen));
    }

    @PostMapping("{pizzaId}/{recetaId}")
    ResponseEntity<PizzaDto> agregarReceta(@PathVariable(name = "pizzaId")int pizzaId,@PathVariable(name = "recetaId") int recetaId){
        return ResponseEntity.status(HttpStatus.OK).body(pizzaServiceImpl.agreagarReceta(pizzaId,recetaId));
    }

    @PostMapping("precio/{id}")
    ResponseEntity<PizzaDto> modificarPrecioDePizza(@PathVariable(name = "id") int id , @RequestBody int precio){
        return ResponseEntity.status(HttpStatus.OK).body(pizzaServiceImpl.modificarPrecioDePizza(id,precio));
    }

    @DeleteMapping("eliminar/{id}")
    ResponseEntity<PizzaDto> eliminarPizza (@PathVariable(name = "id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(pizzaServiceImpl.eliminarUnaPizza(id));
    }
}
