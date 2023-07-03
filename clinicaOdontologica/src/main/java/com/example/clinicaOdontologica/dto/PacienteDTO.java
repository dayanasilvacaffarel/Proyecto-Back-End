package com.example.clinicaOdontologica.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String documento;
    private DomicilioDTO domicilio;
    private LocalDate fechaIngreso;
    private String email;

}
