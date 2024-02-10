package com.mk.pizzaexpress.bussines.servicesImpl;

import com.mk.pizzaexpress.bussines.mapper.implMapper.RecetaMapper;
import com.mk.pizzaexpress.bussines.services.RecetaService;
import com.mk.pizzaexpress.domain.dto.receta.CrearRecetaDto;
import com.mk.pizzaexpress.domain.dto.receta.RecetaDto;
import com.mk.pizzaexpress.domain.dto.receta.recetaIngrediente.RecetaIngredienteDto;
import com.mk.pizzaexpress.domain.entity.Ingrediente;
import com.mk.pizzaexpress.domain.entity.Pizza;
import com.mk.pizzaexpress.domain.entity.Receta;
import com.mk.pizzaexpress.domain.entity.receta.RecetaIngrediente;
import com.mk.pizzaexpress.domain.exceptions.IngredienteException;
import com.mk.pizzaexpress.domain.exceptions.NotFoundException;
import com.mk.pizzaexpress.domain.exceptions.PizzaException;
import com.mk.pizzaexpress.domain.exceptions.RecetaException;
import com.mk.pizzaexpress.persistence.repository.IngredienteRepository;
import com.mk.pizzaexpress.persistence.repository.PizzaRepository;
import com.mk.pizzaexpress.persistence.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
        Receta receta = recetaRepository.findById(id).orElseThrow(()-> new NotFoundException("Receta no encontrada"));
        return recetaMapper.toDto(receta);
    }

    @Override
    public RecetaDto buscarRecetaPorPizza(int id) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(()-> new NotFoundException("Pizza no encontrada"));
        Receta receta = recetaRepository.findByPizza(pizza).orElseThrow(()-> new NotFoundException("Receta no encontrada"));
        return recetaMapper.toDto(receta);
    }

    @Override
    public RecetaDto crearReceta(int pizzaId, CrearRecetaDto crearRecetaDto) {
        if(existeRecetaConNombre(crearRecetaDto.getNombre())){
            throw new RecetaException("Ya existe una receta con este nombre");
        }
        Pizza pizza = pizzaRepository.findById(pizzaId).orElseThrow(()-> new NotFoundException("Pizza no encontrada"));
        Receta receta = recetaMapper.aRecetaDecrearRecetaDto(crearRecetaDto);
        receta.setNombre(crearRecetaDto.getNombre());
        receta.setPizza(pizza);
        return recetaMapper.toDto(recetaRepository.save(receta));
    }

    @Override
    public RecetaDto eliminarUnaReceta(int id) {
        Receta receta = recetaRepository.findById(id).orElseThrow(()-> new NotFoundException("Receta no encontrada"));
        recetaRepository.deleteById(id);
        return recetaMapper.toDto(receta);
    }

    @Override
    public boolean existeRecetaConNombre(String nombre) {
        return recetaRepository.existsByNombre(nombre);
    }

    @Override
    public RecetaDto agregarIngredientesALaReceta(int recetaId, List<RecetaIngredienteDto> ingredientesYCantidad) {
        List<RecetaIngrediente> recetaIngredientes = new ArrayList<>();
        Receta receta = recetaRepository.findById(recetaId).orElseThrow(()-> new NotFoundException("Receta no encontrada"));
        for(RecetaIngredienteDto ingredienteCantidad : ingredientesYCantidad){
            Ingrediente ingrediente = ingredienteRepository.findById(ingredienteCantidad.getIngredienteId()).orElseThrow(()-> new NotFoundException("Ingrediente no encontrado"));
            RecetaIngrediente recetaIngrediente = RecetaIngrediente
                    .builder()
                    .ingrediente(ingrediente)
                    .cantidad(ingredienteCantidad.getCantidad())
                    .build();
            recetaIngredientes.add(recetaIngrediente);
        }
        receta.setRecetaIngredientes(recetaIngredientes);

        return recetaMapper.toDto(recetaRepository.save(receta));
    }
}
