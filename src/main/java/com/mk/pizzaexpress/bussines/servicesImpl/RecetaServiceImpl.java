package com.mk.pizzaexpress.bussines.servicesImpl;

import com.mk.pizzaexpress.bussines.mapper.implMapper.RecetaMapper;
import com.mk.pizzaexpress.bussines.services.RecetaService;
import com.mk.pizzaexpress.domain.dto.receta.CrearRecetaDto;
import com.mk.pizzaexpress.domain.dto.receta.RecetaDto;
import com.mk.pizzaexpress.domain.entity.Ingrediente;
import com.mk.pizzaexpress.domain.entity.Pizza;
import com.mk.pizzaexpress.domain.entity.Receta;
import com.mk.pizzaexpress.domain.exceptions.IngredienteException;
import com.mk.pizzaexpress.domain.exceptions.PizzaException;
import com.mk.pizzaexpress.domain.exceptions.RecetaException;
import com.mk.pizzaexpress.persistence.repository.IngredienteRepository;
import com.mk.pizzaexpress.persistence.repository.PizzaRepository;
import com.mk.pizzaexpress.persistence.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecetaServiceImpl implements RecetaService {

    @Autowired
    RecetaRepository recetaRepository;

    @Autowired
    PizzaRepository pizzaRepository;

    @Autowired
    IngredienteRepository ingredienteRepository;

    @Autowired
    RecetaMapper recetaMapper;


    @Override
    public RecetaDto listarUnaRecetaPorId(int id) {
        Receta receta = recetaRepository.findById(id).orElseThrow(()-> new RecetaException("Receta no encontrada"));
        return recetaMapper.toDto(receta);
    }

    @Override
    public RecetaDto buscarRecetaPorPizza(int idPizza) {
        Pizza pizza = pizzaRepository.findById(idPizza).orElseThrow(()-> new PizzaException("Pizza no encontrada"));
        Receta receta = recetaRepository.findByPizza(pizza).orElseThrow(()-> new RecetaException("Receta de pizza no encontrda"));
        return recetaMapper.toDto(receta);
    }

    @Override
    public RecetaDto crearReceta(CrearRecetaDto crearRecetaDto , int pizzaId , List<Integer> ingredientesIds) {

        if(existeRecetaConNombre(crearRecetaDto.getNombre())){
            throw new RecetaException("Ya existe esta receta");
        }

        Pizza pizza = pizzaRepository.findById(pizzaId).orElseThrow(()-> new PizzaException("Pizza no encontrada"));

        Receta receta = recetaMapper.aRecetaDecrearRecetaDto(crearRecetaDto);
        receta.setNombre(crearRecetaDto.getNombre());
        receta.setPizza(pizza);
        receta.setIngredientes(obtenerIngredientesDeLaReceta(ingredientesIds));

        return recetaMapper.toDto(receta);
    }

    @Override
    public RecetaDto eliminarUnaReceta(int id) {

        Receta receta = recetaRepository.findById(id).orElseThrow(()-> new RecetaException("Receta no encontrada"));
        Optional<Pizza> pizza = pizzaRepository.findById(receta.getPizza().getId());

        if(pizza.isPresent()){
            throw new RecetaException("Debes eliminar primero la pizza");
        }

        recetaRepository.deleteById(id);
        return recetaMapper.toDto(receta);
    }

    @Override
    public boolean existeRecetaConNombre(String nombre) {
        return recetaRepository.existsByNombre(nombre);
    }

    @Override
    public List<Ingrediente> obtenerIngredientesDeLaReceta(List<Integer> ingredientesIds) {

        List<Ingrediente> ingredientes = new ArrayList<>();

        for (Integer ingredienteId : ingredientesIds){
            Optional<Ingrediente> ingredienteOptional = ingredienteRepository.findById(ingredienteId);

            if(ingredienteOptional.isPresent()){
                Ingrediente ingrediente = ingredienteOptional.get();
                ingredientes.add(ingrediente);
            }else {
                throw new IngredienteException("El ingrediente con id " + ingredienteId + " No se encuentra");
            }

        }

        return ingredientes;
    }
}
