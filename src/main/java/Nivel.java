/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.LinkedList;

/**
 *
 * @author bbjbr
 */
public abstract class Nivel {
    protected LinkedList<Proyecto> proyectos;
    protected ConstructorProyectos constructorProyectos;
    protected LinkedList<Patron> patronesDisponibles;
    protected LinkedList<Lenguaje> lenguajesDisponibles;
    protected int costoOperacional;

    public LinkedList<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(LinkedList<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public ConstructorProyectos getConstructorProyectos() {
        return constructorProyectos;
    }

    public void setConstructorProyectos(ConstructorProyectos constructorProyectos) {
        this.constructorProyectos = constructorProyectos;
    }

    public LinkedList<Patron> getPatronesDisponibles() {
        return patronesDisponibles;
    }

    public void setPatronesDisponibles(LinkedList<Patron> patronesDisponibles) {
        this.patronesDisponibles = patronesDisponibles;
    }

    public LinkedList<Lenguaje> getLenguajesDisponibles() {
        return lenguajesDisponibles;
    }

    public void setLenguajesDisponibles(LinkedList<Lenguaje> lenguajesDisponibles) {
        this.lenguajesDisponibles = lenguajesDisponibles;
    }

    public int getCostoOperacional() {
        return costoOperacional;
    }

    public void setCostoOperacional(int costoOperacional) {
        this.costoOperacional = costoOperacional;
    }
    public abstract void cobrar(Empresa em);

 
}
