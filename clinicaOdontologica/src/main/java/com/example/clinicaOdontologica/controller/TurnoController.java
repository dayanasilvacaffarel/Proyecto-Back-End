package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.dto.TurnoDTO;
import com.example.clinicaOdontologica.entity.Turno;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.service.OdontologoService;
import com.example.clinicaOdontologica.service.PacienteService;
import com.example.clinicaOdontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<TurnoDTO> guardarTurno(@RequestBody Turno turno){

        if(odontologoService.buscarOdontologo(turno.getOdontologo().getId())!=null&&pacienteService.buscarPacientePorID(turno.getPaciente().getId())!=null){
            return ResponseEntity.ok(turnoService.guardarTurno(turno));
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<TurnoDTO>> listarTurnos(){

        return ResponseEntity.ok(turnoService.listarTurnos());

    }
    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscarPorId(@PathVariable Long id){

        Optional<TurnoDTO> turnoBuscado = turnoService.buscarPorID(id);
        if(turnoBuscado.isPresent()){
            return ResponseEntity.ok(turnoBuscado.get());

        }else{
            return ResponseEntity.notFound().build();

        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id)throws ResourceNotFoundException {

        Optional<TurnoDTO> turnoBuscado = turnoService.buscarPorID(id);
        if(turnoBuscado.isPresent()) {
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("Se eliminó correctamente el turno solicitado: " + id);
        }else{
            throw new ResourceNotFoundException("Existe el id asociado: ");
        }

    }


}