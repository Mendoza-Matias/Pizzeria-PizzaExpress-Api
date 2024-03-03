package com.mk.pizzaexpress.bussines.services.servicesImpl;

import com.mk.pizzaexpress.bussines.mapper.implMapper.PedidoMapper;
import com.mk.pizzaexpress.bussines.services.PedidoService;
import com.mk.pizzaexpress.domain.dto.pedido.PedidoDto;
import com.mk.pizzaexpress.domain.entity.pedidos.Pedido;
import com.mk.pizzaexpress.domain.entity.enums.EstadoPedido;
import com.mk.pizzaexpress.domain.entity.pedidos.productos.Bebida;
import com.mk.pizzaexpress.domain.entity.pedidos.productos.Pizza;
import com.mk.pizzaexpress.domain.entity.usuarios.Cliente;
import com.mk.pizzaexpress.domain.exceptions.*;
import com.mk.pizzaexpress.persistence.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public PedidoDto obtenerPedidoPorNumeroDePedido(int id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(()-> new NotFoundException("Pedido con id " + id + "no se ha encontrado"));
        return pedidoMapper.toDto(pedido);
    }

    @Override
    public PedidoDto CrearPedidoDePizza(int clienteId, int pizzaId, int cantidad) {

        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(()-> new NotFoundException("Cliente no encontrado"));
        Pizza pizza = pizzaRepository.findById(pizzaId).orElseThrow(()-> new NotFoundException("Pizza no encontrada"));

        Pedido pedido = Pedido.builder()
                .estadoPedido(EstadoPedido.NOENTREGADO)
                .pizza(pizza)
                .cantidad(cantidad)
                .build();

        return pedidoMapper.toDto(pedidoRepository.save(pedido));
    }

    @Override
    public PedidoDto CrearPedidoDeBebida(int clienteId, int bebidaId, int cantidad) {

        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(()-> new NotFoundException("Cliente no encontrado"));
        Bebida bebida = bebidaRepository.findById(bebidaId).orElseThrow(()-> new NotFoundException("Bebida no encontrada"));

        Pedido pedido = Pedido.builder()
                .estadoPedido(EstadoPedido.NOENTREGADO)
                .bebida(bebida)
                .cantidad(cantidad)
                .build();

        return pedidoMapper.toDto(pedidoRepository.save(pedido));
    }

    @Override
    public PedidoDto modificarPedidoDePizza(int id, int pizzaId, int cantidad) {

        Pedido pedido = pedidoRepository.findById(id).orElseThrow(()-> new NotFoundException("Pedido no encontrado"));
        Pizza pizza = pizzaRepository.findById(pizzaId).orElseThrow(()-> new NotFoundException("Pizza no encontrada"));

        pedido.setPizza(pizza);
        pedido.setCantidad(cantidad);

        return pedidoMapper.toDto(pedidoRepository.save(pedido));
    }

    @Override
    public PedidoDto modificarPedidoDeBebida(int id, int bebidaId, int cantidad) {

        Pedido pedido = pedidoRepository.findById(id).orElseThrow(()-> new NotFoundException("Pedido no encontrado"));
        Bebida bebida = bebidaRepository.findById(bebidaId).orElseThrow(()-> new NotFoundException("Bebida no encontrada"));

        pedido.setBebida(bebida);
        pedido.setCantidad(cantidad);

        return pedidoMapper.toDto(pedidoRepository.save(pedido));
    }


    @Override
    public PedidoDto modificarEstadoDePedido(int id) {

        Pedido pedido = pedidoRepository.findById(id).orElseThrow(()-> new NotFoundException("Pedido no encontrado"));

        pedido.setEstadoPedido(EstadoPedido.ENTREGADO);

        return pedidoMapper.toDto(pedidoRepository.save(pedido));
    }

    @Override
    public PedidoDto eliminarUnPedido(int id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(()-> new NotFoundException("Pedido no encontrado"));
        pedidoRepository.deleteById(id);
        return pedidoMapper.toDto(pedido);
    }


}
