package com.mk.pizzaexpress.bussines.servicesImpl;

import com.mk.pizzaexpress.bussines.mapper.implMapper.AdministradorMapper;
import com.mk.pizzaexpress.bussines.services.AdministradorService;
import com.mk.pizzaexpress.domain.dto.administrador.AdministradorDto;
import com.mk.pizzaexpress.domain.dto.administrador.CrearAdministradorDto;
import com.mk.pizzaexpress.domain.entity.user.Administrador;
import com.mk.pizzaexpress.persistence.repository.AdministradorRepository;
import org.aspectj.lang.annotation.Before;
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
    public AdministradorDto crearAdministrador(CrearAdministradorDto administrador) {
        return null;
    }

    @Override
    public AdministradorDto modificarClave(String correo, String clave) {
        return null;
    }

    @Override
    public AdministradorDto eliminarCliente(String correo, String clave) {
        return null;
    }
}
