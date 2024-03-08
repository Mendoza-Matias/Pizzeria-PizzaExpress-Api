package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.usuario.AdminRequest;
import com.mk.pizzaexpress.domain.dto.usuario.CrearUsuarioDto;
import com.mk.pizzaexpress.domain.dto.usuario.UsuarioDto;
import com.mk.pizzaexpress.domain.entity.enums.Rol;

public interface UsuarioService {
    UsuarioDto obtenerUsuarioPorId(int usuarioId);
    UsuarioDto crearUsuario(CrearUsuarioDto crearUsuarioDTO);
    UsuarioDto eliminarUsuario(String emailUsuario , String claveUsuario);
    UsuarioDto modificarClaveDeUsuario(int usuarioId,String email, String clave);
    UsuarioDto modificarRolUsuario(int usuarioId , AdminRequest adminRequest);
    boolean existeUsuarioConEmail(String email);

}
