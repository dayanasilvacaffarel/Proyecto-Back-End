package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.entity.Odontologo;
import com.example.clinicaOdontologica.exception.ResourceNotFoundException;
import com.example.clinicaOdontologica.repository.OdontologoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Autowired
    private OdontologoRepository repository;

    private Odontologo odontologo;

    public void cargarDataSet () {
        odontologo.setNombre("Dayana");
        odontologo.setApellido("Silva");
        odontologo.setMatricula("1234");
        odontologoService.guardarOdontologo(odontologo);
    }

    @BeforeEach public void setUp(){
        odontologo = new Odontologo();
    }


    @Test
    public void borraUnOdontologo() throws Exception {

        cargarDataSet();
        Integer totalOdontologosAntesDeEliminar = repository.findAll().size();
        Integer totalOdontologosEsperado = totalOdontologosAntesDeEliminar-1;
        odontologoService.eliminarOdontologo(1L);

        //Cuando

        Integer totalOdontologosDespuesDeBorrar = repository.findAll().size();

        //Entonces
        assertEquals(totalOdontologosEsperado, totalOdontologosDespuesDeBorrar);
    }

    @Test
    public void crearUnOdontologo() throws ResourceNotFoundException {
        //Dado
        Integer totalOdontologosAntesCreacion = repository.findAll().size();
        Integer totalOdontologosEsperado = totalOdontologosAntesCreacion+1;

        //Cuando
        cargarDataSet();
        Integer totalOdontologosDespuesCreacion = repository.findAll().size();

        //Entonces
        assertEquals(totalOdontologosEsperado, totalOdontologosDespuesCreacion);
    }


}