package com.InstitutoWeb.Instituto.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.InstitutoWeb.Instituto.Modelo.*;
@Repository
public interface InstitutoRepositoryAlumno extends JpaRepository<Alumno, Integer>{
    @Modifying
    @Query(value = "INSERT INTO alumnosmaterias (fk_id_alumno, fk_id_profesor, fk_id_materia) VALUES (:idAlumno,:idProfesor,:idMateria)", nativeQuery = true)
    @Transactional
    public void inscribirMateria(@Param("idAlumno")int idAlumno,@Param("idProfesor")int idMateria,@Param("idMateria")int idProfesor);
}
