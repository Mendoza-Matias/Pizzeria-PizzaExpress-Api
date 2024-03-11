package com.mk.pizzaexpress.presentation.controller;

import com.mk.pizzaexpress.bussines.services.servicesImpl.UsuarioServiceImpl;
import com.mk.pizzaexpress.domain.dto.cliente.ClienteDto;
import com.mk.pizzaexpress.domain.dto.cliente.CrearClienteDto;
import com.mk.pizzaexpress.domain.dto.direccion.DireccionDto;
import com.mk.pizzaexpress.domain.dto.usuario.AdminRequest;
import com.mk.pizzaexpress.domain.dto.usuario.CrearUsuarioDto;
import com.mk.pizzaexpress.domain.dto.usuario.UsuarioClaveDto;
import com.mk.pizzaexpress.domain.dto.usuario.UsuarioDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Tag(name = "5. Usuario", description = "API para gestión usuarios")

@RestController
@RequestMapping("api/usuarios")

@SecurityRequirement(name = "Bearer Authentication")

public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @Operation(summary = "Listar a todos los usuarios", description = "Lista a todos los usuarios")
    @ApiResponse(responseCode = "200", description = "Usuarios listados.")

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @GetMapping()
    ResponseEntity<List<UsuarioDto>> listarTodosLosUsuarios (){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServiceImpl.listarTodosLosUsuarios());
    }

    @Operation(summary = "Obtener un usuario por Id", description = "Obtiene un usuario")
    @ApiResponse(responseCode = "200", description = "Usuario.")

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @GetMapping("{id}")
    ResponseEntity<UsuarioDto> obtenerUsuarioPorId(@PathVariable(name = "id") int usuarioId){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServiceImpl.obtenerUsuarioPorId(usuarioId));
    }

    @Operation(summary = "Crear un usuario", description = "Crea un usuario")
    @ApiResponse(responseCode = "200", description = "Usuario creado.")

    @PreAuthorize("permitAll")
    @PostMapping
    ResponseEntity<UsuarioDto> crearUsuario(@RequestBody CrearUsuarioDto crearUsuarioDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServiceImpl.crearUsuario(crearUsuarioDto));
    }

    @Operation(summary = "Modificar clave de usuario", description = "Modifica la clave de un usuario")
    @ApiResponse(responseCode = "200", description = "Clave modificada.")

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')||hasRole('ROLE_EMPLEADO')")
    @PutMapping("{id}/clave")
    ResponseEntity<UsuarioDto> modificarClaveDeUsuario(@RequestBody UsuarioClaveDto usuarioClave){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServiceImpl.modificarClaveDeUsuario(usuarioClave));
    }

    @Operation(summary = "Modificar rol de usuario", description = "Modifica el rol de un usuario")
    @ApiResponse(responseCode = "200", description = "Rol modificado.")

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR')")
    @PutMapping("{id}/rol")
    ResponseEntity<UsuarioDto> modificarRolDeUsuario(@PathVariable(name = "id") int usuarioId, @RequestBody AdminRequest adminRequest){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServiceImpl.modificarRolUsuario(usuarioId,adminRequest));
    }

    @Operation(summary = "Eliminar usuario", description = "Elimina un usuario")
    @ApiResponse(responseCode = "200", description = "Usuario eliminado.")

    @PreAuthorize("hasRole('ROLE_ADMINISTRADOR') || hasRole('ROLE_EMPLEADO')")
    @DeleteMapping("eliminar")
    ResponseEntity<UsuarioDto> eliminarUsuario(@RequestBody UsuarioClaveDto usuarioClave){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServiceImpl.eliminarUsuario(usuarioClave));
    }
}
