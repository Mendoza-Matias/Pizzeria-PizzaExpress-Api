package com.mk.pizzaexpress.bussines.services.servicesImpl;

import com.mk.pizzaexpress.bussines.mapper.implMapper.ClienteMapper;
import com.mk.pizzaexpress.bussines.services.ClienteService;
import com.mk.pizzaexpress.domain.dto.usuario.ClienteDto;
import com.mk.pizzaexpress.domain.dto.usuario.CrearClienteDto;
import com.mk.pizzaexpress.domain.dto.usuario.ModificarClienteDto;
import com.mk.pizzaexpress.domain.entity.enums.Rol;
import com.mk.pizzaexpress.domain.entity.usuarios.Cliente;
import com.mk.pizzaexpress.domain.exceptions.ClienteException;
import com.mk.pizzaexpress.domain.exceptions.NotFoundException;
import com.mk.pizzaexpress.persistence.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<ClienteDto> listarTodosLosClientes() {
        return clienteMapper.toDtoList(clienteRepository.findAll());
    }
    @Override
    public ClienteDto crearCliente(CrearClienteDto crearClienteDto) {

        if(existeEmail(crearClienteDto.getEmail())){
            throw new ClienteException("Este email ya esta registrado");
        }
        Cliente cliente = clienteMapper.deCrearUsuarioDtoAUsuario(crearClienteDto);
        cliente.setNombre(crearClienteDto.getNombre());
        cliente.setEmail(crearClienteDto.getEmail());
        cliente.setRol(Rol.CLIENTE);
        cliente.setClave(passwordEncoder.encode(crearClienteDto.getClave()));
        cliente.setTelefono(crearClienteDto.getTelefono());
        cliente.setDireccion(crearClienteDto.getDireccion());
        //cliente.setPedidos();

        return clienteMapper.toDto(clienteRepository.save(cliente));
    }

    @Override
    public ClienteDto modificarCliente(int id, ModificarClienteDto modificarClienteDto) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new NotFoundException("Cliente no encontrado"));
        cliente.setNombre(modificarClienteDto.getNombre());
        cliente.setDireccion(modificarClienteDto.getDireccion());
        cliente.setTelefono(modificarClienteDto.getTelefono());
        return clienteMapper.toDto(clienteRepository.save(cliente));
    }

    @Override
    public ClienteDto modificarClave(int id, String clave) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new NotFoundException("Cliente no encontrado"));
        cliente.setClave(passwordEncoder.encode(clave));
        return clienteMapper.toDto(clienteRepository.save(cliente));
    }

    @Override
    public ClienteDto buscarClientePorId(int id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new NotFoundException("Cliente no encontrado"));
        return clienteMapper.toDto(cliente);
    }

    @Override
    public ClienteDto eliminarCliente(int id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new NotFoundException("Cliente no encontrado"));
        clienteRepository.deleteById(id);
        return clienteMapper.toDto(cliente);
    }

    @Override
    public boolean existeEmail(String email) {
        return clienteRepository.existsByEmail(email);
    }
}
