package com.mk.pizzaexpress.bussines.mapper.implMapper;

import com.mk.pizzaexpress.domain.dto.usuario.CrearClienteDto;
import com.mk.pizzaexpress.domain.dto.usuario.CrearUsuarioDto;
import com.mk.pizzaexpress.domain.entity.usuarios.Cliente;
import com.mk.pizzaexpress.domain.entity.usuarios.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ClienteMapper {
    Cliente deCrearUsuarioDtoAUsuario(CrearClienteDto crearClienteDto);

}
