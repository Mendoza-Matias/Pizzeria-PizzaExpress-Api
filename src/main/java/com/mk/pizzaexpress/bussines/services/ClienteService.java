package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.usuario.ClienteDto;
import com.mk.pizzaexpress.domain.dto.usuario.CrearClienteDto;

import java.util.List;

public interface ClienteService {

    List<ClienteDto> listarTodosLosClientes();
    ClienteDto crearCliente(CrearClienteDto crearClienteDto);
    ClienteDto modificarCliente(int id, ClienteDto clienteDto);
    ClienteDto modificarClave(int id , String clave, CrearClienteDto crearClienteDto);
    ClienteDto buscarClientePorId(int id);
    ClienteDto eliminarCliente(int id);
    ClienteDto esClaveCorrecta(int clave);

}
