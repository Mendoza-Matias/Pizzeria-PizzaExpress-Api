package com.mk.pizzaexpress.bussines.servicesImpl;

import com.cloudinary.Cloudinary;
import com.mk.pizzaexpress.bussines.mapper.implMapper.PizzaMapper;
import com.mk.pizzaexpress.bussines.services.PizzaService;
import com.mk.pizzaexpress.domain.dto.producto.pizza.CrearPizzaDto;
import com.mk.pizzaexpress.domain.dto.producto.pizza.PizzaDto;
import com.mk.pizzaexpress.domain.entity.Pizza;
import com.mk.pizzaexpress.domain.entity.Receta;
import com.mk.pizzaexpress.domain.entity.enums.Medida;
import com.mk.pizzaexpress.domain.exceptions.ImagenException;
import com.mk.pizzaexpress.domain.exceptions.NotFoundException;
import com.mk.pizzaexpress.domain.exceptions.PizzaException;
import com.mk.pizzaexpress.domain.exceptions.RecetaException;
import com.mk.pizzaexpress.persistence.repository.PizzaRepository;
import com.mk.pizzaexpress.persistence.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PizzaServiceImpl implements PizzaService {
    @Autowired
    PizzaRepository pizzaRepository;

    @Autowired
    RecetaRepository recetaRepository;

    @Autowired
    Cloudinary cloudinary;

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
    public PizzaDto listarUnaPizza(int id) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(()-> new PizzaException("Pizza no encontrada"));
        return pizzaMapper.toDto(pizza);
    }

    @Override
    public String almacenarImagen(byte[] imagen, String carpeta) {

        try {
            HashMap <Object,Object> almacenamiento = new HashMap<>();
            almacenamiento.put("carpeta",carpeta);
            Map subirImagen = cloudinary.uploader().upload(imagen,almacenamiento);
            String id = (String) subirImagen.get("public_id");
            return cloudinary.url().secure(true).generate(id);

        } catch (IOException e) {
            throw new ImagenException("No fue posible convertir almacenar la imagen");
        }
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
    public PizzaDto agregarImagenDePizza(int id,MultipartFile imagen) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(()-> new NotFoundException("Pizza no encontrada"));

        try{
            if (imagen.isEmpty()){
                throw new NotFoundException("No se encontro ninguna imagen");
            }
            byte [] bytes = imagen.getBytes();
            String url = almacenarImagen(bytes,"imagenes");

            pizza.setUrlImagen(url);

        }catch(IOException e) {
            throw new ImagenException("Error al leer el contenido de la imagen");
        }
        return pizzaMapper.toDto(pizzaRepository.save(pizza));
    }

    @Override
    public PizzaDto editarUnaPizza(int id, CrearPizzaDto crearPizzaDto) {

        Pizza pizza = pizzaRepository.findById(id).orElseThrow(()-> new NotFoundException("Pizza no encontrada"));

        pizza.setNombre(crearPizzaDto.getNombre());
        pizza.setPrecio(crearPizzaDto.getPrecio());
        pizza.setMedida(crearPizzaDto.getMedida());
        pizza.setTipoDePizza(crearPizzaDto.getTipoDePizza());

        return pizzaMapper.toDto(pizzaRepository.save(pizza));
    }

    @Override
    public PizzaDto editarImagenDepizza(int id, MultipartFile imagen) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(()-> new NotFoundException("Pizza no encontrada"));

        try{
            if (imagen.isEmpty()){
                throw new ImagenException("No se encontro ninguna imagen");
            }

            byte [] bytes = imagen.getBytes();
            String url = almacenarImagen(bytes,"imagenes");

            pizza.setUrlImagen(url);

            return pizzaMapper.toDto(pizzaRepository.save(pizza));

        }catch(IOException e) {
            throw new ImagenException("Error al leer el contenido de la imagen");
        }
    }

    @Override
    public PizzaDto agreagarReceta(int pizzaId, int recetaId) {
        Pizza pizza = pizzaRepository.findById(pizzaId).orElseThrow(()-> new NotFoundException("Pizza no encontrada"));
        Receta receta = recetaRepository.findById(recetaId).orElseThrow(()-> new NotFoundException("Receta no encontrada"));
        pizza.setReceta(receta);
        return pizzaMapper.toDto(pizzaRepository.save(pizza));
    }

    @Override
    public PizzaDto modificarPrecioDePizza(int id, CrearPizzaDto crearPizzaDto) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(()-> new NotFoundException("Pizza no encontrada"));
        pizza.setPrecio(crearPizzaDto.getPrecio());
        return pizzaMapper.toDto(pizzaRepository.save(pizza));
    }

    @Override
    public PizzaDto eliminarUnaPizza(int id) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(()-> new NotFoundException("Pizza no encontrada"));
        pizzaRepository.deleteById(id);
        return pizzaMapper.toDto(pizza);
    }

    @Override
    public boolean existePizzaConNombre(String nombre) {
        return pizzaRepository.existsByNombre(nombre);
    }

    @Override
    public boolean esPizzaDeMedida(Medida medida) {
        return !(medida == Medida.CHICO || medida == Medida.MEDIANO || medida == Medida.GRANDE );
    }
}
