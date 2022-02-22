
package com.InstitutoWeb.Instituto.Modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Lautaro
 */
@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int IDAlumno;
    @Column(nullable = false)
    String Nombre;
    @Column(nullable = false)
    String Apellido;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "alumnosmaterias",
            joinColumns = @JoinColumn(name = "FK_IdAlumno"),
            inverseJoinColumns = @JoinColumn(name = "FK_IdProfesor")
            )
    private List<Profesor> profesores;
    
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "alumnosmaterias",
            joinColumns = @JoinColumn(name = "FK_IdAlumno"),
            inverseJoinColumns = @JoinColumn(name = "FK_IdMateria")
            )
    private List<Materia> materias;

 

    public Alumno() {
    }
/* 
    public Alumno(int iDAlumno, String nombre, String apellido , List<Materia> materias, List<Profesor> profesores) {
        this.IDAlumno = iDAlumno;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.materias = materias;   
        this.profesores = profesores;
    } */

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public int getIDAlumno() {
        return IDAlumno;
    }

    public void setIDAlumno(int iDAlumno) {
        IDAlumno = iDAlumno;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }
 
    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
}
