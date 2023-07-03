package com.example.clinicaOdontologica.service;
import com.example.clinicaOdontologica.entity.Odontologo;
import com.example.clinicaOdontologica.repository.OdontologoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    private static final Logger LOGGER= Logger.getLogger(OdontologoService.class);
    @Autowired
    private OdontologoRepository odontologoRepository;

    public Odontologo guardarOdontologo(Odontologo odontologo){
        LOGGER.info("Guardando odontólogo");
        return odontologoRepository.save(odontologo);
    }

    public Optional<Odontologo> buscarOdontologo(Long id){
        LOGGER.info("Buscando odontólogo");
        return odontologoRepository.findById(id);
    }

    public void actualizarOdontologo(Odontologo odontologo){
        LOGGER.info("Actualizando odontólogo");
        odontologoRepository.save(odontologo);
    }

    public void eliminarOdontologo(Long id){
        LOGGER.info("Eliminando odontólogo");
        odontologoRepository.deleteById(id);
    }

    public List<Odontologo> listarOdontologos(){
        LOGGER.info("Listando odontólogo");
        return odontologoRepository.findAll();
    }

    public Optional<Odontologo> buscarPorMatricula(String matricula){
        LOGGER.info("Buscando odontólogo por Matrícula");
        return odontologoRepository.findByMatricula(matricula);
    }
}

