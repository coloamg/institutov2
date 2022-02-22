/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.InstitutoWeb.Instituto.Modelo;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import javax.persistence.JoinColumn;

/**
 *
 * @author Lautaro
 */
@Entity
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer IdProfesor;
    @Column(nullable = false)
    String Nombre;
    @Column(nullable = false)
    String Apellido;

    /* @JoinTable(name = "profmaterias", joinColumns = @JoinColumn(name = "FK_Profesor", nullable = false), inverseJoinColumns = @JoinColumn(name = "FK_Materia", nullable = false))
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Materia> materias; */

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "profmaterias",
            joinColumns = @JoinColumn(name = "FK_Profesor"),
            inverseJoinColumns = @JoinColumn(name = "FK_Materia")
            )
    private Set<Materia> materias;/* = new HashSet<>(); */
    
    public Profesor() {
    }

/*     public Profesor(int IdProfesor, String nombre, String apellido, Set<Materia> materias) {
        this.IdProfesor = IdProfesor;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.materias = materias;
    } */



    public Set<Materia> getmaterias() {
        return materias;
    }

    public void setmaterias(Set<Materia> materias) {
        this.materias = materias;
    }

    public Integer getIdProfesor() {
        return IdProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        IdProfesor = idProfesor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

}
