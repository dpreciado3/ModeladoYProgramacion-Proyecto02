import java.util.LinkedList;
import java.util.Iterator;

public class Patrones {
    final private LinkedList<Patron> patronesComportamiento;
    final private LinkedList<Patron> patronesEstructurales;
    final private LinkedList<Patron> patronesCreacion;
    
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
    
    public Iterator getIteradorComportamiento(){
        return patronesComportamiento.iterator();
    }
    
    public Iterator getIteradorEstructurales(){
        return patronesEstructurales.iterator();
    }
    
    public Iterator getIteradorCreacion(){
        return patronesCreacion.iterator();
    }
}
