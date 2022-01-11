import java.util.LinkedList;
import java.util.Iterator;

/**
 * Clase auxiliar para agrupar los patrones por categoría para la evaluación 
 * en ModeloPartida. Solo puede ser leída, de manera que estas categorías no
 * pueden ser modificadas fuera de esta clase.
 */
public class Patrones {
    final private LinkedList<Patron> patronesComportamiento;
    final private LinkedList<Patron> patronesEstructurales;
    final private LinkedList<Patron> patronesCreacion;
    
    /**
     * Constructor para las categorías de patrones. Crea una lista por cada 
     * categoría mencionada en el archivo README con sus patrones 
     * correspondientes.
     */
    public Patrones() {
        patronesComportamiento = new LinkedList<>();
        patronesEstructurales = new LinkedList<>();
        patronesCreacion = new LinkedList<>();
        
        patronesComportamiento.add(new Observer());
        patronesComportamiento.add(new Strategy());
        patronesComportamiento.add(new IteratorPattern());
        patronesComportamiento.add(new Template());
        patronesComportamiento.add(new State());
        
        patronesEstructurales.add(new Adapter());
        patronesEstructurales.add(new Proxy());
        patronesEstructurales.add(new Composite());
        patronesEstructurales.add(new Decorator());
        patronesEstructurales.add(new Facade());
        
        patronesCreacion.add(new Singleton());
        patronesCreacion.add(new Builder());
        patronesCreacion.add(new Prototype());
        patronesCreacion.add(new AbstractFactory());
        patronesCreacion.add(new Factory());
    }
    
    /**
     * @return Un iterador que recorre la lista de patrones de comportamiento.
     */
    public Iterator getIteradorComportamiento(){
        return patronesComportamiento.iterator();
    }
    
    /**
     * @return Un iterador que recorre la lista de patrones estructurales.
     */
    public Iterator getIteradorEstructurales(){
        return patronesEstructurales.iterator();
    }
    
    /**
     * @return Un iterador que recorre la lista de patrones de creación.
     */
    public Iterator getIteradorCreacion(){
        return patronesCreacion.iterator();
    }
}
