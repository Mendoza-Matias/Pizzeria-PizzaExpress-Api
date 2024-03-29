package com.mk.pizzaexpress.bussines.mapper.implMapper;

import com.mk.pizzaexpress.bussines.mapper.IMapper;
import com.mk.pizzaexpress.domain.dto.direccion.DireccionDto;
import com.mk.pizzaexpress.domain.entity.direccion.Direccion;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring" , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DireccionMapper extends IMapper<Direccion, DireccionDto> {
}
