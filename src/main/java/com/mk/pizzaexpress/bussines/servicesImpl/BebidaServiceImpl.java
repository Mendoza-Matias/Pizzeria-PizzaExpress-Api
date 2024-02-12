package com.mk.pizzaexpress.bussines.servicesImpl;

import com.cloudinary.Cloudinary;
import com.mk.pizzaexpress.bussines.mapper.implMapper.BebidaMapper;
import com.mk.pizzaexpress.bussines.services.BebidaService;
import com.mk.pizzaexpress.domain.dto.producto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.producto.bebida.CrearBebidaDto;
import com.mk.pizzaexpress.domain.entity.Bebida;
import com.mk.pizzaexpress.domain.exceptions.BebidaException;
import com.mk.pizzaexpress.domain.exceptions.ImagenException;
import com.mk.pizzaexpress.domain.exceptions.NotFoundException;
import com.mk.pizzaexpress.persistence.repository.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BebidaServiceImpl implements BebidaService {

    @Autowired
    BebidaRepository bebidaRepository;

    @Autowired
    BebidaMapper bebidaMapper;

    @Autowired
    Cloudinary cloudinary;

    @Override
    public List<BebidaDto> listarTodasLasBebidas() {
        return bebidaMapper.toDtoList(bebidaRepository.findAll());
    }

    @Override
    public BebidaDto buscarBebidaPorNombre(String nombre) {
        Bebida bebida = bebidaRepository.findByNombre(nombre).orElseThrow(()-> new NotFoundException("No hay una bebida con ese nombre"));
        return bebidaMapper.toDto(bebida);
    }

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
    public BebidaDto crearUnaBebida(CrearBebidaDto crearBebidaDto) {

        if (existeBebidaDeMarca(crearBebidaDto.getMarca())){
            throw new BebidaException("Ya existe esta marca de bebida");
        }

        Bebida bebida = bebidaMapper.aBebidaDeCrearBebidaDto(crearBebidaDto);
        bebida.setMarca(crearBebidaDto.getMarca());
        bebida.setTipoDeBebida(crearBebidaDto.getTipoDeBebida());
        bebida.setStock(crearBebidaDto.getStock());
        bebida.setPrecio(crearBebidaDto.getPrecio());
        bebida.setMedida(crearBebidaDto.getMedida());
        bebida.setLitros(crearBebidaDto.getLitros());
        //Imagenes


        return bebidaMapper.toDto(bebidaRepository.save(bebida));
    }

    @Override
    public BebidaDto agregarImagenDeBebida(int id , MultipartFile imagen) {
        Bebida bebida = bebidaRepository.findById(id).orElseThrow(()-> new NotFoundException("Bebida no encontrada"));
        try{
            if (imagen.isEmpty()){
                throw new NotFoundException("No se encontro ninguna imagen");
            }
            byte [] bytes = imagen.getBytes();
            String url = almacenarImagen(bytes,"bebidas");
            bebida.setUrlImagen(url);

        }catch(IOException e) {
            throw new ImagenException("Error al leer el contenido de la imagen");
        }
        return bebidaMapper.toDto(bebidaRepository.save(bebida));
    }

    @Override
    public BebidaDto editarBebida(int id, CrearBebidaDto crearBebidaDto) {
        return null;
    }

    @Override
    public BebidaDto editarImagenDeBebida(int id, MultipartFile imagen) {
        Bebida bebida = bebidaRepository.findById(id).orElseThrow(()-> new NotFoundException("Bebida no encontrada"));

        try{
            if (imagen.isEmpty()){
                throw new NotFoundException("No se encontro ninguna imagen");
            }
            byte [] bytes = imagen.getBytes();
            String url = almacenarImagen(bytes,"bebidas");
            bebida.setUrlImagen(url);

        }catch(IOException e) {
            throw new ImagenException("Error al leer el contenido de la imagen");
        }
        return bebidaMapper.toDto(bebidaRepository.save(bebida));
    }

    @Override
    public BebidaDto modificarPrecioDeBebida(int id, CrearBebidaDto crearBebidaDto) {
        Bebida bebida = bebidaRepository.findById(id).orElseThrow(()-> new NotFoundException("Bebida no encontrada"));
        bebida.setPrecio(crearBebidaDto.getPrecio());
        return bebidaMapper.toDto(bebidaRepository.save(bebida));
    }

    @Override
    public BebidaDto actualizarStockDeBebida(int id, CrearBebidaDto crearBebidaDto) {
        Bebida bebida = bebidaRepository.findById(id).orElseThrow(()-> new NotFoundException("Bebida no encontrada"));
        bebida.setStock(bebida.getStock() + crearBebidaDto.getStock());
        return bebidaMapper.toDto(bebidaRepository.save(bebida));
    }

    @Override
    public BebidaDto eliminarUnaBebida(int id) {
        Bebida bebida = bebidaRepository.findById(id).orElseThrow(()-> new NotFoundException("Bebida no encontrada"));
        bebidaRepository.deleteById(id);
        return bebidaMapper.toDto(bebida);
    }

    @Override
    public boolean existeBebidaDeMarca(String marca) {
        return bebidaRepository.existsByMarca(marca);
    }


}
