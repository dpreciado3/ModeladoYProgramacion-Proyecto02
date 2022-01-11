
import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author bbjbr
 */
public class Coorporativo  extends Nivel{
    
    public Coorporativo(){
        proyectos = new LinkedList<Proyecto>();
        constructorProyectos = new ConstructorProyectos();
        proyectos.add(constructorProyectos.construyeProyectoCorporativo1());
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
        lenguajesDisponibles.add(new R());
        lenguajesDisponibles.add(new C());
        lenguajesDisponibles.add(new Cplusplus());
        patronesDisponibles.add(new Strategy());
        patronesDisponibles.add(new Template());
        patronesDisponibles.add(new Observer());
        patronesDisponibles.add(new Iterator());
        patronesDisponibles.add(new Adapter());
        patronesDisponibles.add(new Composite());
        patronesDisponibles.add(new Facade());
        patronesDisponibles.add(new Builder());
        patronesDisponibles.add(new Prototype());
        patronesDisponibles.add(new State());
        patronesDisponibles.add(new Proxy());
        patronesDisponibles.add(new Decorator());
        patronesDisponibles.add(new Singleton());
        patronesDisponibles.add(new AbstractFactory());
        patronesDisponibles.add(new Factory());
        costoOperacional = 10;
    }
    @Override
    public void cobrar(Empresa em) {
        em.setDinero(em.getDinero()+30);
    }
    
}
