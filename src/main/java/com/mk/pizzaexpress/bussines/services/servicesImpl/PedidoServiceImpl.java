package com.mk.pizzaexpress.bussines.services.servicesImpl;

import com.mk.pizzaexpress.bussines.mapper.implMapper.BebidaMapper;
import com.mk.pizzaexpress.bussines.mapper.implMapper.PedidoMapper;
import com.mk.pizzaexpress.bussines.mapper.implMapper.PizzaMapper;
import com.mk.pizzaexpress.bussines.services.BebidaService;
import com.mk.pizzaexpress.bussines.services.ClienteService;
import com.mk.pizzaexpress.bussines.services.PedidoService;
import com.mk.pizzaexpress.bussines.services.PizzaService;
import com.mk.pizzaexpress.domain.dto.pedido.CrearPedidoDto;
import com.mk.pizzaexpress.domain.dto.pedido.PedidoDto;
import com.mk.pizzaexpress.domain.entity.enums.EstadoPedido;
import com.mk.pizzaexpress.domain.entity.pedidos.Pedido;
import com.mk.pizzaexpress.domain.entity.productos.Bebida;
import com.mk.pizzaexpress.domain.entity.productos.Pizza;
import com.mk.pizzaexpress.domain.entity.usuarios.Cliente;
import com.mk.pizzaexpress.domain.exceptions.NotFoundException;
import com.mk.pizzaexpress.persistence.repository.BebidaRepository;
import com.mk.pizzaexpress.persistence.repository.ClienteRepository;
import com.mk.pizzaexpress.persistence.repository.PedidoRepository;
import com.mk.pizzaexpress.persistence.repository.PizzaRepository;
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
    @Autowired
    private PizzaMapper pizzaMapper;
    @Autowired
    private BebidaMapper bebidaMapper;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private BebidaService bebidaService;

    @Override
    public List<PedidoDto> listarTodosLosPedidos() {
        return pedidoMapper.toDtoList(pedidoRepository.findAll());
    }
    @Override
    public List<PedidoDto> obtenerPedidosPorClienteId(int clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(()-> new NotFoundException("Cliente no encontrado"));
        return pedidoMapper.toDtoList(cliente.getPedidos());
    }
    @Override
    public PedidoDto crearPedido(int clienteId, CrearPedidoDto crearPedidoDto) {

        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(()-> new NotFoundException("Cliente no encontrado"));
        Pizza pizza = pizzaRepository.findByNombre(crearPedidoDto.getNombrePizza()).orElseThrow(()-> new NotFoundException("Pizza no encotrada"));
        Bebida bebida = bebidaRepository.findByMarca(crearPedidoDto.getMarcaBebida()).orElseThrow(()-> new NotFoundException("Bebida no encontrada"));

        Pedido pedido = pedidoMapper.aPedidoDeCrearPedidoDto(crearPedidoDto);
        pedido.setCliente(cliente);
        pedido.setPizza(pizza);
        pedido.setBebida(bebida);
        pedido.setCantidadDePizzas(crearPedidoDto.getCantidadDePizzas());
        pedido.setCantidadDeBebidas(crearPedidoDto.getCantidadDeBebidas());
        pedido.setEstadoPedido(EstadoPedido.NO_ENTREGADO);

        return pedidoMapper.toDto(pedidoRepository.save(pedido));
    }
    @Override
    public PedidoDto editarPedido(int pedidoId, CrearPedidoDto crearPedido) {

        Pedido pedido = pedidoRepository.findById(pedidoId).orElseThrow(()-> new NotFoundException("Pedido no encontrado"));
        Pizza pizza = pizzaRepository.findByNombre(crearPedido.getNombrePizza()).orElseThrow(()-> new NotFoundException("Pizza no encotrada"));
        Bebida bebida = bebidaRepository.findByMarca(crearPedido.getMarcaBebida()).orElseThrow(()-> new NotFoundException("Bebida no encontrada"));

        pedido.setPizza(pizza);
        pedido.setBebida(bebida);
        pedido.setCantidadDePizzas(crearPedido.getCantidadDePizzas());
        pedido.setCantidadDeBebidas(crearPedido.getCantidadDeBebidas());

        return pedidoMapper.toDto(pedidoRepository.save(pedido));
    }
    @Override
    public PedidoDto modificarEstadoDePedido(int pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId).orElseThrow(()-> new NotFoundException("Pedido no encontrado"));
        pedido.setEstadoPedido(EstadoPedido.ENTREGADO);
        return pedidoMapper.toDto(pedidoRepository.save(pedido));
    }
    @Override
    public PedidoDto eliminarUnPedido(int pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId).orElseThrow(()-> new NotFoundException("Pedido no encontrado"));
        pedidoRepository.deleteById(pedidoId);
        return pedidoMapper.toDto(pedido);
    }
}
