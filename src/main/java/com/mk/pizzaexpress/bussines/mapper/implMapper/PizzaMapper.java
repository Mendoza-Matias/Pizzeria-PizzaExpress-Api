package com.mk.pizzaexpress.bussines.mapper.implMapper;

import com.mk.pizzaexpress.bussines.mapper.IMapper;
import com.mk.pizzaexpress.domain.dto.pizza.CrearPizzaDto;
import com.mk.pizzaexpress.domain.dto.pizza.PizzaDto;
import com.mk.pizzaexpress.domain.entity.Pizza;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PizzaMapper extends IMapper<Pizza,PizzaDto> {

    Pizza aPizzaDeCrearPizzaDto(CrearPizzaDto crearPizzaDto);
}
