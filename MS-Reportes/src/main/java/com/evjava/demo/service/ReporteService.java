package com.evjava.demo.service;

import com.evjava.demo.model.Reporte;
import com.evjava.demo.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    public List<Reporte> obtenerTodos() {
        return reporteRepository.findAll();
    }

    public Optional<Reporte> obtenerPorId(Long id) {
        return reporteRepository.findById(id);
    }

    public Reporte guardarReporte(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    public Reporte actualizarReporte(Long id, Reporte detallesReporte) {
        return reporteRepository.findById(id).map(reporte -> {
            reporte.setDescripcion(detallesReporte.getDescripcion());
            reporte.setFechaGeneracion(detallesReporte.getFechaGeneracion());
            return reporteRepository.save(reporte);
        }).orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
    }

    public void eliminarReporte(Long id) {
        reporteRepository.deleteById(id);
    }
}