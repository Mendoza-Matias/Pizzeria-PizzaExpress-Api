package com.mk.pizzaexpress.presentation.controller;

import com.mk.pizzaexpress.bussines.services.servicesImpl.UsuarioServiceImpl;
import com.mk.pizzaexpress.domain.dto.cliente.ClienteDto;
import com.mk.pizzaexpress.domain.dto.cliente.CrearClienteDto;
import com.mk.pizzaexpress.domain.dto.direccion.DireccionDto;
import com.mk.pizzaexpress.domain.dto.usuario.AdminRequest;
import com.mk.pizzaexpress.domain.dto.usuario.CrearUsuarioDto;
import com.mk.pizzaexpress.domain.dto.usuario.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;
    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @GetMapping("{id}")
    ResponseEntity<UsuarioDto> obtenerUsuarioPorId(@PathVariable(name = "id") int usuarioId){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServiceImpl.obtenerUsuarioPorId(usuarioId));
    }
    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR') || hasRole('ROLE_EMPLEADO')")
    @PostMapping
    ResponseEntity<UsuarioDto> crearUsuario(@RequestBody CrearUsuarioDto crearUsuarioDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServiceImpl.crearUsuario(crearUsuarioDto));
    }
    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')||hasRole('ROLE_EMPLEADO') )")
    @PutMapping("{id}/clave")
    ResponseEntity<UsuarioDto> modificarClaveDeUsuario(@PathVariable(name = "id") int usuarioId,@RequestBody String email, @RequestBody String clave){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServiceImpl.modificarClaveDeUsuario(usuarioId,email,clave));
    }
    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR'))")
    @PutMapping("{id}/rol")
    ResponseEntity<UsuarioDto> modificarRolDeUsuario(@PathVariable(name = "id") int usuarioId, @RequestBody AdminRequest adminRequest){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServiceImpl.modificarRolUsuario(usuarioId,adminRequest));
    }
    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR') || hasRole('ROLE_EMPLEADO'))")
    @DeleteMapping("{id}")
    ResponseEntity<UsuarioDto> eliminarUsuario(@RequestBody String email,@RequestBody String clave){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServiceImpl.eliminarUsuario(email,clave));
    }
}
