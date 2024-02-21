package com.mk.pizzaexpress.bussines.services.servicesImpl;

import com.mk.pizzaexpress.bussines.services.ClienteService;
import com.mk.pizzaexpress.domain.dto.usuario.ClienteDto;
import com.mk.pizzaexpress.domain.dto.usuario.CrearClienteDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Override
    public List<ClienteDto> listarTodosLosClientes() {
        return null;
    }

    @Override
    public ClienteDto crearCliente(CrearClienteDto crearClienteDto) {
        return null;
    }

    @Override
    public ClienteDto modificarCliente(int id, ClienteDto clienteDto) {
        return null;
    }

    @Override
    public ClienteDto modificarClave(int id, String clave, CrearClienteDto crearClienteDto) {
        return null;
    }

    @Override
    public ClienteDto buscarClientePorId(int id) {
        return null;
    }

    @Override
    public ClienteDto eliminarCliente(int id) {
        return null;
    }

    @Override
    public ClienteDto esClaveCorrecta(int clave) {
        return null;
    }
}
