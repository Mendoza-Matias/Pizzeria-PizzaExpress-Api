package com.mk.pizzaexpress.bussines.services.servicesImpl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mk.pizzaexpress.bussines.mapper.implMapper.BebidaMapper;
import com.mk.pizzaexpress.bussines.services.BebidaService;
import com.mk.pizzaexpress.domain.dto.producto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.producto.bebida.CrearBebidaDto;
import com.mk.pizzaexpress.domain.entity.productos.Bebida;
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
    public BebidaDto obtenerBebidaPorMarca(String marca) {
        Bebida bebida = bebidaRepository.findByMarca(marca).orElseThrow(()-> new NotFoundException("No hay una bebida con ese nombre"));
        return bebidaMapper.toDto(bebida);
    }
    @Override
    public BebidaDto crearUnaBebida(CrearBebidaDto crearBebida) {

        if (existeBebidaDeMarca(crearBebida.getMarca())){
            throw new BebidaException("Ya existe esta marca de bebida");
        }
        Bebida bebida = bebidaMapper.aBebidaDeCrearBebidaDto(crearBebida);
        bebida.setMarca(crearBebida.getMarca());
        bebida.setTipoDeBebida(crearBebida.getTipoDeBebida());
        bebida.setPrecio(crearBebida.getPrecio());
        bebida.setMedida(crearBebida.getMedida());
        bebida.setLitros(crearBebida.getLitros());

        return bebidaMapper.toDto(bebidaRepository.save(bebida));
    }
    @Override
    public BebidaDto modificarPrecioDeBebida(int bebidaId, int precio) {
        Bebida bebida = bebidaRepository.findById(bebidaId).orElseThrow(()-> new NotFoundException("Bebida no encontrada"));
        bebida.setPrecio(precio);
        return bebidaMapper.toDto(bebidaRepository.save(bebida));
    }
    @Override
    public BebidaDto eliminarUnaBebida(int bebidaId) throws IOException {
        Bebida bebida = bebidaRepository.findById(bebidaId).orElseThrow(()-> new NotFoundException("Bebida no encontrada"));
        cloudinary.uploader().destroy(obtenerPublicIdDeImagen(bebida.getUrlImagen()), ObjectUtils.emptyMap());
        bebidaRepository.deleteById(bebidaId);
        return bebidaMapper.toDto(bebida);
    }
    @Override
    public boolean existeBebidaDeMarca(String marca) {
        return bebidaRepository.existsByMarca(marca);
    }
    @Override
    public String obtenerPublicIdDeImagen(String urlImagen) {
        String[] publicId = urlImagen.split("/");
        return publicId[publicId.length - 1];
    }

}
