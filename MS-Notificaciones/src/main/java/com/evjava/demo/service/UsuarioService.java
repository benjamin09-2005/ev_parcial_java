package com.evjava.demo.service;

import com.evjava.demo.model.Notificacion;
import com.evjava.demo.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    public List<Notificacion> obtenerTodas() {
        return notificacionRepository.findAll();
    }

    public Optional<Notificacion> obtenerPorId(Long id) {
        return notificacionRepository.findById(id);
    }

    public Notificacion guardarNotificacion(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public Notificacion actualizarNotificacion(Long id, Notificacion detallesNotificacion) {
        return notificacionRepository.findById(id).map(notificacion -> {
            notificacion.setTipo(detallesNotificacion.getTipo());
            notificacion.setMensaje(detallesNotificacion.getMensaje());
            notificacion.setUsuarioId(detallesNotificacion.getUsuarioId());
            return notificacionRepository.save(notificacion);
        }).orElseThrow(() -> new RuntimeException("Notificación no encontrada"));
    }

    public void eliminarNotificacion(Long id) {
        notificacionRepository.deleteById(id);
    }
}