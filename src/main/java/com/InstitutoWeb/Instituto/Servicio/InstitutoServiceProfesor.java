package com.InstitutoWeb.Instituto.Servicio;

import java.util.List;
import java.util.Optional;

import javax.transaction.TransactionScoped;

import com.InstitutoWeb.Instituto.Modelo.Materia;
import com.InstitutoWeb.Instituto.Modelo.Profesor;
import com.InstitutoWeb.Instituto.Repositorio.InstitutoRepositoryMateria;
import com.InstitutoWeb.Instituto.Repositorio.InstitutoRepositoryProfesor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class InstitutoServiceProfesor {
    @Autowired
    InstitutoRepositoryProfesor instituoRepositorio;
    @Autowired 
    InstitutoRepositoryMateria institutoRepoMateria;   
    
    @TransactionScoped
    public Profesor save(Profesor profesor) {
        return instituoRepositorio.save(profesor);
    }

    public List<Profesor> getAllProfesors(){
        return instituoRepositorio.findAll();
    }
    public Optional<Profesor> listarId(int id){
        return instituoRepositorio.findById(id);
    }

    public void delete(int id){
        instituoRepositorio.deleteById(id);
    }
    public List<Materia> getAllMateria(){
        return institutoRepoMateria.findAll();
    }

}
