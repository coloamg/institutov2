package com.InstitutoWeb.Instituto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.InstitutoWeb.Instituto.Modelo.*;
@Repository
public interface InstitutoRepositoryAlumno extends JpaRepository<Alumno, Integer>{
    
}
