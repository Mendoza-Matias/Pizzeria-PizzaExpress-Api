package com.mk.pizzaexpress.bussines.servicesImpl;

import com.mk.pizzaexpress.bussines.mapper.implMapper.AdministradorMapper;
import com.mk.pizzaexpress.bussines.mapper.implMapper.AdministradorMapperImpl;
import com.mk.pizzaexpress.domain.dto.administrador.AdministradorDto;
import com.mk.pizzaexpress.domain.entity.enums.Rol;
import com.mk.pizzaexpress.domain.entity.user.Administrador;
import com.mk.pizzaexpress.persistence.repository.AdministradorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AdministradorServiceImplTest {

    private AdministradorDto administradorDto;

    private AdministradorDto administradorDtoDos;

    @InjectMocks
    AdministradorServiceImpl administradorService;
    @Mock
    AdministradorRepository administradorRepository;

    @Spy
    AdministradorMapper administradorMapper = new AdministradorMapperImpl();


    @BeforeEach
    void setUp() {
        administradorDto = AdministradorDto.builder()
                .id(1)
                .nombre("matias")
                .rol(Rol.ADMINISTRADOR)
                .build();

        administradorDtoDos = AdministradorDto.builder()
                .id(2)
                .nombre("juan")
                .rol(Rol.ADMINISTRADOR)
                .build();
    }

    @Test
    void listarTodosLosAdministradores() {

        List<Administrador> administradores = new ArrayList<>();
        administradores.add(administradorMapper.toEntity(administradorDto));
        administradores.add(administradorMapper.toEntity(administradorDtoDos));

        when(administradorRepository.findAll()).thenReturn(administradores);

        List<AdministradorDto> service = administradorService.listarTodosLosAdministradores();

        assertNotNull(service);
        assertEquals(administradores.size(),service.size());
        assertEquals(administradores.get(1).getNombre(),service.get(1).getNombre());

    }

    @Test
    void crearAdministrador() {
    }

    @Test
    void modificarClave() {
    }

    @Test
    void eliminarCliente() {
    }
}