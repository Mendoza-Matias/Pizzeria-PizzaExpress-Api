package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.administrador.AdministradorDto;
import com.mk.pizzaexpress.domain.dto.administrador.CrearAdministradorDto;
import com.mk.pizzaexpress.domain.dto.cliente.ClienteDto;

import java.util.List;

public interface AdministradorService {


    List <AdministradorDto> listarTodosLosAdministradores();
    AdministradorDto crearAdministrador(CrearAdministradorDto administrador);
    AdministradorDto modificarClave(String correo , String clave);

    AdministradorDto eliminarCliente(String correo,String clave);
}
