package com.mk.pizzaexpress.presentation.controller;

import com.mk.pizzaexpress.bussines.services.servicesImpl.BebidaServiceImpl;
import com.mk.pizzaexpress.bussines.services.servicesImpl.ImagenesServiceImpl;
import com.mk.pizzaexpress.domain.dto.producto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.producto.bebida.CrearBebidaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/bebidas")
public class BebidaController {

    @Autowired
    private BebidaServiceImpl bebidaServiceImpl;

    @Autowired
    private ImagenesServiceImpl imagenesServiceImpl;

    @PreAuthorize("permitAll")
    @GetMapping
    ResponseEntity<List<BebidaDto>> listarTodasLasBebidas(){
        return ResponseEntity.status(HttpStatus.OK).body(bebidaServiceImpl.listarTodasLasBebidas());
    }

    @PreAuthorize("permitAll")
    @GetMapping("{nombre}")
    ResponseEntity<BebidaDto> buscarBebidaPorNombre (@PathVariable(name = "nombre") String nombre){
        return ResponseEntity.status(HttpStatus.OK).body(bebidaServiceImpl.buscarBebidaPorNombre(nombre));
    }

    @PreAuthorize("permitAll")
    @PostMapping
    ResponseEntity<BebidaDto> crearUnaBebida(@RequestBody CrearBebidaDto crearBebidaDto){
      return ResponseEntity.status(HttpStatus.CREATED).body(bebidaServiceImpl.crearUnaBebida(crearBebidaDto));
    }

    @PreAuthorize("permitAll")
    @PostMapping("{id}/imagen")
    ResponseEntity<BebidaDto> agregarImagenDeBebida(@PathVariable(name = "id") int id , @RequestParam(name = "imagen")MultipartFile imagen){
        return ResponseEntity.status(HttpStatus.OK).body(imagenesServiceImpl.agregarImagenDeBebida(id,imagen));
    }

    @PreAuthorize("permitAll")
    @PutMapping("{id}/precio")
    ResponseEntity<BebidaDto> modificarPrecioDeBebida(@PathVariable(name = "id") int id , @RequestBody int precio){
        return ResponseEntity.status(HttpStatus.OK).body(bebidaServiceImpl.modificarPrecioDeBebida(id,precio));
    }

    @PreAuthorize("permitAll")
    @PutMapping("{id}/stock")
    ResponseEntity<BebidaDto> modificarStockDeBebida(@PathVariable(name = "id") int id , @RequestBody int stock){
        return ResponseEntity.status(HttpStatus.OK).body(bebidaServiceImpl.actualizarStockDeBebida(id,stock));
    }

    @PreAuthorize("permitAll")
    @DeleteMapping("{id}")
    ResponseEntity<BebidaDto> eliminarUnaBebida(@PathVariable(name = "id") int id) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(bebidaServiceImpl.eliminarUnaBebida(id));
    }
}
