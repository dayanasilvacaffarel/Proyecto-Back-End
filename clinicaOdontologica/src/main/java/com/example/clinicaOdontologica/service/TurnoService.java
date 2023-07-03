package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.dto.TurnoDTO;
import com.example.clinicaOdontologica.entity.Odontologo;
import com.example.clinicaOdontologica.entity.Paciente;
import com.example.clinicaOdontologica.entity.Turno;
import com.example.clinicaOdontologica.repository.TurnoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    private static final Logger LOGGER= Logger.getLogger(TurnoService.class);
    @Autowired
    private TurnoRepository turnoRepository;

    public List<TurnoDTO> listarTurnos(){
        LOGGER.info("Listando Turnos");
        List<Turno> turnosEncontrados = turnoRepository.findAll();
        List<TurnoDTO> turnoDTOLista = new ArrayList<>();
        for (Turno turno: turnosEncontrados) {
            turnoDTOLista.add(turnoAturnoDTO(turno));
        }
        return turnoDTOLista;
    }
    public Optional<TurnoDTO> buscarPorID(Long id){
        LOGGER.info("Buscando Turno por ID");
        Optional<Turno> turnoBuscado= turnoRepository.findById(id);
        if(turnoBuscado.isPresent()){
            return Optional.of(turnoAturnoDTO(turnoBuscado.get()));
        }else{
            return Optional.empty();
        }
    }

    public TurnoDTO guardarTurno(Turno turno){
        LOGGER.info("Guardando Turno");
        Turno turnoGuardado= turnoRepository.save((turno));
        return turnoAturnoDTO(turnoGuardado);
    }

    public void eliminarTurno(Long id){
        turnoRepository.deleteById(id);
    }
    public void actualizarTurno(TurnoDTO turnodto){
        turnoRepository.save(turnoDTOaTurno(turnodto));
    }
    private TurnoDTO turnoAturnoDTO(Turno turno){
        TurnoDTO turnoDTO= new TurnoDTO();
        turnoDTO.setId(turno.getId());
        turnoDTO.setFecha(turno.getFecha());
        turnoDTO.setPacienteId(turno.getPaciente().getId());
        turnoDTO.setOdontologoId(turno.getOdontologo().getId());
        return turnoDTO;
    }
    private Turno turnoDTOaTurno(TurnoDTO turnoDTO){
        Turno turno = new Turno();
        Odontologo odontologo= new Odontologo();
        Paciente paciente= new Paciente();
        odontologo.setId(turnoDTO.getOdontologoId());
        paciente.setId(turnoDTO.getPacienteId());
        turno.setId(turnoDTO.getId());
        turno.setFecha(turnoDTO.getFecha());
        return  turno;
    }
}
