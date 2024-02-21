package com.mk.pizzaexpress.presentation.controller;

import com.mk.pizzaexpress.bussines.services.servicesImpl.IngredienteServiceImpl;
import com.mk.pizzaexpress.domain.dto.ingrediente.CrearIngredienteDto;
import com.mk.pizzaexpress.domain.dto.ingrediente.IngredienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ingrediente")
public class IngredienteController {

    @Autowired
    private IngredienteServiceImpl ingredienteServiceImpl;

    @GetMapping
    ResponseEntity<List<IngredienteDto>> listarTodosLosIngrediente(){
        return ResponseEntity.status(HttpStatus.OK).body(ingredienteServiceImpl.listarTodosLosIngredientes());
    }

    @PostMapping
    ResponseEntity<IngredienteDto> crearUnIngrediente (@RequestBody CrearIngredienteDto crearIngredienteDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(ingredienteServiceImpl.crearUnIngrediente(crearIngredienteDto));
    }

    @PutMapping("{id}/stock")
    ResponseEntity<IngredienteDto> actualizarStockDeIngrediente (@PathVariable(name = "id") int id , @RequestBody CrearIngredienteDto crearIngredienteDto){
        return ResponseEntity.status(HttpStatus.OK).body(ingredienteServiceImpl.actualizarStockDeIngrediente(id,crearIngredienteDto));
    }
}
