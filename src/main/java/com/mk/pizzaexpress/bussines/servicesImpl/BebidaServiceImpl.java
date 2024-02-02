package com.mk.pizzaexpress.bussines.servicesImpl;

import com.mk.pizzaexpress.bussines.mapper.implMapper.BebidaMapper;
import com.mk.pizzaexpress.bussines.services.BebidaService;
import com.mk.pizzaexpress.domain.dto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.bebida.CrearBebidaDto;
import com.mk.pizzaexpress.domain.entity.Bebida;
import com.mk.pizzaexpress.domain.exceptions.BebidaException;
import com.mk.pizzaexpress.persistence.repository.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BebidaServiceImpl implements BebidaService {

    @Autowired
    BebidaRepository bebidaRepository;

    @Autowired
    BebidaMapper bebidaMapper;

    @Override
    public List<BebidaDto> listarTodasLasBebidas() {
        return bebidaMapper.toDtoList(bebidaRepository.findAll());
    }

    @Override
    public BebidaDto buscarBebidaPorNombre(String nombre) {
        return bebidaMapper.toDto(bebidaRepository.findByNombre(nombre));
    }

    @Override
    public BebidaDto crearUnaBebida(CrearBebidaDto crearBebidaDto) {

        if (existeBebidaDeMarca(crearBebidaDto.getMarca())){
            throw new BebidaException("Ya existe esta marca de bebida");
        }

        Bebida bebida = bebidaMapper.aBebidaDeCrearBebidaDto(crearBebidaDto);
        bebida.setMarca(crearBebidaDto.getMarca());
        bebida.setTipoDeBebida(crearBebidaDto.getTipoDeBebida());
        bebida.setPrecio(crearBebidaDto.getPrecio());
        bebida.setMedida(crearBebidaDto.getMedida());
        bebida.setLitros(crearBebidaDto.getLitros());
        bebida.setStock(crearBebidaDto.getStock());
        //Imagenes


        return bebidaMapper.toDto(bebidaRepository.save(bebida));
    }

    @Override
    public BebidaDto modificarPrecioDeBebida(int id, float precio) {

        Bebida bebida = bebidaRepository.findById(id).orElseThrow(()-> new BebidaException("Bebida no encontrada"));
        bebida.setPrecio(precio);

        return bebidaMapper.toDto(bebidaRepository.save(bebida));
    }

    @Override
    public BebidaDto actualizarStockDeBebida(int id, int nuevoStock) {

        Bebida bebida = bebidaRepository.findById(id).orElseThrow(()-> new BebidaException("Bebida no encontrada"));
        int stock = bebida.getStock() + nuevoStock;
        bebida.setStock(stock);

        return bebidaMapper.toDto(bebidaRepository.save(bebida));
    }

    @Override
    public BebidaDto eliminarUnaBebida(int id) {

        Bebida bebida = bebidaRepository.findById(id).orElseThrow(()-> new BebidaException("Bebida no encontrada"));

        bebidaRepository.deleteById(id);

        return bebidaMapper.toDto(bebida);
    }

    @Override
    public boolean existeBebidaDeMarca(String marca) {
        return bebidaRepository.existsByMarca(marca);
    }


}
