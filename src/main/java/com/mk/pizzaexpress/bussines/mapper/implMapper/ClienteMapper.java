package com.mk.pizzaexpress.bussines.mapper.implMapper;

import com.mk.pizzaexpress.domain.dto.cliente.ClienteDto;
import com.mk.pizzaexpress.domain.dto.cliente.CrearClienteDto;
import com.mk.pizzaexpress.domain.entity.usuarios.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ClienteMapper {


    ClienteDto aClienteDto(Cliente cliente);
    Cliente aClienteDeCrearClienteDto(CrearClienteDto crearClienteDto);

}
