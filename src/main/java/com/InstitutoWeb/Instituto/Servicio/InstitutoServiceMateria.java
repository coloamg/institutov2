package com.InstitutoWeb.Instituto.Servicio;

import java.util.List;
import java.util.Optional;

import javax.transaction.TransactionScoped;

import com.InstitutoWeb.Instituto.Modelo.Materia;
import com.InstitutoWeb.Instituto.Repositorio.InstitutoRepositoryMateria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class InstitutoServiceMateria {
    @Autowired
    InstitutoRepositoryMateria instituoRepositorio;

    @TransactionScoped
    public Materia save(Materia materia) {
        // LOGICA
        return instituoRepositorio.save(materia);
    }

    public List<Materia> getAllMateria() {
        return instituoRepositorio.findAll();
    }

    public Optional<Materia> listarId(int id) {
        return instituoRepositorio.findById(id);
    }

    public boolean delete(int id) {
        Optional<Materia> materia = instituoRepositorio.findById(id);
        if (materia.isPresent()) {
            try {
                instituoRepositorio.deleteById(id);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }

}
