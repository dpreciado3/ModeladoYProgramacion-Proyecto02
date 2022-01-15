import java.util.LinkedList;

/**
 *
 * Clase que representa al nivel Independiente
 */
public class Independiente extends Nivel{
    
    /*
    * Constructor de la clase Independiente 
    */
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
        nombre = "Independiente";
        maximo = 100000;
        costoOperativo = 100;
    }
    @Override
    public void cobrar(Empresa em) {
        em.setDinero(em.getDinero()-costoOperativo);
    }
    
}
