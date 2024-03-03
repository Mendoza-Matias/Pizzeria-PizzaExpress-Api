package com.mk.pizzaexpress.presentation.controller;

import com.mk.pizzaexpress.bussines.services.servicesImpl.PedidoServiceImpl;
import com.mk.pizzaexpress.domain.dto.pedido.PedidoDto;
import com.mk.pizzaexpress.domain.entity.enums.EstadoPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoServiceImpl pedidoServiceImpl;

    @PreAuthorize("permitAll")
    @GetMapping
    ResponseEntity<List<PedidoDto>> listarTodosLosPedidos(){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServiceImpl.listarTodosLosPedidos());
    }

    @PreAuthorize("permitAll")
    @PostMapping("{id}/{pizzaId}")
    ResponseEntity<PedidoDto> crearPedidoDePizza(@PathVariable(name = "id") int id , @PathVariable(name = "pizzaId") int pizzaId , @RequestBody int cantidad){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoServiceImpl.CrearPedidoDePizza(id,pizzaId,cantidad));
    }

    @PreAuthorize("permitAll")
    @PostMapping("pedidoPizza/{id}/{bebidaId}")
     ResponseEntity<PedidoDto> crearPedidoDeBebida(@PathVariable(name = "id") int id , @PathVariable(name = "bebidaId") int bebidaId , @RequestBody int cantidad){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoServiceImpl.CrearPedidoDePizza(id,bebidaId,cantidad));
    }

    @PreAuthorize("permitAll")
    @PutMapping("modificarPedidoPizza/{id}/{pizzaId}")
    ResponseEntity<PedidoDto> modificarPedidoDePizza(@PathVariable(name = "id") int id , @PathVariable(name = "pizzaId") int pizzaId , @RequestBody int cantidad){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoServiceImpl.CrearPedidoDePizza(id,pizzaId,cantidad));
    }

    @PreAuthorize("permitAll")
    @PutMapping("modificarPedidoBebida/{id}/{bebidaId}")
    ResponseEntity<PedidoDto> modificarPedidoDeBebida(@PathVariable(name = "id") int id , @PathVariable(name = "bebidaId") int bebidaId , @RequestBody int cantidad){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoServiceImpl.CrearPedidoDePizza(id,bebidaId,cantidad));
    }

    @PreAuthorize("permitAll")
    @PutMapping("estadoPedido/{id}")
    ResponseEntity<PedidoDto> modificarEstadoDePedido(@PathVariable(name = "id") int id ){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServiceImpl.modificarEstadoDePedido(id));
    }

    @PreAuthorize("permitAll")
    @DeleteMapping("eliminar/{id}")
    ResponseEntity<PedidoDto> eliminarPedido(@PathVariable(name = "id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServiceImpl.eliminarUnPedido(id));
    }

}
