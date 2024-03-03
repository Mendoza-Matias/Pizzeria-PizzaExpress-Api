package com.mk.pizzaexpress.bussines.services.servicesImpl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mk.pizzaexpress.bussines.mapper.implMapper.BebidaMapper;
import com.mk.pizzaexpress.bussines.services.BebidaService;
import com.mk.pizzaexpress.domain.dto.producto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.producto.bebida.CrearBebidaDto;
import com.mk.pizzaexpress.domain.entity.pedidos.productos.Bebida;
import com.mk.pizzaexpress.domain.exceptions.BebidaException;
import com.mk.pizzaexpress.domain.exceptions.NotFoundException;
import com.mk.pizzaexpress.persistence.repository.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class BebidaServiceImpl implements BebidaService {
    @Autowired
    private BebidaRepository bebidaRepository;
    @Autowired
    private BebidaMapper bebidaMapper;
    @Autowired
    private Cloudinary cloudinary;
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
    public BebidaDto modificarPrecioDeBebida(int id, int precio) {
        Bebida bebida = bebidaRepository.findById(id).orElseThrow(()-> new NotFoundException("Bebida no encontrada"));
        bebida.setPrecio(precio);
        return bebidaMapper.toDto(bebidaRepository.save(bebida));
    }
    @Override
    public BebidaDto actualizarStockDeBebida(int id, int stock) {
        Bebida bebida = bebidaRepository.findById(id).orElseThrow(()-> new NotFoundException("Bebida no encontrada"));
        bebida.setStock(bebida.getStock() + stock);
        return bebidaMapper.toDto(bebidaRepository.save(bebida));
    }
    @Override
    public BebidaDto eliminarUnaBebida(int id) throws IOException {
        Bebida bebida = bebidaRepository.findById(id).orElseThrow(()-> new NotFoundException("Bebida no encontrada"));
        cloudinary.uploader().destroy(obtenerPublicId(bebida.getUrlImagen()), ObjectUtils.emptyMap());
        bebidaRepository.deleteById(id);
        return bebidaMapper.toDto(bebida);
    }
    @Override
    public boolean existeBebidaDeMarca(String marca) {
        return bebidaRepository.existsByMarca(marca);
    }
    @Override
    public String obtenerPublicId(String urlImagen) {
        String[] publicId = urlImagen.split("/");
        return publicId[publicId.length - 1];
    }

}
