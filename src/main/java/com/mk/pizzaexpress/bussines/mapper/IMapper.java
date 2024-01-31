package com.mk.pizzaexpress.bussines.mapper;

import java.util.List;

public interface IMapper <ENTITY,DTO> {

    ENTITY toEntity(DTO dto); //De dto a entidad

    DTO toDto (ENTITY entity);
    List <ENTITY> toEntityList(List<DTO> dtos);

    List<DTO> toDtoList(List<ENTITY> entities);





}
