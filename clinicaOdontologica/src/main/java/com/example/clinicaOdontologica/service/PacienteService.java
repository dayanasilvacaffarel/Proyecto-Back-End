package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.entity.Paciente;
import com.example.clinicaOdontologica.repository.PacienteRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
    private static final Logger LOGGER= Logger.getLogger(PacienteService.class);

    public Paciente guardarPaciente(Paciente paciente){
        LOGGER.info("Guardando Paciente");
        return pacienteRepository.save(paciente);
    }
    public Optional<Paciente> buscarPacientePorID(Long id){
        LOGGER.info("Buscnado Paciente por ID");
        return pacienteRepository.findById(id);
    }
    public void eliminarPaciente(Long id){
        LOGGER.info("Eliminando Paciente");
        pacienteRepository.deleteById(id);
    }
    public void actualizarPaciente(Paciente paciente){
        LOGGER.info("Actualizando Paciente");
        pacienteRepository.save(paciente);
    }

    public List<Paciente> devolverPacientes(){
        LOGGER.info("Listando Paciente");
        return pacienteRepository.findAll();
    }
    public Optional<Paciente> buscarPacientePorCorreo(String correo){
        LOGGER.info("Buscando Paciente por email");
        return pacienteRepository.findByEmail(correo);
    }
    public List<Paciente> listarPacientes(){
        LOGGER.info("Listando Pacientes");
        return pacienteRepository.findAll();
    }

}
