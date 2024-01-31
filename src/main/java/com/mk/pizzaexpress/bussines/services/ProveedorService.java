package com.mk.pizzaexpress.bussines.services;


import com.mk.pizzaexpress.domain.dto.proveedor.CrearProveedorDto;
import com.mk.pizzaexpress.domain.dto.proveedor.ProveedorDto;

import java.util.List;


public interface ProveedorService {

    List<ProveedorDto> listarTodosLosProveedores ();
    ProveedorDto crearUnProveedor (CrearProveedorDto cliente);
    ProveedorDto modificarClave(String correo,String clave);
    ProveedorDto eliminarProveedor (String correo , String clave);
}
