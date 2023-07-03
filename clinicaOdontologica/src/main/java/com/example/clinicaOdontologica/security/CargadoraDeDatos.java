package com.example.clinicaOdontologica.security;

import com.example.clinicaOdontologica.entity.AppUsuario;
import com.example.clinicaOdontologica.entity.AppUsuarioRole;
import com.example.clinicaOdontologica.service.AppUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CargadoraDeDatos implements ApplicationRunner {

    private AppUsuarioService appUsuarioService;

    @Autowired
    public CargadoraDeDatos(AppUsuarioService appUsuarioService) {
        this.appUsuarioService = appUsuarioService;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        String pass= "password";
        String passCifrada= passwordEncoder.encode(pass);
        appUsuarioService.guardarUsuario(new AppUsuario("Dayana", "Silva", "dayana.silva.caffarel@gmail.com", passCifrada, AppUsuarioRole.ROLE_ADMIN));
    }
}
