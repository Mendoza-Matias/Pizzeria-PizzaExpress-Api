package com.mk.pizzaexpress.bussines.servicesImpl;

import com.mk.pizzaexpress.bussines.mapper.implMapper.PizzaMapper;
import com.mk.pizzaexpress.bussines.services.PizzaService;
import com.mk.pizzaexpress.domain.dto.pizza.CrearPizzaDto;
import com.mk.pizzaexpress.domain.dto.pizza.PizzaDto;
import com.mk.pizzaexpress.domain.entity.Pizza;
import com.mk.pizzaexpress.domain.entity.Receta;
import com.mk.pizzaexpress.domain.exceptions.PizzaException;
import com.mk.pizzaexpress.domain.exceptions.RecetaException;
import com.mk.pizzaexpress.persistence.repository.PizzaRepository;
import com.mk.pizzaexpress.persistence.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PizzaServiceImpl implements PizzaService {
    @Autowired
    PizzaRepository pizzaRepository;

    @Autowired
    RecetaRepository recetaRepository;

    @Autowired
    PizzaMapper pizzaMapper;

    @Override
    public List<PizzaDto> listarTodasLasPizzas() {
        return pizzaMapper.toDtoList(pizzaRepository.findAll());
    }

    @Override
    public PizzaDto buscarPizzaPorNombre(String nombre) {
        return pizzaMapper.toDto(pizzaRepository.findByNombre(nombre));
    }

    @Override
    public PizzaDto crearUnaPizza(CrearPizzaDto crearPizzaDto , int idReceta) {

        if(existePizzaConNombre(crearPizzaDto.getNombre())){
            throw new PizzaException("Ya existe esta pizza");
        }

        Receta receta = recetaRepository.findById(idReceta).orElseThrow(()-> new RecetaException("Receta no encontrada"));

        Pizza pizza = pizzaMapper.aPizzaDeCrearPizzaDto(crearPizzaDto);
        pizza.setNombre(crearPizzaDto.getNombre());
        pizza.setTipoDePizza(crearPizzaDto.getTipoDePizza());
        pizza.setPrecio(crearPizzaDto.getPrecio());
        pizza.setReceta(receta);
        pizza.setMedida(crearPizzaDto.getMedida());
        //pizza.setUrlImagen(crearPizzaDto.getImagen());


        return pizzaMapper.toDto(pizzaRepository.save(pizza));
    }

    @Override
    public PizzaDto modificarPrecioDePizza(int id, float precio) {

        Pizza pizza = pizzaRepository.findById(id).orElseThrow(()-> new PizzaException("Pizza no encontrada"));
        pizza.setPrecio(precio);

        return pizzaMapper.toDto(pizzaRepository.save(pizza));
    }

    @Override
    public PizzaDto eliminarUnaPizza(int id) {

        Pizza pizza = pizzaRepository.findById(id).orElseThrow(()-> new PizzaException("Pizza no encontrada"));

        pizzaRepository.deleteById(id);

        return pizzaMapper.toDto(pizza);
    }

    @Override
    public boolean existePizzaConNombre(String nombre) {
        return pizzaRepository.existsByNombre(nombre);
    }
}
