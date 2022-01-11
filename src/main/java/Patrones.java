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
        
        patronesComportamiento.add(new Patron("Observer", 5));
        patronesComportamiento.add(new Patron("Strategy", 3));
        patronesComportamiento.add(new Patron("Iterator", 1));
        patronesComportamiento.add(new Patron("Template", 4));
        patronesComportamiento.add(new Patron("State", 10));
        
        patronesEstructurales.add(new Patron("Adapter", 3));
        patronesEstructurales.add(new Patron("Proxy", 10));
        patronesEstructurales.add(new Patron("Composite", 7));
        patronesEstructurales.add(new Patron("Decorator", 3));
        patronesEstructurales.add(new Patron("Facade", 5));
        
        patronesCreacion.add(new Patron("Singleton", 7));
        patronesCreacion.add(new Patron("Builder", 6));
        patronesCreacion.add(new Patron("Prototype", 3));
        patronesCreacion.add(new Patron("Abstract factory", 15));
        patronesCreacion.add(new Patron("Factory", 10));
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
