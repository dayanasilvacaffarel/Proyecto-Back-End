package com.example.clinicaOdontologica.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TurnoDTO {
    private Long id;
    private LocalDateTime fecha;
    private Long pacienteId;
    private Long odontologoId;
}
