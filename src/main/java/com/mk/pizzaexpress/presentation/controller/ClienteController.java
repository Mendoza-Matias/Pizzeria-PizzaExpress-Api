package com.mk.pizzaexpress.presentation.controller;

import com.mk.pizzaexpress.bussines.services.servicesImpl.ClienteServiceImpl;
import com.mk.pizzaexpress.domain.dto.cliente.ClienteDto;
import com.mk.pizzaexpress.domain.dto.cliente.CrearClienteDto;
import com.mk.pizzaexpress.domain.dto.direccion.DireccionDto;
import com.mk.pizzaexpress.domain.dto.usuario.ClienteClaveDto;
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

@Tag(name = "3. Cliente", description = "API para gestión de clientes")

@RestController
@RequestMapping("/api/clientes")

@SecurityRequirement(name = "Bearer Authentication")

public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;


    @Operation(summary = "Listar a todos los clientes", description = "Lista a todos los clientes")
    @ApiResponse(responseCode = "200", description = "Clientes listados.")

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR') || hasRole('ROLE_EMPLEADO')")
    @GetMapping
    ResponseEntity<List<ClienteDto>> listarTodosLosClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteServiceImpl.listarTodosLosClientes());
    }

    @Operation(summary = "Obtener cliente por Id", description = "Devuelve a un cliente")
    @ApiResponse(responseCode = "200", description = "Cliente.")

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR') || hasRole('ROLE_EMPLEADO')")
    @GetMapping("{id}")
    ResponseEntity<ClienteDto> obtenerClientePorId(@PathVariable(name = "id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(clienteServiceImpl.obtenerClientePorId(id));
    }

    @Operation(summary = "Crear a un cliente", description = "Crea a un cliente")
    @ApiResponse(responseCode = "200", description = "Cliente creado.")

    @PreAuthorize("permitAll")
    @PostMapping
    ResponseEntity<ClienteDto> crearCliente(@RequestBody CrearClienteDto crearClienteDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteServiceImpl.crearCliente(crearClienteDto));
    }

    @Operation(summary = "Modificar dirección de un cliente", description = "Modifica la direccion de un cliente")
    @ApiResponse(responseCode = "200", description = "Dirección modificada.")

    @PreAuthorize("permitAll")
    @PutMapping("{id}/direccion")
    ResponseEntity<ClienteDto> modificarDireccion(@PathVariable(name = "id") int id , @RequestBody DireccionDto direccionDto){
        return ResponseEntity.status(HttpStatus.OK).body(clienteServiceImpl.modificarDireccion(id,direccionDto));
    }

    @Operation(summary = "Modificar clave de un cliente", description = "Modifica la clave de un cliente")
    @ApiResponse(responseCode = "200", description = "Lista de clientes.")

    @PreAuthorize("permitAll")
    @PutMapping("clave")
    ResponseEntity<ClienteDto> modificarClave(@RequestBody ClienteClaveDto clienteClave){
        return ResponseEntity.status(HttpStatus.OK).body(clienteServiceImpl.modificarClave(clienteClave));
    }
    @Operation(summary = "Eliminar cliente", description = "Elimina a un cliente")
    @ApiResponse(responseCode = "200", description = "CLiente eliminado.")

    @PreAuthorize("hasRole('ROLE_ADMINISTRADO') || hasRole('ROLE_CLIENTE'))")
    @DeleteMapping("{id}")
    ResponseEntity<ClienteDto> eliminarCliente(@PathVariable(name = "id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(clienteServiceImpl.eliminarCliente(id));
    }

}
