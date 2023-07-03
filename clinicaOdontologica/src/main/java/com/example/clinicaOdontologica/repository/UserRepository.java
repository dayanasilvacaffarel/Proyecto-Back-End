package com.example.clinicaOdontologica.repository;

import com.example.clinicaOdontologica.entity.AppUsuario;
import com.example.clinicaOdontologica.entity.AppUsuarioRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUsuario, Long> {

    Optional<AppUsuario> findByEmail(String email);
}
