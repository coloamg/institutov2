package com.InstitutoWeb.Instituto.Controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import com.InstitutoWeb.Instituto.Modelo.Alumno;
import com.InstitutoWeb.Instituto.Modelo.Materia;
import com.InstitutoWeb.Instituto.Modelo.Profesor;
import com.InstitutoWeb.Instituto.Servicio.InstitutoServiceAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/instituto/alumnos")
public class InstitutoControllerAlumno {
    @Autowired
    InstitutoServiceAlumno institutoService;

    @GetMapping("/listar")
    public String ListadoAlumnos(Model model) {
        model.addAttribute("alumnos", institutoService.getAllAlumno());
        return "ListadoAlumnos";
    }

    @GetMapping("/new")
    public String Agregar(Model model) {
        //VALIDO CAMPOS
        model.addAttribute("alumno", new Alumno());;
        return "formAlumno";
    }

    @PostMapping("/save")
    public String Save(@ModelAttribute @Valid Alumno alumno, Model modelo) {
        institutoService.save(alumno);
        return "redirect:/instituto/alumnos/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Optional<Alumno> alumno = institutoService.listarId(id);
        model.addAttribute("alumno", alumno);
        return "formAlumnoEdit";
    }
    @GetMapping("/inscriptMateria/{id}")
    public String inscriptMateria(@PathVariable int id, Model model) {
        Optional<Alumno> alumno = institutoService.listarId(id);
        model.addAttribute("materias", institutoService.getAllMateria());
        model.addAttribute("profesores",institutoService.getAllProfesor());
        model.addAttribute("alumno", alumno);
        return "formAlumnoinscriptMateria";
    }
    @GetMapping("/eliminar/{id}")
    public String delete(Model model, @PathVariable int id){
        institutoService.delete(id);
        return "redirect:/instituto/alumnos/listar";
    }

    public List<Profesor> profesorXMateria(int id){
        List<Profesor> profesores = new ArrayList<Profesor>();
        List<Materia> materias = new ArrayList<Materia>();
        for (int i = 0; i < institutoService.getAllProfesor().size(); i++) {
            materias.addAll(institutoService.getAllProfesor().get(i).getmaterias());
            for (int j = 0; j < materias.size(); j++) {
                if(materias.get(i).getId()== id){
                    profesores.add(institutoService.getAllProfesor().get(i));
                }
            }
        }
        return profesores;
    }
}
