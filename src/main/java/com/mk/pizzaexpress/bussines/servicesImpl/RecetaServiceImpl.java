package com.mk.pizzaexpress.bussines.servicesImpl;

import com.mk.pizzaexpress.bussines.mapper.implMapper.RecetaMapper;
import com.mk.pizzaexpress.bussines.services.RecetaService;
import com.mk.pizzaexpress.domain.dto.receta.CrearRecetaDto;
import com.mk.pizzaexpress.domain.dto.receta.RecetaDto;
import com.mk.pizzaexpress.domain.entity.Pizza;
import com.mk.pizzaexpress.domain.entity.Receta;
import com.mk.pizzaexpress.domain.exceptions.PizzaException;
import com.mk.pizzaexpress.domain.exceptions.RecetaException;
import com.mk.pizzaexpress.persistence.repository.IngredienteRepository;
import com.mk.pizzaexpress.persistence.repository.PizzaRepository;
import com.mk.pizzaexpress.persistence.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public RecetaDto crearReceta(CrearRecetaDto crearRecetaDto , int idPizza , List<Integer> ingredientesIds) {

        if(existeRecetaConNombre(crearRecetaDto.getNombre())){
            throw new RecetaException("Ya existe esta receta");
        }

        Pizza pizza = pizzaRepository.findById(idPizza).orElseThrow(()-> new PizzaException("Pizza no encontrada"));

        Receta receta = recetaMapper.aRecetaDecrearRecetaDto(crearRecetaDto);
        receta.setNombre(crearRecetaDto.getNombre());
        receta.setPizza(pizza);
        //receta.setIngredientes();


        return null;
    }

    @Override
    public RecetaDto editarReceta(int id, CrearRecetaDto crearRecetaDto,int idPizza,List<Integer> ingredienteIds) {
        return null;
    }

    @Override
    public RecetaDto eliminarUnaReceta(int id) {

        Receta receta = recetaRepository.findById(id).orElseThrow(()-> new RecetaException("Receta no encontrada"));
        recetaRepository.deleteById(id);
        return recetaMapper.toDto(receta);
    }

    @Override
    public boolean existeRecetaConNombre(String nombre) {
        return false;
    }
}
