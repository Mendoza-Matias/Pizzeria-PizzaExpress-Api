package com.mk.pizzaexpress.presentation.controller;

import com.mk.pizzaexpress.bussines.services.servicesImpl.PedidoServiceImpl;
import com.mk.pizzaexpress.domain.dto.pedido.CrearPedidoDto;
import com.mk.pizzaexpress.domain.dto.pedido.PedidoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "4. Pedidos", description = "API para gestión de pedidos")

@RestController
@RequestMapping("/api/pedidos")

@SecurityRequirement(name = "Bearer Authentication")

public class PedidoController {

    @Autowired
    private PedidoServiceImpl pedidoServiceImpl;


    @Operation(summary = "Lista todos los pedidos", description = "Lista todos los pedidos")
    @ApiResponse(responseCode = "200", description = "Pedidos listados.")

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR') || hasRole('ROLE_EMPLEADO')")
    @GetMapping
    ResponseEntity<List<PedidoDto>> listarTodosLosPedidos(){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServiceImpl.listarTodosLosPedidos());
    }

    @Operation(summary = "Obtener pedido por Id de cliente", description = "Obtiene un pedido de un cliente")
    @ApiResponse(responseCode = "200", description = "Pedido de cliente.")

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR') || hasRole('ROLE_EMPLEADO')")
    @GetMapping("{clienteId}")
    ResponseEntity<List<PedidoDto>> obtenerPedidosPorClienteId(@PathVariable(name = "clienteId") int id){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServiceImpl.obtenerPedidosPorClienteId(id));
    }

    @Operation(summary = "Crear un pedido", description = "Crea un pedido ")
    @ApiResponse(responseCode = "200", description = "Pedido creado.")

    @PreAuthorize("permitAll")
    @PostMapping("{clienteId}")
    ResponseEntity<PedidoDto> crearPedido(@PathVariable(name = "clienteId") int clienteId , @RequestBody CrearPedidoDto crearPedidoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoServiceImpl.crearPedido(clienteId,crearPedidoDto));
    }

    @Operation(summary = "Modificar pedido", description = "Modifica un pedido")
    @ApiResponse(responseCode = "200", description = "Pedido modificado.")

    @PreAuthorize("permitAll")
    @PutMapping("{clienteId}/modificar")
    ResponseEntity<PedidoDto> modificarPedido(@PathVariable(name = "clienteId") int clienteId,@RequestBody CrearPedidoDto crearPedidoDto){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServiceImpl.editarPedido(clienteId,crearPedidoDto));
    }

    @Operation(summary = "Modificar estado de pedido", description = "Modifica el estado de un pedido")
    @ApiResponse(responseCode = "200", description = "Estado de pedido modificado.")

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR') || hasRole('ROLE_EMPLEADO')")
    @PutMapping("{clienteId}/estado")
    ResponseEntity<PedidoDto> modificarEstadoDePedido(@PathVariable(name = "clienteId") int clienteId){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServiceImpl.modificarEstadoDePedido(clienteId));
    }

    @Operation(summary = "Eliminar pedido", description = "Elimina un pedido")
    @ApiResponse(responseCode = "200", description = "Pedido eliminado.")

    @PreAuthorize("hasRole('ROLE_CLIENTE')")
    @DeleteMapping("{clienteId}")
    ResponseEntity<PedidoDto> eliminarUnPedido(@PathVariable(name = "clienteId") int clienteId){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServiceImpl.eliminarUnPedido(clienteId));
    }

}
