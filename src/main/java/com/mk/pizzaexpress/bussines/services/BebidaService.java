package com.mk.pizzaexpress.bussines.services;


import com.mk.pizzaexpress.domain.dto.producto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.producto.bebida.CrearBebidaDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface BebidaService {

    List<BebidaDto> listarTodasLasBebidas();
    BebidaDto buscarBebidaPorNombre(String nombre);
    String almacenarImagen(byte[] imagen , String carpeta);
    BebidaDto crearUnaBebida(CrearBebidaDto crearBebidaDto);
    BebidaDto agregarImagenDeBebida(int id,MultipartFile imagen);
    BebidaDto editarBebida(int id,CrearBebidaDto crearBebidaDto);
    BebidaDto editarImagenDeBebida(int id,MultipartFile imagen);
    BebidaDto modificarPrecioDeBebida(int id , CrearBebidaDto crearBebidaDto);
    BebidaDto actualizarStockDeBebida(int id, CrearBebidaDto crearBebidaDto);
    BebidaDto eliminarUnaBebida(int id);
    boolean existeBebidaDeMarca(String marca);
}
