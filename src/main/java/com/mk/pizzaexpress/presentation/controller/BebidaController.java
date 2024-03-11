package com.mk.pizzaexpress.presentation.controller;

import com.mk.pizzaexpress.bussines.services.servicesImpl.BebidaServiceImpl;
import com.mk.pizzaexpress.bussines.services.servicesImpl.ImagenesServiceImpl;
import com.mk.pizzaexpress.domain.dto.producto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.producto.bebida.CrearBebidaDto;
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

@Tag(name = "2. Bebidas", description = "API para gestión de productos (Bebidas)")

@RestController
@RequestMapping("api/bebidas")

@SecurityRequirement(name = "Bearer Authentication")

public class BebidaController {
    @Autowired
    private BebidaServiceImpl bebidaServiceImpl;

    @Autowired
    private ImagenesServiceImpl imagenesServiceImpl;

    @Operation(summary = "Listar todas las bebidas", description = "Lista todas las bebidas")
    @ApiResponse(responseCode = "200", description = "Bebidas listadas.")

    @PreAuthorize("permitAll")
    @GetMapping
    ResponseEntity<List<BebidaDto>> listarTodasLasBebidas(){
        return ResponseEntity.status(HttpStatus.OK).body(bebidaServiceImpl.listarTodasLasBebidas());
    }

    @Operation(summary = "Obtener bebida por marca", description = "Obtiene una bebida por su marca")
    @ApiResponse(responseCode = "200", description = "Bebida.")

    @PreAuthorize("permitAll")
    @GetMapping("{marca}")
    ResponseEntity<BebidaDto> obtenerBebidaPorMarca (@PathVariable(name = "marca") String marca){
        return ResponseEntity.status(HttpStatus.OK).body(bebidaServiceImpl.obtenerBebidaPorMarca(marca));
    }

    @Operation(summary = "Crear una bebida", description = "Crea una bebida")
    @ApiResponse(responseCode = "200", description = "Bebida creada.")

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @PostMapping
    ResponseEntity<BebidaDto> crearUnaBebida(@RequestBody CrearBebidaDto crearBebidaDto){
      return ResponseEntity.status(HttpStatus.CREATED).body(bebidaServiceImpl.crearUnaBebida(crearBebidaDto));
    }

    @Operation(summary = "Agregar imagen a bebida", description = "Agrega una imagen a una bebida.")
    @ApiResponse(responseCode = "200", description = "Imagen agregada.")

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @PutMapping("{id}/imagen")
    ResponseEntity<BebidaDto> agregarImagenDeBebida(@PathVariable(name = "id") int id , @RequestParam(name = "imagen")MultipartFile imagen){
        return ResponseEntity.status(HttpStatus.OK).body(imagenesServiceImpl.agregarImagenDeBebida(id,imagen));
    }
    @Operation(summary = "Modificar precio", description = "Modifica el precio de una bebida")
    @ApiResponse(responseCode = "200", description = "Precio modificado.")

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @PutMapping("{id}/precio")
    ResponseEntity<BebidaDto> modificarPrecioDeBebida(@PathVariable(name = "id") int id , @RequestParam int precio){
        return ResponseEntity.status(HttpStatus.OK).body(bebidaServiceImpl.modificarPrecioDeBebida(id,precio));
    }

    @Operation(summary = "Eliminar una bebida", description = "Elimina una bebida")
    @ApiResponse(responseCode = "200", description = "Bebida eliminada.")

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @DeleteMapping("{id}")
    ResponseEntity<BebidaDto> eliminarUnaBebida(@PathVariable(name = "id") int id) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(bebidaServiceImpl.eliminarUnaBebida(id));
    }
}
