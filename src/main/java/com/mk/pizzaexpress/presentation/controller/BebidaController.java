package com.mk.pizzaexpress.presentation.controller;

import com.mk.pizzaexpress.bussines.services.servicesImpl.BebidaServiceImpl;
import com.mk.pizzaexpress.domain.dto.producto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.producto.bebida.CrearBebidaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/bebidas")
public class BebidaController {

    @Autowired
    private BebidaServiceImpl bebidaServiceImpl;

    @GetMapping
    ResponseEntity<List<BebidaDto>> listarTodasLasBebidas(){
        return ResponseEntity.status(HttpStatus.OK).body(bebidaServiceImpl.listarTodasLasBebidas());
    }

    @GetMapping("{nombre}")
    ResponseEntity<BebidaDto> buscarBebidaDtoResponseEntity(@PathVariable(name = "nombre") String nombre){
        return ResponseEntity.status(HttpStatus.OK).body(bebidaServiceImpl.buscarBebidaPorNombre(nombre));
    }

    @PostMapping
    ResponseEntity<BebidaDto> crearUnaBebida(@RequestBody CrearBebidaDto crearBebidaDto){
      return ResponseEntity.status(HttpStatus.CREATED).body(bebidaServiceImpl.crearUnaBebida(crearBebidaDto));
    }

    @PostMapping("{id}/imagen")
    ResponseEntity<BebidaDto> agregarImagenDeBebida(@PathVariable(name = "id") int id , @RequestParam(name = "imagen")MultipartFile imagen){
        return ResponseEntity.status(HttpStatus.OK).body(bebidaServiceImpl.agregarImagenDeBebida(id,imagen));
    }

    @PutMapping("{id}")
    ResponseEntity<BebidaDto> editarBebida(@PathVariable(name = "id") int id , @RequestBody CrearBebidaDto crearBebidaDto){
        return ResponseEntity.status(HttpStatus.OK).body(bebidaServiceImpl.editarBebida(id,crearBebidaDto));
    }

    @PutMapping("{id}/imagen")
    ResponseEntity<BebidaDto> editarImagenDeBebida(@PathVariable(name = "id") int id ,@RequestParam(name = "imagen") MultipartFile imagen){
        return ResponseEntity.status(HttpStatus.OK).body(bebidaServiceImpl.editarImagenDeBebida(id,imagen));
    }

    @PutMapping("{id}/precio")
    ResponseEntity<BebidaDto> modificarPrecioDeBebida(@PathVariable(name = "id") int id , @RequestBody CrearBebidaDto crearBebidaDto){
        return ResponseEntity.status(HttpStatus.OK).body(bebidaServiceImpl.modificarPrecioDeBebida(id,crearBebidaDto));
    }

    @PutMapping("{id}/stock")
    ResponseEntity<BebidaDto> modificarStockDeBebida(@PathVariable(name = "id") int id , @RequestBody CrearBebidaDto crearBebidaDto){
        return ResponseEntity.status(HttpStatus.OK).body(bebidaServiceImpl.actualizarStockDeBebida(id,crearBebidaDto));
    }

    @DeleteMapping("{id}")
    ResponseEntity<BebidaDto> eliminarUnaBebida(@PathVariable(name = "id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(bebidaServiceImpl.eliminarUnaBebida(id));
    }
}
