package com.mk.pizzaexpress.bussines.services;

import com.mk.pizzaexpress.domain.dto.cliente.ClienteDto;
import com.mk.pizzaexpress.domain.dto.cliente.CrearClienteDto;
import com.mk.pizzaexpress.domain.dto.direccion.DireccionDto;
import com.mk.pizzaexpress.domain.dto.usuario.ClienteClaveDto;

import java.util.List;

public interface ClienteService {

    List <ClienteDto> listarTodosLosClientes();
    ClienteDto obtenerClientePorId(int clienteId);
    ClienteDto crearCliente(CrearClienteDto crearCliente);
    ClienteDto modificarDireccion(int clienteId, DireccionDto direccion);
    ClienteDto modificarClave(ClienteClaveDto clienteClave);
    ClienteDto eliminarCliente(int clienteId);
    boolean existeClienteConEmail(String email);

}
