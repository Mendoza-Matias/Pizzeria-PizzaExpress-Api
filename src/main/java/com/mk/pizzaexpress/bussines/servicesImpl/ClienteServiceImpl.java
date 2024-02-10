package com.mk.pizzaexpress.bussines.servicesImpl;


import com.mk.pizzaexpress.bussines.mapper.implMapper.ClienteMapper;
import com.mk.pizzaexpress.bussines.services.ClienteService;
import com.mk.pizzaexpress.domain.dto.cliente.ClienteDto;
import com.mk.pizzaexpress.domain.dto.cliente.CrearClienteDto;
import com.mk.pizzaexpress.domain.entity.enums.Rol;
import com.mk.pizzaexpress.domain.entity.usuarios.Cliente;
import com.mk.pizzaexpress.domain.exceptions.ClienteException;
import com.mk.pizzaexpress.domain.exceptions.NotFoundException;
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

        if(existeUsuarioConEmail(clienteDto.getEmail())){
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
    public ClienteDto buscarClientePorEmail(String email) {
        Cliente cliente = clienteRepository.findByEmail(email).orElseThrow(()-> new NotFoundException("Email de cliente no encontrado"));
        System.out.println(cliente.getEmail());
        return clienteMapper.aClienteDto(cliente);
    }
    @Override
    public ClienteDto modificarClave(String email , String clave , String claveNueva) {
       Cliente cliente = clienteRepository.findByEmail(email).orElseThrow(()-> new NotFoundException("Email no encontrado"));
       if(!existeUsuarioConClave(clave)){
           throw new NotFoundException("Clave no encontrada , vuelve a ingresarla");
       }
       cliente.setClave(claveNueva);
       return clienteMapper.aClienteDto(clienteRepository.save(cliente));
    }

    @Override
    public ClienteDto modificarDireccion(int id, String direccionNueva) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new NotFoundException("El cliente no existe"));
        cliente.setDireccion(direccionNueva);
        return clienteMapper.aClienteDto(clienteRepository.save(cliente));
    }

    @Override
    public ClienteDto modificarLocalidad(int id, String localidadNueva) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new NotFoundException("El cliente no existe"));
        return clienteMapper.aClienteDto(cliente);
    }

    @Override
    public ClienteDto eliminarCliente(String email, String clave) {

        Cliente cliente = clienteRepository.findByEmail(email).orElseThrow(()->new NotFoundException("Email no encontrado"));

        if(!existeUsuarioConClave(clave)){
            throw new ClienteException("Clave no encontrada , vuelve a ingresarla");
        }

        clienteRepository.deleteById(cliente.getId());

        return clienteMapper.aClienteDto(cliente);
    }

    @Override
    public boolean existeUsuarioConEmail(String email) {
        return clienteRepository.existsByEmail(email);
    }

    @Override
    public boolean existeUsuarioConClave(String clave) {
        return clienteRepository.existsByClave(clave);
    }
}
