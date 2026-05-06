package com.evjava.demo.controller;

import com.evjava.demo.model.Notificacion;
import com.evjava.demo.service.NotificacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @GetMapping
    public ResponseEntity<List<Notificacion>> listarNotificaciones() {
        return new ResponseEntity<>(notificacionService.obtenerTodas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> obtenerNotificacion(@PathVariable Long id) {
        return notificacionService.obtenerPorId(id)
                .map(notificacion -> new ResponseEntity<>(notificacion, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Notificacion> crearNotificacion(@Valid @RequestBody Notificacion notificacion) {
        Notificacion nuevaNotificacion = notificacionService.guardarNotificacion(notificacion);
        return new ResponseEntity<>(nuevaNotificacion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notificacion> actualizarNotificacion(@PathVariable Long id, @Valid @RequestBody Notificacion notificacion) {
        try {
            Notificacion notificacionActualizada = notificacionService.actualizarNotificacion(id, notificacion);
            return new ResponseEntity<>(notificacionActualizada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNotificacion(@PathVariable Long id) {
        notificacionService.eliminarNotificacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}