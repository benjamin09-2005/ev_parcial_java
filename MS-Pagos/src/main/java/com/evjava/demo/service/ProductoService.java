package com.evjava.demo.service;

import com.evjava.demo.model.Producto;
import com.evjava.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizarProducto(Long id, Producto detallesProducto) {
        return productoRepository.findById(id).map(productoExistente -> {
            productoExistente.setNombre(detallesProducto.getNombre());
            productoExistente.setPrecio(detallesProducto.getPrecio());
            productoExistente.setImagen(detallesProducto.getImagen());
            productoExistente.setCategoria(detallesProducto.getCategoria());
            return productoRepository.save(productoExistente);
        }).orElseThrow(() -> new RuntimeException("El producto con ID " + id + " no fue encontrado"));
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}