package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.usuario.ClienteDto;
import com.mk.pizzaexpress.domain.dto.usuario.CrearClienteDto;
import com.mk.pizzaexpress.domain.dto.usuario.ModificarClienteDto;

import java.util.List;

public interface ClienteService {

    List<ClienteDto> listarTodosLosClientes();
    ClienteDto crearCliente(CrearClienteDto crearClienteDto);
    ClienteDto modificarCliente(int id, ModificarClienteDto modificarClienteDto);
    ClienteDto modificarClave(int id , String clave);
    ClienteDto buscarClientePorId(int id);
    ClienteDto eliminarCliente(int id);
    boolean existeEmail(String email);

}
