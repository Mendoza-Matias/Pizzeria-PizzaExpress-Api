package com.mk.pizzaexpress.bussines.services;


import com.mk.pizzaexpress.domain.dto.cliente.ClienteDto;
import com.mk.pizzaexpress.domain.dto.cliente.CrearClienteDto;

public interface ClienteService {

        ClienteDto crearCliente(CrearClienteDto cliente);
        ClienteDto modificarClave(String correo , String claveNueva);
        ClienteDto modificarDireccion(String direccion , String direccionNueva);
        ClienteDto modificarLocalidad(String localidad , String localidadNueva );
        ClienteDto eliminarCliente(String correo , String clave);





}
