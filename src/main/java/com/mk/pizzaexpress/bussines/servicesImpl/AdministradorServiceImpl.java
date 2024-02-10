package com.mk.pizzaexpress.bussines.servicesImpl;

import com.mk.pizzaexpress.bussines.mapper.implMapper.AdministradorMapper;
import com.mk.pizzaexpress.bussines.services.AdministradorService;
import com.mk.pizzaexpress.domain.dto.administrador.AdministradorDto;
import com.mk.pizzaexpress.domain.dto.administrador.CrearAdministradorDto;
import com.mk.pizzaexpress.domain.entity.enums.Rol;
import com.mk.pizzaexpress.domain.entity.usuarios.Administrador;
import com.mk.pizzaexpress.domain.exceptions.AdministradorException;
import com.mk.pizzaexpress.domain.exceptions.NotFoundException;
import com.mk.pizzaexpress.persistence.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    AdministradorRepository administradorRepository;

    @Autowired
    AdministradorMapper administradorMapper;

    @Override
    public List<AdministradorDto> listarTodosLosAdministradores() {
        return administradorMapper.toDtoList(administradorRepository.findAll());
    }

    @Override
    public AdministradorDto crearAdministrador(CrearAdministradorDto crearAdministradorDto) {

        if(existeAdministradorConEmail(crearAdministradorDto.getEmail())){
            throw new AdministradorException("Este email ya esta registrado");
        }

        Administrador administrador = administradorMapper.aAdminstradorDeCrearAdministradorDto(crearAdministradorDto);
        administrador.setNombre(crearAdministradorDto.getNombre());
        administrador.setEmail(crearAdministradorDto.getEmail());
        administrador.setClave(crearAdministradorDto.getClave());
        administrador.setRol(Rol.ADMINISTRADOR);

        return administradorMapper.toDto(administradorRepository.save(administrador));
    }

    @Override
    public AdministradorDto modificarClave(String email, String clave) {

        Administrador administrador = administradorRepository.findByEmail(email).orElseThrow(()-> new NotFoundException("Email no encontrado"));
        administrador.setClave(clave);
        return administradorMapper.toDto(administradorRepository.save(administrador));
    }

    @Override
    public AdministradorDto eliminarAdministrador(String email, String clave) {
        Administrador administrador = administradorRepository.findByEmail(email).orElseThrow(()-> new NotFoundException("Email no encontrado"));

        if(!existeAdministradorConClave(clave)){
            throw new AdministradorException("Clave no encontrada , vuelve a ingresarla");
        }

        administradorRepository.deleteById(administrador.getId());

        return administradorMapper.toDto(administrador);
    }

    @Override
    public boolean existeAdministradorConEmail(String email) {
        return administradorRepository.existsByEmail(email);
    }

    @Override
    public boolean existeAdministradorConClave(String clave) {
        return administradorRepository.existsByClave(clave);
    }
}
