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

    public boolean estaInscripto(Alumno alumno){
        var datos_alumnos = listarId(alumno.getIDAlumno());
        for (int i = 0; i < datos_alumnos.length; i++) {
            if(datos_alumnos.getMaterias().get(i).getId()==alumno.getMaterias().get(0).getId()){
                return true;
            }
        }
        return false;
    }
    
    public boolean inscribirse(Alumno alumno){
        if(!estaInscripto(alumno)){
            if(alumno.getMaterias().size() != alumno.getProfesores().size()){
                return false;
            }
            for(int i = 0; i < alumno.getMaterias().size();i++){
                instituoRepositorio.inscribirMateria(alumno.getIDAlumno(), alumno.getMaterias().get(0).getId(), alumno.getProfesores().get(0).getIdProfesor());
            }
            return true;
        }
        return false;
        
    }
    
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
