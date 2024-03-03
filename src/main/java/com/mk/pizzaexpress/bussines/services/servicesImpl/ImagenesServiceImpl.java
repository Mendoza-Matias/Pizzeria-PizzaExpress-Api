package com.mk.pizzaexpress.bussines.services.servicesImpl;

import com.cloudinary.Cloudinary;
import com.mk.pizzaexpress.bussines.mapper.implMapper.BebidaMapper;
import com.mk.pizzaexpress.bussines.mapper.implMapper.PizzaMapper;
import com.mk.pizzaexpress.bussines.services.ImagenesServices;
import com.mk.pizzaexpress.domain.dto.producto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.producto.pizza.PizzaDto;
import com.mk.pizzaexpress.domain.entity.pedidos.productos.Bebida;
import com.mk.pizzaexpress.domain.entity.pedidos.productos.Pizza;
import com.mk.pizzaexpress.domain.exceptions.ImagenException;
import com.mk.pizzaexpress.domain.exceptions.NotFoundException;
import com.mk.pizzaexpress.persistence.repository.BebidaRepository;
import com.mk.pizzaexpress.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImagenesServiceImpl implements ImagenesServices{

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private BebidaRepository bebidaRepository;
    @Autowired
    private PizzaMapper pizzaMapper;
    @Autowired
    private BebidaMapper bebidaMapper;

    @Override
    public String almacenarImagen(byte[] imagen, String carpeta) {
        try {
            HashMap<Object,Object> almacenamiento = new HashMap<>();
            almacenamiento.put("carpeta",carpeta);
            Map subirImagen = cloudinary.uploader().upload(imagen,almacenamiento);
            String id = (String) subirImagen.get("public_id");
            return cloudinary.url().secure(true).generate(id);

        } catch (IOException e) {
            throw new ImagenException("No fue posible convertir almacenar la imagen");
        }
    }

    @Override
    public PizzaDto agregarImagenDePizza(int id, MultipartFile imagen) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(()-> new NotFoundException("Pizza no encontrada"));

        try{
            if (imagen.isEmpty()){
                throw new NotFoundException("No se encontro ninguna imagen");
            }
            byte [] bytes = imagen.getBytes();
            String url = almacenarImagen(bytes,"pizzas");
            pizza.setUrlImagen(url);
            return pizzaMapper.toDto(pizzaRepository.save(pizza));

        }catch(IOException e) {
            throw new ImagenException("Error al leer el contenido de la imagen");
        }
    }

    @Override
    public BebidaDto agregarImagenDeBebida(int id, MultipartFile imagen) {
        Bebida bebida = bebidaRepository.findById(id).orElseThrow(()-> new NotFoundException("Bebida no encontrada"));

        try{
            if (imagen.isEmpty()){
                throw new NotFoundException("No se encontro ninguna imagen");
            }
            byte [] bytes = imagen.getBytes();
            String url = almacenarImagen(bytes,"bebidas");
            bebida.setUrlImagen(url);
            return bebidaMapper.toDto(bebidaRepository.save(bebida));

        }catch(IOException e) {
            throw new ImagenException("Error al leer el contenido de la imagen");
        }
    }

}
