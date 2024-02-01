package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.administrador.AdministradorDto;
import com.mk.pizzaexpress.domain.dto.administrador.CrearAdministradorDto;
import com.mk.pizzaexpress.domain.dto.cliente.ClienteDto;

import java.util.List;

public interface AdministradorService {


    List <AdministradorDto> listarTodosLosAdministradores();
    AdministradorDto crearAdministrador(CrearAdministradorDto administrador);
    AdministradorDto modificarClave(String email , String clave);

    AdministradorDto eliminarAdministrador(String email,String clave);

    boolean existeAdministradorConEmail(String email);

    boolean existeAdministradorConClave(String clave);
}
