package com.mk.pizzaexpress.presentation.controller;

import com.mk.pizzaexpress.bussines.services.servicesImpl.ImagenesServiceImpl;
import com.mk.pizzaexpress.bussines.services.servicesImpl.PizzaServiceImpl;
import com.mk.pizzaexpress.domain.dto.producto.pizza.CrearPizzaDto;
import com.mk.pizzaexpress.domain.dto.producto.pizza.PizzaDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Tag(name = "5. Pizzas", description = "API para gestión de productos (Pizzas)")

@RestController
@RequestMapping("/api/pizzas")

@SecurityRequirement(name = "Bearer Authentication")

public class PizzaController {

    @Autowired
    private PizzaServiceImpl pizzaServiceImpl;

    @Autowired
    private ImagenesServiceImpl imagenesServiceImpl;

    @Operation(summary = "Listar todas las pizzas", description = "Lista todas las pizzas")
    @ApiResponse(responseCode = "200", description = "Pizzas listadas.")

    @PreAuthorize("permitAll")
    @GetMapping
    ResponseEntity<List<PizzaDto>> listarTodasLasPizzas(){
        return ResponseEntity.status(HttpStatus.OK).body(pizzaServiceImpl.listarTodasLasPizzas());
    }

    @Operation(summary = "Obtener una pizza por nombre", description = "Obtiene una pizza por su nombre")
    @ApiResponse(responseCode = "200", description = "Pizza.")

    @PreAuthorize("permitAll")
    @GetMapping("{nombre}")
    ResponseEntity<PizzaDto> BuscarUnaPizzaPorNombre(@PathVariable(name = "nombre") String nombre){
        return ResponseEntity.status(HttpStatus.OK).body(pizzaServiceImpl.obtenerUnaPizzaPorSuNombre(nombre));
    }

    @Operation(summary = "Crear pizza", description = "Crea una pizza")
    @ApiResponse(responseCode = "200", description = "Pizza creada.")

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR') || hasRole('ROLE_EMPLEADO')")
    @PostMapping
    ResponseEntity<PizzaDto> crearPizza(@RequestBody CrearPizzaDto crearPizzaDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pizzaServiceImpl.crearUnaPizza(crearPizzaDto));
    }

    @Operation(summary = "Agregar imagen de pizza", description = "Agrega una imagen a una bebida")
    @ApiResponse(responseCode = "200", description = "Imagen agregada.")

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @PutMapping("{id}/imagen")
    ResponseEntity<PizzaDto> agregarImagenDePizza(@PathVariable(name = "id") int id , @RequestParam(name = "imagen") MultipartFile imagen){
        return ResponseEntity.status(HttpStatus.OK).body(imagenesServiceImpl.agregarImagenDePizza(id,imagen));
    }

    @Operation(summary = "Modificar precio de pizza", description = "Modifica el precio de una pizza")
    @ApiResponse(responseCode = "200", description = "Precio modificado.")

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @PutMapping("{id}/precio")
    ResponseEntity<PizzaDto> modificarPrecioDePizza(@PathVariable(name = "id") int id , @RequestParam int precio){
        return ResponseEntity.status(HttpStatus.OK).body(pizzaServiceImpl.modificarElPrecioDeUnaPizza(id,precio));
    }

    @Operation(summary = "Eliminar pizza", description = "Elimina una pizza")
    @ApiResponse(responseCode = "200", description = "Pizza eliminada.")

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @DeleteMapping("{id}/eliminar")
    ResponseEntity<PizzaDto> eliminarPizza (@PathVariable(name = "id") int id) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(pizzaServiceImpl.eliminarUnaPizza(id));
    }
}
