package com.mk.pizzaexpress.bussines.servicesImpl;

import com.mk.pizzaexpress.bussines.mapper.implMapper.ProveedorMapper;
import com.mk.pizzaexpress.bussines.services.ProveedorService;
import com.mk.pizzaexpress.domain.dto.proveedor.CrearProveedorDto;
import com.mk.pizzaexpress.domain.dto.proveedor.ProveedorDto;
import com.mk.pizzaexpress.domain.entity.enums.Rol;
import com.mk.pizzaexpress.domain.entity.user.Proveedor;
import com.mk.pizzaexpress.domain.exceptions.AdministradorException;
import com.mk.pizzaexpress.domain.exceptions.ProveedorException;
import com.mk.pizzaexpress.persistence.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    @Autowired
    ProveedorMapper proveedorMapper;

    @Override
    public List<ProveedorDto> listarTodosLosProveedores() {
        return proveedorMapper.toDtoList(proveedorRepository.findAll()) ;
    }

    @Override
    public ProveedorDto crearUnProveedor(CrearProveedorDto crearProveedorDto) {

        if(existeProveedorConEmail(crearProveedorDto.getEmail())){
            throw new ProveedorException("Este email ya esta registrado");
        }

        Proveedor proveedor = proveedorMapper.aProvedorDeCrearProveedorDto(crearProveedorDto);
        proveedor.setNombre(crearProveedorDto.getNombre());
        proveedor.setEmail(crearProveedorDto.getNombre());
        proveedor.setClave(crearProveedorDto.getClave());
        proveedor.setRol(Rol.PROVEEDOR);

        return proveedorMapper.toDto(proveedorRepository.save(proveedor));
    }

    @Override
    public ProveedorDto modificarClave(String email, String clave) {
        Proveedor proveedor = proveedorRepository.findByEmail(email).orElseThrow(()-> new AdministradorException("Email no encontrado"));
        proveedor.setClave(clave);
        return proveedorMapper.toDto(proveedorRepository.save(proveedor));
    }

    @Override
    public ProveedorDto eliminarProveedor(String email, String clave) {

        Proveedor proveedor = proveedorRepository.findByEmail(email).orElseThrow(()-> new AdministradorException("Email no encontrado"));

        if(existeProveedorConClave(clave)){
            throw new ProveedorException("Ingresa de nuevo la clave");
        }

        proveedorRepository.deleteById(proveedor.getId());

        return proveedorMapper.toDto(proveedor);
    }

    @Override
    public boolean existeProveedorConEmail(String email) {
        return proveedorRepository.existsByEmail(email);
    }

    @Override
    public boolean existeProveedorConClave(String clave) {
        return proveedorRepository.existsByClave(clave);
    }
}
