
import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author bbjbr
 */
public class PequenaEmpresa  extends Nivel{
    
    public PequenaEmpresa(){
        proyectos = new LinkedList<Proyecto>();
        constructorProyectos = new ConstructorProyectos();
        proyectos.add(constructorProyectos.construyeProyectoPequenaEmpresa1());
        patronesDisponibles =  new LinkedList<Patron>();
        lenguajesDisponibles = new LinkedList<Lenguaje>();
        lenguajesDisponibles.add(new CSharp());
        lenguajesDisponibles.add(new PHP());
        lenguajesDisponibles.add(new JavaScript());
        lenguajesDisponibles.add(new Java());
        lenguajesDisponibles.add(new Python());
        lenguajesDisponibles.add(new Kotlin());
        lenguajesDisponibles.add(new Swift());
        lenguajesDisponibles.add(new Ruby());
        lenguajesDisponibles.add(new Go());
        patronesDisponibles.add(new Strategy());
        patronesDisponibles.add(new Template());
        patronesDisponibles.add(new Observer());
        patronesDisponibles.add(new IteratorPattern());
        patronesDisponibles.add(new Adapter());
        patronesDisponibles.add(new Composite());
        patronesDisponibles.add(new Facade());
        patronesDisponibles.add(new Builder());
        patronesDisponibles.add(new Prototype());
        costoOperacional = 10;
    }
    @Override
    public void cobrar(Empresa em) {
        em.setDinero(em.getDinero()+20);
    }
    
}
