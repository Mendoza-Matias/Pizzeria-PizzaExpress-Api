package com.mk.pizzaexpress.bussines.services.servicesImpl;

import com.mk.pizzaexpress.bussines.mapper.implMapper.PedidoMapper;
import com.mk.pizzaexpress.bussines.services.PedidoService;
import com.mk.pizzaexpress.domain.dto.pedido.CrearPedidoBebidaDto;
import com.mk.pizzaexpress.domain.dto.pedido.CrearPedidoPizzaDto;
import com.mk.pizzaexpress.domain.dto.pedido.PedidoDto;
import com.mk.pizzaexpress.domain.entity.productos.Bebida;
import com.mk.pizzaexpress.domain.entity.pedidos.Pedido;
import com.mk.pizzaexpress.domain.entity.productos.Pizza;
import com.mk.pizzaexpress.domain.entity.enums.EstadoPedido;
import com.mk.pizzaexpress.domain.entity.pedidos.PedidoBebida;
import com.mk.pizzaexpress.domain.entity.pedidos.PedidoPizza;
import com.mk.pizzaexpress.domain.entity.usuarios.Cliente;
import com.mk.pizzaexpress.domain.entity.usuarios.Usuario;
import com.mk.pizzaexpress.domain.exceptions.*;
import com.mk.pizzaexpress.persistence.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private BebidaRepository bebidaRepository;

    @Autowired
    private PedidoMapper pedidoMapper;



    @Override
    public List<PedidoDto> listarTodosLosPedidos() {
        return pedidoMapper.toDtoList(pedidoRepository.findAll());
    }

    @Override
    public PedidoDto obtenerPedidoPorNumeroDePedido(int numeroDePedido) {
        Pedido pedido = pedidoRepository.findByNumeroDePedido(numeroDePedido).orElseThrow(()-> new NotFoundException("Pedido con numero de pedido " + numeroDePedido + "no se ha encontrado"));
        return pedidoMapper.toDto(pedido);
    }

    @Override
    public PedidoDto crearUnPedido(int clienteId , List<CrearPedidoPizzaDto> crearPedidoPizza , List<CrearPedidoBebidaDto> crearPedidoBebida) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(()-> new NotFoundException("Cliente no encontrado"));
        Pedido pedido = Pedido.builder().build();
        pedido.setEstadoPedido(EstadoPedido.NOENTREGADO);
        pedido.setCliente(cliente);
        pedido.setPizzas(obtenerPizzasPedidas(crearPedidoPizza));
        pedido.setBebidas(obtenerBebidasPedidas(crearPedidoBebida));
        return pedidoMapper.toDto(pedidoRepository.save(pedido));
    }

    @Override
    public PedidoDto editarUnPedido(int numeroDePedido, List<CrearPedidoPizzaDto> crearPedidoPizza , List<CrearPedidoBebidaDto> crearPedidoBebida) {

        Pedido pedido = pedidoRepository.findByNumeroDePedido(numeroDePedido).orElseThrow(()-> new NotFoundException("Pedido con numero de pedido " + numeroDePedido + " no se ha encontrado"));
        pedido.setEstadoPedido(EstadoPedido.NOENTREGADO);
        pedido.setPizzas(obtenerPizzasPedidas(crearPedidoPizza));
        pedido.setBebidas(obtenerBebidasPedidas(crearPedidoBebida));
        return pedidoMapper.toDto(pedidoRepository.save(pedido));
    }

    @Override
    public PedidoDto modificarEstadoDePedido(int numeroDePedido) {
        Pedido pedido = pedidoRepository.findByNumeroDePedido(numeroDePedido).orElseThrow(()-> new NotFoundException("Pedido con numero de pedido " + numeroDePedido+ " no se ha encontrado"));
        pedido.setEstadoPedido(EstadoPedido.ENTREGADO);
        return pedidoMapper.toDto(pedidoRepository.save(pedido));
    }

    @Override
    public PedidoDto eliminarUnPedidoPorNumeroDePedido(int numeroDePedido) {
        Pedido pedido = pedidoRepository.findByNumeroDePedido(numeroDePedido).orElseThrow(()-> new NotFoundException("Pedido con numero de pedido " + numeroDePedido + " no se ha encontrado"));
        pedidoRepository.deleteById(numeroDePedido);
        return pedidoMapper.toDto(pedido);
    }

    @Override
    public List<PedidoPizza> obtenerPizzasPedidas(List<CrearPedidoPizzaDto> crearPedidoPizza) {
        List<PedidoPizza> pizzasPedidas = new ArrayList<>();
        for(CrearPedidoPizzaDto pizzaPedidaYCantidad : crearPedidoPizza){
            Pizza pizza = pizzaRepository.findById(pizzaPedidaYCantidad.getPizzaId()).orElseThrow(()-> new NotFoundException("Pizza no encontrada"));
            PedidoPizza pedidoPizza = PedidoPizza.builder()
                    .pizza(pizza)
                    .cantidad(pizzaPedidaYCantidad.getCantidad())
                    .build();

            pizzasPedidas.add(pedidoPizza);
        }

        return pizzasPedidas;
    }

    @Override
    public List<PedidoBebida> obtenerBebidasPedidas(List<CrearPedidoBebidaDto> crearPedidoBebida) {
        List<PedidoBebida> bebidasPedidas = new ArrayList<>();
        for(CrearPedidoBebidaDto bebidaPedidaYCantidad : crearPedidoBebida){
            Bebida bebida = bebidaRepository.findById(bebidaPedidaYCantidad.getBebidaId()).orElseThrow(()-> new NotFoundException("Bebida no encontrada"));

            PedidoBebida pedidoBebida = PedidoBebida.builder()
                    .bebida(bebida)
                    .cantidad(bebidaPedidaYCantidad.getCantidad())
                    .build();
            bebidasPedidas.add(pedidoBebida);
        }
        return bebidasPedidas;
    }
}
