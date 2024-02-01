package com.mk.pizzaexpress.bussines.mapper.implMapper;

import com.mk.pizzaexpress.bussines.mapper.IMapper;
import com.mk.pizzaexpress.domain.dto.proveedor.CrearProveedorDto;
import com.mk.pizzaexpress.domain.dto.proveedor.ProveedorDto;
import com.mk.pizzaexpress.domain.entity.user.Proveedor;

public interface ProveedorMapper extends IMapper<Proveedor, ProveedorDto> {

    Proveedor aProvedorDeCrearProveedorDto(CrearProveedorDto crearProveedorDto);
}
