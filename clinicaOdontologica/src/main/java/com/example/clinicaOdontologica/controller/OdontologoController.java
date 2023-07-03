package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.entity.Odontologo;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Odontologo> guardarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarOdontologo(@RequestBody Odontologo odontologo) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarOdontologo(odontologo.getId());
        if(odontologoBuscado.isPresent()){
            odontologoService.actualizarOdontologo(odontologo);
            return ResponseEntity.ok("Odontologo Actualizado -"+odontologo.getNombre()+" "+odontologo.getApellido());
        }else{
            throw new ResourceNotFoundException("Odontologo no encontrado.");
        }
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> listarOdontologos(){
        return ResponseEntity.ok(odontologoService.listarOdontologos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologoPorId(@PathVariable Long id){
        Optional<Odontologo> odontologoBuscado= odontologoService.buscarOdontologo(id);
        if(odontologoBuscado.isPresent()){
            return ResponseEntity.ok(odontologoBuscado.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")

    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoBuscado= odontologoService.buscarOdontologo(id);
        if(odontologoBuscado.isPresent()){
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("Se elimino correctamente el odontologo con ID: "+id);
        }else{
            throw new ResourceNotFoundException("No se encontro el id asociado: "+id);
        }
    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<Odontologo> buscarPorMatricula(@PathVariable String matricula){
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarPorMatricula(matricula);
        if(odontologoBuscado.isPresent()){
            return ResponseEntity.ok(odontologoBuscado.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
