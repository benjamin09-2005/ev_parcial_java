package com.evjava.demo.controller;

import com.evjava.demo.model.Reporte;
import com.evjava.demo.service.ReporteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public ResponseEntity<List<Reporte>> listarReportes() {
        return new ResponseEntity<>(reporteService.obtenerTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reporte> obtenerReporte(@PathVariable Long id) {
        return reporteService.obtenerPorId(id)
                .map(reporte -> new ResponseEntity<>(reporte, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Reporte> crearReporte(@Valid @RequestBody Reporte reporte) {
        Reporte nuevoReporte = reporteService.guardarReporte(reporte);
        return new ResponseEntity<>(nuevoReporte, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reporte> actualizarReporte(@PathVariable Long id, @Valid @RequestBody Reporte reporte) {
        try {
            Reporte reporteActualizado = reporteService.actualizarReporte(id, reporte);
            return new ResponseEntity<>(reporteActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReporte(@PathVariable Long id) {
        reporteService.eliminarReporte(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}