package com.mk.pizzaexpress.bussines.servicesImpl;

import com.mk.pizzaexpress.bussines.mapper.implMapper.PedidoMapper;
import com.mk.pizzaexpress.bussines.services.PedidoService;
import com.mk.pizzaexpress.domain.dto.bebida.BebidaDto;
import com.mk.pizzaexpress.domain.dto.pedido.CrearPedidoDto;
import com.mk.pizzaexpress.domain.dto.pedido.PedidoDto;
import com.mk.pizzaexpress.domain.dto.pizza.PizzaDto;
import com.mk.pizzaexpress.domain.entity.Pedido;
import com.mk.pizzaexpress.domain.entity.enums.EstadoPedido;
import com.mk.pizzaexpress.domain.entity.user.Cliente;
import com.mk.pizzaexpress.domain.exceptions.ClienteException;
import com.mk.pizzaexpress.domain.exceptions.PedidoException;
import com.mk.pizzaexpress.persistence.repository.ClienteRepository;
import com.mk.pizzaexpress.persistence.repository.PedidoRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

@Setter
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    PedidoMapper pedidoMapper;

    @Override
    public List<PedidoDto> listarTodosLosPedidos() {
        return pedidoMapper.toDtoList(pedidoRepository.findAll());
    }

    @Override
    public PedidoDto obtenerPedidoPorNumeroDePedido(int numeroDePedido) {
        Pedido pedido = pedidoRepository.findByNumeroDePedido(numeroDePedido).orElseThrow(()-> new PedidoException("Pedido no encontrado"));
        return pedidoMapper.toDto(pedido);
    }

    @Override
    public PedidoDto crearUnPedido(int clienteId, CrearPedidoDto crearPedidoDto,List<Integer> pizzasIds,List<Integer> bebidaIds) {

        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(()-> new ClienteException("Cliente no encontrado"));

        Pedido pedido = pedidoMapper.aPedidoDeCrearPedidoDto(crearPedidoDto);
        pedido.setNumeroDePedido(new Random().nextInt(900) + 100);
        pedido.setEstadoPedido(EstadoPedido.NOENTREGADO);
        //pedido.setPizzas();
        //pedido.setBebidas();
        pedido.setCliente(cliente);

        return null;
    }

    @Override
    public void restarStockDeIngredientesParaPizza(PizzaDto pizza) {

    }

    @Override
    public void restarStockDeBebidas(BebidaDto bebida) {

    }

    @Override
    public PedidoDto editarUnPedido(int numeroDePedido,int clienteId ,CrearPedidoDto crearPedidoDto,List<Integer> pizzasIds,List<Integer> bebidaIds) {

        Pedido pedido = pedidoRepository.findByNumeroDePedido(numeroDePedido).orElseThrow(()-> new PedidoException("No existe un pedido con este numero"));
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(()-> new ClienteException("Cliente no encontrado"));

        pedido.setNumeroDePedido(new Random().nextInt(900) + 100);
        pedido.setEstadoPedido(EstadoPedido.NOENTREGADO);
        pedido.setCliente(cliente);
        //pedido.setPizzas();
        //pedido.setBebidas();

        return null;
    }

    @Override
    public PedidoDto modificarEstadoDePedido(int numeroPedido) {

        Pedido pedido = pedidoRepository.findByNumeroDePedido(numeroPedido).orElseThrow(()-> new PedidoException("No existe un pedido con este numero de pedido"));
        pedido.setEstadoPedido(EstadoPedido.ENTREGADO);
        return pedidoMapper.toDto(pedidoRepository.save(pedido));
    }

    @Override
    public PedidoDto eliminarUnPedidoPorNumeroDePedido(int numeroDePedido) {
        Pedido pedido = pedidoRepository.findByNumeroDePedido(numeroDePedido).orElseThrow(()-> new PedidoException("Pedido no encontrado"));
        pedidoRepository.deleteById(numeroDePedido);
        return pedidoMapper.toDto(pedido);
    }

}
