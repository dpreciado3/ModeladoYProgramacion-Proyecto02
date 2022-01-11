
import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author bbjbr
 */
public class Independiente extends Nivel{
    
    public Independiente(){
        proyectos = new LinkedList<Proyecto>();
        constructorProyectos = new ConstructorProyectos();
        proyectos.add(constructorProyectos.construyeProyectoIdependiente1());
        patronesDisponibles =  new LinkedList<Patron>();
        lenguajesDisponibles = new LinkedList<Lenguaje>();
        lenguajesDisponibles.add(new CSharp());
        lenguajesDisponibles.add(new PHP());
        lenguajesDisponibles.add(new JavaScript());
        patronesDisponibles.add(new Strategy());
        patronesDisponibles.add(new Template());
        costoOperacional = 10;
        nombre = "Independiente";
    }
    @Override
    public void cobrar(Empresa em) {
        em.setDinero(em.getDinero()+10);
    }
    
}
