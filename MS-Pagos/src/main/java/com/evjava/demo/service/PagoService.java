package com.evjava.demo.service;

import com.evjava.demo.model.Pago;
import com.evjava.demo.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> obtenerTodos() {
        return pagoRepository.findAll();
    }

    public Optional<Pago> obtenerPorId(Long id) {
        return pagoRepository.findById(id);
    }

    public Pago guardarPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago actualizarPago(Long id, Pago detallesPago) {
        return pagoRepository.findById(id).map(pago -> {
            pago.setMetodo(detallesPago.getMetodo());
            pago.setMonto(detallesPago.getMonto());
            pago.setFecha(detallesPago.getFecha());
            pago.setPedidoId(detallesPago.getPedidoId());
            return pagoRepository.save(pago);
        }).orElseThrow(() -> new RuntimeException("Pago no encontrado"));
    }

    public void eliminarPago(Long id) {
        pagoRepository.deleteById(id);
    }
}