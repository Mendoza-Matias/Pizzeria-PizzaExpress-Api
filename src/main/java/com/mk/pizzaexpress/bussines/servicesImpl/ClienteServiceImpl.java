package com.mk.pizzaexpress.bussines.servicesImpl;


import com.mk.pizzaexpress.bussines.mapper.implMapper.ClienteMapper;
import com.mk.pizzaexpress.bussines.services.ClienteService;
import com.mk.pizzaexpress.domain.dto.cliente.ClienteDto;
import com.mk.pizzaexpress.domain.dto.cliente.CrearClienteDto;
import com.mk.pizzaexpress.domain.entity.enums.Rol;
import com.mk.pizzaexpress.domain.entity.user.Cliente;
import com.mk.pizzaexpress.domain.exceptions.ClienteException;
import com.mk.pizzaexpress.persistence.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClienteMapper clienteMapper;

    @Override
    public ClienteDto crearCliente(CrearClienteDto clienteDto) {

        if(clienteRepository.existEmail(clienteDto.getEmail())){
            throw new ClienteException("Este email ya esta registrado");
        }

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
    public ClienteDto modificarClave(String email, String claveNueva) {
       Cliente cliente = clienteRepository.findByEmail(email).orElseThrow(()-> new ClienteException("Email no encontrado"));
       cliente.setClave(claveNueva);
       return clienteMapper.aClienteDto(clienteRepository.save(cliente));
    }

    @Override
    public ClienteDto modificarDireccion(int id, String direccionNueva) {
        return null;
    }

    @Override
    public ClienteDto modificarLocalidad(int id, String localidadNueva) {
        return null;
    }

    @Override
    public ClienteDto eliminarCliente(String email, String clave) {

        Cliente cliente = clienteRepository.findByEmail(email).orElseThrow(()->new ClienteException("Email no encontrado"));

        if(clienteRepository.existClave(clave)){
            throw new ClienteException("Clave no encontrada");
        }

        clienteRepository.deleteById(cliente.getId());

        return clienteMapper.aClienteDto(cliente);
    }
}
