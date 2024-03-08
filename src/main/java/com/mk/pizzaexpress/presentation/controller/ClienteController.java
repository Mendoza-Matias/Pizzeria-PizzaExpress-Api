package com.mk.pizzaexpress.presentation.controller;

import com.mk.pizzaexpress.bussines.services.servicesImpl.ClienteServiceImpl;
import com.mk.pizzaexpress.domain.dto.cliente.ClienteDto;
import com.mk.pizzaexpress.domain.dto.cliente.CrearClienteDto;
import com.mk.pizzaexpress.domain.dto.direccion.DireccionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR') || hasRole('ROLE_EMPLEADO')")
    @GetMapping
    ResponseEntity<List<ClienteDto>> listarTodosLosClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteServiceImpl.listarTodosLosClientes());
    }
    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR') || hasRole('ROLE_EMPLEADO')")
    @GetMapping("{id}")
    ResponseEntity<ClienteDto> obtenerClientePorId(@PathVariable(name = "id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(clienteServiceImpl.obtenerClientePorId(id));
    }
    @PreAuthorize("hasRole('ROLE_CLIENTE'))")
    @PostMapping
    ResponseEntity<ClienteDto> crearCliente(@RequestBody CrearClienteDto crearClienteDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteServiceImpl.crearCliente(crearClienteDto));
    }
    @PreAuthorize("hasRole('ROLE_CLIENTE'))")
    @PutMapping("{id}/direccion")
    ResponseEntity<ClienteDto> modificarDireccion(@PathVariable(name = "id") int id , @RequestBody DireccionDto direccionDto){
        return ResponseEntity.status(HttpStatus.OK).body(clienteServiceImpl.modificarDireccion(id,direccionDto));
    }
    @PreAuthorize("hasRole('ROLE_CLIENTE'))")
    @PutMapping("{id}/clave")
    ResponseEntity<ClienteDto> modificarClave(@PathVariable(name = "id") int id , @RequestBody String clave){
        return ResponseEntity.status(HttpStatus.OK).body(clienteServiceImpl.modificarClave(id,clave));
    }
    @PreAuthorize("hasRole('ROLE_ADMINISTRADO') || hasRole('ROLE_CLIENTE'))")
    @DeleteMapping("{id}")
    ResponseEntity<ClienteDto> eliminarCliente(@PathVariable(name = "id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(clienteServiceImpl.eliminarCliente(id));
    }

}
