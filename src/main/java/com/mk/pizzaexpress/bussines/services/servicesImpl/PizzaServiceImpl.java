package com.mk.pizzaexpress.bussines.services.servicesImpl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mk.pizzaexpress.bussines.mapper.implMapper.PizzaMapper;
import com.mk.pizzaexpress.bussines.services.PizzaService;
import com.mk.pizzaexpress.domain.dto.producto.pizza.CrearPizzaDto;
import com.mk.pizzaexpress.domain.dto.producto.pizza.PizzaDto;
import com.mk.pizzaexpress.domain.entity.pedidos.productos.Pizza;
import com.mk.pizzaexpress.domain.entity.recetas.Receta;
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
    private RecetaRepository recetaRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private PizzaMapper pizzaMapper;

    @Override
    public List<PizzaDto> listarTodasLasPizzas() {
        return pizzaMapper.toDtoList(pizzaRepository.findAll());
    }
    @Override
    public PizzaDto buscarPizzaPorNombre(String nombre) {
        return pizzaMapper.toDto(pizzaRepository.findByNombre(nombre));
    }
    @Override
    public PizzaDto crearUnaPizza(CrearPizzaDto crearPizzaDto) {
            Pizza pizza = pizzaMapper.aPizzaDeCrearPizzaDto(crearPizzaDto);
            pizza.setNombre(crearPizzaDto.getNombre());
            pizza.setPrecio(crearPizzaDto.getPrecio());
            pizza.setTipoDePizza(crearPizzaDto.getTipoDePizza());
            pizza.setMedida(crearPizzaDto.getMedida());
            return pizzaMapper.toDto(pizzaRepository.save(pizza));
    }

    @Override
    public PizzaDto agreagarReceta(int pizzaId, int recetaId) {
        Pizza pizza = pizzaRepository.findById(pizzaId).orElseThrow(()-> new NotFoundException("Pizza no encontrada"));
        Receta receta = recetaRepository.findById(recetaId).orElseThrow(()-> new NotFoundException("Receta no encontrada"));
        pizza.setReceta(receta);
        return pizzaMapper.toDto(pizzaRepository.save(pizza));
    }
    @Override
    public PizzaDto modificarPrecioDePizza(int id, int precio) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(()-> new NotFoundException("Pizza no encontrada"));
        pizza.setPrecio(precio);
        return pizzaMapper.toDto(pizzaRepository.save(pizza));
    }
    @Override
    public PizzaDto eliminarUnaPizza(int id) throws IOException {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(()-> new NotFoundException("Pizza no encontrada"));
        cloudinary.uploader().destroy(obtenerPublicId(pizza.getUrlImagen()), ObjectUtils.emptyMap());
        pizzaRepository.deleteById(id);
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
