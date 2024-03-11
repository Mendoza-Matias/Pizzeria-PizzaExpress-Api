package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.usuario.AdminRequest;
import com.mk.pizzaexpress.domain.dto.usuario.CrearUsuarioDto;
import com.mk.pizzaexpress.domain.dto.usuario.UsuarioClaveDto;
import com.mk.pizzaexpress.domain.dto.usuario.UsuarioDto;
import com.mk.pizzaexpress.domain.entity.enums.Rol;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDto> listarTodosLosUsuarios ();
    UsuarioDto obtenerUsuarioPorId(int usuarioId);
    UsuarioDto crearUsuario(CrearUsuarioDto crearUsuarioDTO);
    UsuarioDto modificarClaveDeUsuario(UsuarioClaveDto usuarioClave);
    UsuarioDto modificarRolUsuario(int usuarioId , AdminRequest adminRequest);
    UsuarioDto eliminarUsuario(UsuarioClaveDto usuarioClave);
    boolean existeUsuarioConEmail(String email);
}
