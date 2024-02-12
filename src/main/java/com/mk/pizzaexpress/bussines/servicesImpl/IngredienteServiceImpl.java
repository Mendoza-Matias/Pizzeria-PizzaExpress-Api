package com.mk.pizzaexpress.bussines.servicesImpl;

import com.mk.pizzaexpress.bussines.mapper.implMapper.IngredienteMapper;
import com.mk.pizzaexpress.bussines.services.IngredienteService;
import com.mk.pizzaexpress.domain.dto.ingrediente.CrearIngredienteDto;
import com.mk.pizzaexpress.domain.dto.ingrediente.IngredienteDto;
import com.mk.pizzaexpress.domain.entity.Ingrediente;
import com.mk.pizzaexpress.domain.exceptions.IngredienteException;
import com.mk.pizzaexpress.domain.exceptions.NotFoundException;
import com.mk.pizzaexpress.persistence.repository.IngredienteRepository;
import com.mk.pizzaexpress.persistence.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredienteServiceImpl implements IngredienteService {

    @Autowired
    IngredienteRepository ingredienteRepository;

    @Autowired
    RecetaRepository recetaRepository;

    @Autowired
    IngredienteMapper ingredienteMapper;

    @Override
    public List<IngredienteDto> listarTodosLosIngredientes() {
        return ingredienteMapper.toDtoList(ingredienteRepository.findAll());
    }

    @Override
    public IngredienteDto crearUnIngrediente(CrearIngredienteDto crearIngredienteDto) {

        if(existeElIngredienteConNombre(crearIngredienteDto.getNombre())){
            throw new IngredienteException("Ya existe este ingrediente");
        }

        Ingrediente ingrediente = ingredienteMapper.aIngredienteDeCrearIngredienteDto(crearIngredienteDto);
        ingrediente.setNombre(crearIngredienteDto.getNombre());
        ingrediente.setStock(crearIngredienteDto.getStock());
        return ingredienteMapper.toDto(ingredienteRepository.save(ingrediente));
    }

    @Override
    public IngredienteDto actualizarStockDeIngrediente(int id, CrearIngredienteDto crearIngredienteDto) {
        Ingrediente ingrediente = ingredienteRepository.findById(id).orElseThrow(()-> new NotFoundException("Ingrediente no encontrado"));
        ingrediente.setStock(ingrediente.getStock() + crearIngredienteDto.getStock());
        return ingredienteMapper.toDto(ingredienteRepository.save(ingrediente));
    }

    @Override
    public boolean existeElIngredienteConNombre(String nombre) {
        return ingredienteRepository.existsByNombre(nombre);
    }


}