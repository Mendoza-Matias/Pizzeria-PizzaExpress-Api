package com.mk.pizzaexpress.bussines.services.servicesImpl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mk.pizzaexpress.bussines.mapper.implMapper.PizzaMapper;
import com.mk.pizzaexpress.bussines.services.PizzaService;
import com.mk.pizzaexpress.domain.dto.producto.pizza.CrearPizzaDto;
import com.mk.pizzaexpress.domain.dto.producto.pizza.PizzaDto;
import com.mk.pizzaexpress.domain.entity.productos.Pizza;
import com.mk.pizzaexpress.domain.exceptions.NotFoundException;
import com.mk.pizzaexpress.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class PizzaServiceImpl implements PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private PizzaMapper pizzaMapper;
    @Override
    public List<PizzaDto> listarTodasLasPizzas() {
        return pizzaMapper.toDtoList(pizzaRepository.findAll());
    }
    @Override
    public PizzaDto obtenerUnaPizzaPorSuNombre(String nombre) {
        Pizza pizza = pizzaRepository.findByNombre(nombre).orElseThrow(()-> new NotFoundException("Pizza no encontrada"));
        return pizzaMapper.toDto(pizza);
    }
    @Override
    public PizzaDto crearUnaPizza(CrearPizzaDto crearPizza) {
            Pizza pizza = pizzaMapper.aPizzaDeCrearPizzaDto(crearPizza);
            pizza.setNombre(crearPizza.getNombre());
            pizza.setPrecio(crearPizza.getPrecio());
            pizza.setTipoDePizza(crearPizza.getTipoDePizza());
            pizza.setMedida(crearPizza.getMedida());
            return pizzaMapper.toDto(pizzaRepository.save(pizza));
    }
    @Override
    public PizzaDto modificarElPrecioDeUnaPizza(int pizzaId, int precio) {
        Pizza pizza = pizzaRepository.findById(pizzaId).orElseThrow(()-> new NotFoundException("Pizza no encontrada"));
        pizza.setPrecio(precio);
        return pizzaMapper.toDto(pizzaRepository.save(pizza));
    }
    @Override
    public PizzaDto eliminarUnaPizza(int pizzaId) throws IOException {
        Pizza pizza = pizzaRepository.findById(pizzaId).orElseThrow(()-> new NotFoundException("Pizza no encontrada"));
        cloudinary.uploader().destroy(obtenerPublicId(pizza.getUrlImagen()), ObjectUtils.emptyMap());
        pizzaRepository.deleteById(pizzaId);
        return pizzaMapper.toDto(pizza);
    }
    @Override
    public boolean existePizzaConNombre(String nombre) {
        return pizzaRepository.existsByNombre(nombre);
    }
    @Override
    public String obtenerPublicId(String urlImagen) {
        String [] publicId = urlImagen.split("/");
        return publicId[publicId.length - 1];
    }

}
