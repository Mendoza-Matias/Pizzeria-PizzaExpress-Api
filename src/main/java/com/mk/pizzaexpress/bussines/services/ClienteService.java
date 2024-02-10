package com.mk.pizzaexpress.bussines.services;


import com.mk.pizzaexpress.domain.dto.cliente.ClienteDto;
import com.mk.pizzaexpress.domain.dto.cliente.CrearClienteDto;

public interface ClienteService {

        ClienteDto buscarClientePorEmail(String email);
        ClienteDto crearCliente(CrearClienteDto cliente);
        ClienteDto modificarClave(String email , String clave , String claveNueva);
        ClienteDto modificarDireccion(int id, String direccionNueva);
        ClienteDto modificarLocalidad(int id , String localidadNueva );
        ClienteDto eliminarCliente(String email , String clave);

        boolean existeUsuarioConEmail(String email);

        boolean existeUsuarioConClave(String clave);





}
