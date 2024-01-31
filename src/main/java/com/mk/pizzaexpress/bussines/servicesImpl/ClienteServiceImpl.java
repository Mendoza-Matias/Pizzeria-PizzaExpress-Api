package com.mk.pizzaexpress.bussines.servicesImpl;


import com.mk.pizzaexpress.bussines.mapper.implMapper.ClienteMapper;
import com.mk.pizzaexpress.bussines.services.ClienteService;
import com.mk.pizzaexpress.domain.dto.cliente.ClienteDto;
import com.mk.pizzaexpress.domain.dto.cliente.CrearClienteDto;
import com.mk.pizzaexpress.domain.entity.enums.Rol;
import com.mk.pizzaexpress.domain.entity.user.Cliente;
import com.mk.pizzaexpress.persistence.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClienteMapper clienteMapper;

    @Override
    public ClienteDto crearCliente(CrearClienteDto clienteDto) {

        Cliente cliente = clienteMapper.aClienteDeCrearClienteDto(clienteDto);
        cliente.setNombre(clienteDto.getNombre());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setClave(clienteDto.getClave());
        cliente.setRol(Rol.USUARIO);
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setDireccion(clienteDto.getDireccion());
        cliente.setLocalidad(clienteDto.getLocalidad());

        return clienteMapper.aClienteDto(clienteRepository.save(cliente));
    }

    @Override
    public ClienteDto modificarClave(String correo, String claveNueva) {
        return null;
    }

    @Override
    public ClienteDto modificarDireccion(String direccion, String direccionNueva) {
        return null;
    }

    @Override
    public ClienteDto modificarLocalidad(String localidad, String localidadNueva) {
        return null;
    }

    @Override
    public ClienteDto eliminarCliente(String correo, String clave) {
        return null;
    }
}
