package com.InstitutoWeb.Instituto.Controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.InstitutoWeb.Instituto.Modelo.Materia;
import com.InstitutoWeb.Instituto.Servicio.InstitutoServiceMateria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/instituto/materias")
public class InstitutoControllerMateria {
    @Autowired
    InstitutoServiceMateria institutoService;

    @GetMapping("/listar")
    public String ListadoMaterias(Model model) {
        model.addAttribute("materias", institutoService.getAllMateria());
        return "ListadoMaterias";
    }

    @GetMapping("/new")
    public String Agregar(Model model) {
        //VALIDO CAMPOS
        model.addAttribute("materia", new Materia());
        model.addAttribute("materias", institutoService.getAllMateria());
        return "formMateria";
    }

    @PostMapping("/save")
    public String Save(@ModelAttribute @Valid Materia materia, Model modelo) {
        institutoService.save(materia);
        return "redirect:/instituto/materias/listar";
    }

    @GetMapping("/editar/{id}")

    public String editar(@PathVariable int id, Model model) {
        Optional<Materia> materia = institutoService.listarId(id);
        model.addAttribute("materia", materia);
        List<Materia> correlativas = new ArrayList<Materia>();
        for (int i = 0; i < institutoService.getAllMateria().size(); i++) {
            if(institutoService.getAllMateria().get(i).getId()!=id){
                correlativas.add(institutoService.getAllMateria().get(i));
            }
        }
        model.addAttribute("materias", correlativas);
        return "formMateriaEdit";
    }

    @GetMapping("/eliminar/{id}")
    @ResponseBody
    public boolean delete(Model model, @PathVariable int id){
        return institutoService.delete(id);
    }
}
