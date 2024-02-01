package com.mk.pizzaexpress.bussines.services;


import com.mk.pizzaexpress.domain.dto.proveedor.CrearProveedorDto;
import com.mk.pizzaexpress.domain.dto.proveedor.ProveedorDto;

import java.util.List;


public interface ProveedorService {

    List<ProveedorDto> listarTodosLosProveedores ();
    ProveedorDto crearUnProveedor (CrearProveedorDto crearProveedorDto);
    ProveedorDto modificarClave(String email,String clave);
    ProveedorDto eliminarProveedor (String email , String clave);

    boolean existeProveedorConEmail(String email);

    boolean existeProveedorConClave(String clave);
}
