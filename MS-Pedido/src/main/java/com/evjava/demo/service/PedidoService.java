package com.evjava.demo.service;

import com.evjava.demo.model.Pedido;
import com.evjava.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obtenerPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido guardarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido actualizarPedido(Long id, Pedido detallesPedido) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setFecha(detallesPedido.getFecha());
            pedido.setTotal(detallesPedido.getTotal());
            pedido.setUsuarioId(detallesPedido.getUsuarioId());
            return pedidoRepository.save(pedido);
        }).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}