package com.mk.pizzaexpress.bussines.servicesImpl;

import com.mk.pizzaexpress.bussines.mapper.implMapper.ClienteMapper;
import com.mk.pizzaexpress.bussines.mapper.implMapper.ClienteMapperImpl;
import com.mk.pizzaexpress.domain.dto.cliente.ClienteDto;
import com.mk.pizzaexpress.domain.dto.cliente.CrearClienteDto;
import com.mk.pizzaexpress.domain.entity.enums.Rol;
import com.mk.pizzaexpress.domain.entity.user.Cliente;
import com.mk.pizzaexpress.persistence.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class ClienteServiceImplTest {


    private ClienteDto clienteDto;
    private CrearClienteDto crearClienteDto;

    @InjectMocks
    ClienteServiceImpl clienteService;
    @Mock
    ClienteRepository clienteRepository;

    @Spy
    ClienteMapper clienteMapper = new ClienteMapperImpl();

    @BeforeEach
    void setUp(){

        clienteDto = ClienteDto.builder()
                .id(2)
                .nombre("juan")
                .telefono(1140802182)
                .direccion("mi casa 123")
                .localidad("san miguel")
                .build();

        crearClienteDto = CrearClienteDto.builder()
                .nombre("matias")
                .email("matias@gmail")
                .clave("1234")
                .telefono(1170001025)
                .direccion("calle falsa 123")
                .localidad("moreno")
                .build();
    }

    @Test
    void crearCliente() {

        Cliente cliente = clienteMapper.aClienteDeCrearClienteDto(crearClienteDto);

        cliente.setId(1);
        cliente.setRol(Rol.USUARIO);

        when(clienteRepository.save(cliente)).thenReturn(cliente);

        ClienteDto service = clienteService.crearCliente(crearClienteDto);

        assertAll(()->{
            assertEquals(cliente.getId(),service.getId());
            assertEquals(cliente.getNombre(),service.getNombre());
            assertEquals(cliente.getDireccion(),service.getDireccion());
            assertEquals(cliente.getLocalidad(),service.getLocalidad());
            assertEquals(cliente.getTelefono(),service.getTelefono());
        });


    }

    @Test
    void modificarClave() {
    }

    @Test
    void modificarDireccion() {
    }

    @Test
    void modificarLocalidad() {
    }

    @Test
    void eliminarCliente() {

    }
}