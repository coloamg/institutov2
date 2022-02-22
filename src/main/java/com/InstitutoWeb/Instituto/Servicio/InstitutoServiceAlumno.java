package com.InstitutoWeb.Instituto.Servicio;

import java.util.List;
import java.util.Optional;

import javax.transaction.TransactionScoped;

import com.InstitutoWeb.Instituto.Modelo.Alumno;
import com.InstitutoWeb.Instituto.Modelo.Materia;
import com.InstitutoWeb.Instituto.Modelo.Profesor;
import com.InstitutoWeb.Instituto.Repositorio.InstitutoRepositoryAlumno;
import com.InstitutoWeb.Instituto.Repositorio.InstitutoRepositoryMateria;
import com.InstitutoWeb.Instituto.Repositorio.InstitutoRepositoryProfesor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class InstitutoServiceAlumno {
    @Autowired
    InstitutoRepositoryAlumno instituoRepositorio; 
    @Autowired
    InstitutoRepositoryMateria instituoRepositorioMat;   
    @Autowired
    InstitutoRepositoryProfesor instituoRepositorioProf;  
    
    @TransactionScoped
    public Alumno save(Alumno alumno) {
        //LOGICA
        return instituoRepositorio.save(alumno);
    }

    public List<Alumno> getAllAlumno(){
        return instituoRepositorio.findAll();
    }
    public Optional<Alumno> listarId(int id){
        return instituoRepositorio.findById(id);
    }
    public void delete(int id){
        instituoRepositorio.deleteById(id);
    }

    public List<Materia> getAllMateria(){
        return instituoRepositorioMat.findAll();
    }
    public List<Profesor> getAllProfesor(){
        return instituoRepositorioProf.findAll();
    }

}
