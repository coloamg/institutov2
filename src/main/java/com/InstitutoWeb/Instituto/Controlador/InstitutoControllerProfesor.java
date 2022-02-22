package com.InstitutoWeb.Instituto.Controlador;

import java.util.List;

import javax.validation.Valid;

import com.InstitutoWeb.Instituto.Modelo.Materia;
import com.InstitutoWeb.Instituto.Modelo.Profesor;
import com.InstitutoWeb.Instituto.Repositorio.InstitutoRepositoryMateria;
import com.InstitutoWeb.Instituto.Servicio.InstitutoServiceProfesor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/instituto/profesores")
public class InstitutoControllerProfesor {
    
    @Autowired
    InstitutoServiceProfesor institutoService;
    @Autowired
    InstitutoRepositoryMateria mateRepository;
    @GetMapping("/listar")
    public String ListadoProfesores(Model model) {
        model.addAttribute("profesores", institutoService.getAllProfesors());
        return "ListadoProfesores";
    }
    
    @GetMapping("/new")
    public String Agregar(Model model) {
        //VALIDO CAMPOS
        model.addAttribute("profesor", new Profesor());
        model.addAttribute("materias", institutoService.getAllMateria());
        return "formProfesor";
    }
    @PostMapping("/save")
    public String Save(@ModelAttribute @Valid Profesor profesor, Model modelo) {
        institutoService.save(profesor);
        return "redirect:/instituto/profesores/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("profesor", institutoService.listarId(id));
        List<Materia> materias = (List<Materia>) mateRepository.findAll();
        model.addAttribute("materias", materias);
        return "formProfesorEdit";
    }
    @GetMapping("/eliminar/{id}")
    public String delete(Model model, @PathVariable int id){
        institutoService.delete(id);
        return "redirect:/instituto/profesores/listar";
    }
}
