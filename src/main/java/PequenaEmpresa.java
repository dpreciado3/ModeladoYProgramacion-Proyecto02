import java.util.LinkedList;

/**
 *
 * Clase que representa al nivel Pequeña Empresa
 */
public class PequenaEmpresa  extends Nivel{
    
    /*
    * Constructor de la clase Pequeña Empresa 
    */
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
        nombre = "Pequeña empresa";
        maximo = 200000;
        costoOperativo = 1000;
    }
    @Override
    public void cobrar(Empresa em) {
        em.setDinero(em.getDinero()-costoOperativo);
    }
    
}
