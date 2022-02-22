/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.InstitutoWeb.Instituto.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Lautaro
 */
@Entity
@Table(name = "materias")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer IDMateria;
    @Column(nullable = false)
    String Nombre;

    @JoinTable(name = "materiascorrelativas", joinColumns = @JoinColumn(name = "FK_Materia", nullable = false), inverseJoinColumns = @JoinColumn(name = "FK_Correlativa", nullable = false))
    @OneToOne()
    private Materia correlativas;

    /* @ManyToMany(mappedBy = "materias")
    private List<Profesor> profesores; */

    public Materia() {
    }

    public Materia(int id, String nombre, Materia correlativas/* , List<Profesor>profesores */) {
        this.IDMateria = id;
        this.Nombre = nombre;
        this.correlativas = correlativas;
       /*  this.profesores = profesores; */
    }


    /* public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }
 */
    public int getId() {
        return IDMateria;
    }

    public Materia getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(Materia correlativas) {
        this.correlativas = correlativas;
    }

    public void setId(int id) {
        this.IDMateria = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    @Override
    public String toString() {
        return this.Nombre;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((IDMateria == null) ? 0 : IDMateria.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Materia other = (Materia) obj;
        if (IDMateria == null) {
            if (other.IDMateria != null)
                return false;
        } else if (!IDMateria.equals(other.IDMateria))
            return false;
        return true;
    }  
}
