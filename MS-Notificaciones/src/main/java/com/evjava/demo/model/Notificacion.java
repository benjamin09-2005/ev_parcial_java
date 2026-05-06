package com.evjava.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notificaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El tipo de notificación es obligatorio")
    private String tipo;

    @NotBlank(message = "El mensaje es obligatorio")
    private String mensaje;

    @NotNull(message = "El ID del usuario es obligatorio")
    @Column(name = "usuario_id")
    private Long usuarioId;
}