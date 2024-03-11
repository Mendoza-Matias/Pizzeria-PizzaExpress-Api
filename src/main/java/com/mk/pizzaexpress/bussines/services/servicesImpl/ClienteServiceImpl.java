package com.mk.pizzaexpress.bussines.services.servicesImpl;

import com.mk.pizzaexpress.bussines.mapper.implMapper.ClienteMapper;
import com.mk.pizzaexpress.bussines.mapper.implMapper.DireccionMapper;
import com.mk.pizzaexpress.bussines.services.ClienteService;
import com.mk.pizzaexpress.domain.dto.cliente.ClienteDto;
import com.mk.pizzaexpress.domain.dto.cliente.CrearClienteDto;
import com.mk.pizzaexpress.domain.dto.direccion.DireccionDto;
import com.mk.pizzaexpress.domain.dto.usuario.ClienteClaveDto;
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
    private DireccionMapper direccionMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<ClienteDto> listarTodosLosClientes() {
        return clienteMapper.toDtoList(clienteRepository.findAll());
    }
    @Override
    public ClienteDto obtenerClientePorId(int clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(()-> new NotFoundException("Cliente no encontrado"));
        return clienteMapper.toDto(cliente);
    }
    @Override
    public ClienteDto crearCliente(CrearClienteDto crearCliente) {
        if(existeClienteConEmail(crearCliente.getEmail())){
            throw new ClienteException("Este email ya esta registrado");
        }
        Cliente cliente = clienteMapper.deCrearUsuarioDtoAUsuario(crearCliente);
        cliente.setNombre(crearCliente.getNombre());
        cliente.setEmail(crearCliente.getEmail());
        cliente.setClave(passwordEncoder.encode(crearCliente.getClave()));
        cliente.setTelefono(crearCliente.getTelefono());
        cliente.setDireccion(crearCliente.getDireccion());
        cliente.setRol(Rol.CLIENTE);
        return clienteMapper.toDto(clienteRepository.save(cliente));
    }
    @Override
    public ClienteDto modificarDireccion(int clienteId, DireccionDto direccion) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(()-> new NotFoundException("Cliente no encontrado"));
        cliente.setDireccion(direccionMapper.toEntity(direccion));
        return clienteMapper.toDto(clienteRepository.save(cliente));
    }
    @Override
    public ClienteDto modificarClave(ClienteClaveDto clienteClave) {
        Cliente cliente = clienteRepository.findByEmail(clienteClave.getEmail()).orElseThrow(()-> new NotFoundException("Email no encontrado"));

        if(passwordEncoder.matches(cliente.getClave(), clienteClave.getClave())){
            throw new ClienteException("Clave incorrecta");
        }
        cliente.setClave(passwordEncoder.encode(clienteClave.getNuevaClave()));

        return clienteMapper.toDto(clienteRepository.save(cliente));
    }
    @Override
    public ClienteDto eliminarCliente(int clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(()-> new NotFoundException("Cliente no encontrado"));
        clienteRepository.deleteById(clienteId);
        return clienteMapper.toDto(cliente);
    }
    @Override
    public boolean existeClienteConEmail(String email) {
        return clienteRepository.existsByEmail(email);
    }
}
