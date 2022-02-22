package com.InstitutoWeb.Instituto.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
/* import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping; */

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class institutoController {
    public String ListadoAlumnos() {
        return "index";
    }
}
