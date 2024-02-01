package com.mk.pizzaexpress.bussines.mapper.implMapper;

import com.mk.pizzaexpress.bussines.mapper.IMapper;
import com.mk.pizzaexpress.domain.dto.proveedor.CrearProveedorDto;
import com.mk.pizzaexpress.domain.dto.proveedor.ProveedorDto;
import com.mk.pizzaexpress.domain.entity.user.Proveedor;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProveedorMapper extends IMapper<Proveedor, ProveedorDto> {

    Proveedor aProvedorDeCrearProveedorDto(CrearProveedorDto crearProveedorDto);
}
