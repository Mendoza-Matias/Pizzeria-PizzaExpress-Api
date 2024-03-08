package com.mk.pizzaexpress.presentation.controller;

import com.mk.pizzaexpress.bussines.services.servicesImpl.PedidoServiceImpl;
import com.mk.pizzaexpress.domain.dto.pedido.CrearPedidoDto;
import com.mk.pizzaexpress.domain.dto.pedido.PedidoDto;
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


    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR') || hasRole('ROLE_EMPLEADO')")
    @GetMapping
    ResponseEntity<List<PedidoDto>> listarTodosLosPedidos(){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServiceImpl.listarTodosLosPedidos());
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR') || hasRole('ROLE_EMPLEADO')")
    @GetMapping("{clienteId}")
    ResponseEntity<List<PedidoDto>> obtenerPedidosPorClienteId(@PathVariable(name = "clienteId") int id){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServiceImpl.obtenerPedidosPorClienteId(id));
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE')")
    @PostMapping("{clienteId}")
    ResponseEntity<PedidoDto> crearPedidoDePizza(@PathVariable(name = "clienteId") int clienteId , @RequestBody CrearPedidoDto crearPedidoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoServiceImpl.crearPedido(clienteId,crearPedidoDto));
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE')")
    @PutMapping("{clienteId}/modificar")
    ResponseEntity<PedidoDto> modificarPedido(@PathVariable(name = "clienteId") int clienteId,@RequestBody CrearPedidoDto crearPedidoDto){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServiceImpl.editarPedido(clienteId,crearPedidoDto));
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR') || hasRole('ROLE_EMPLEADO')")
    @PutMapping("{clienteId}/estado")
    ResponseEntity<PedidoDto> modificarEstadoDePedido(@PathVariable(name = "clienteId") int clienteId){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServiceImpl.modificarEstadoDePedido(clienteId));
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE')")
    @DeleteMapping("{clienteId}")
    ResponseEntity<PedidoDto> eliminarUnPedido(@PathVariable(name = "clienteId") int clienteId){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServiceImpl.eliminarUnPedido(clienteId));
    }

}
