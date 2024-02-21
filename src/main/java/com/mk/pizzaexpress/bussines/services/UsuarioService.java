package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.usuario.AdminRequest;
import com.mk.pizzaexpress.domain.dto.usuario.CrearUsuarioDto;
import com.mk.pizzaexpress.domain.dto.usuario.UsuarioDto;
import com.mk.pizzaexpress.domain.entity.enums.Rol;

public interface UsuarioService {
    UsuarioDto crearUsuario(CrearUsuarioDto crearUsuarioDTO);
    UsuarioDto eliminarUsuario(String email , String clave);
    UsuarioDto obtenerUsuarioPorId(int id);
    UsuarioDto modificarClaveDeUsuario(String email, String clave);
    UsuarioDto modificarRolUsuario(int id, int claveMaestra, AdminRequest adminRequest);

    boolean existeUsuarioConEmail(String email);

}
