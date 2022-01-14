import java.util.LinkedList;

/**
 *
 * Clase abstracta nivel, sirve para poder cambiar las acciones a realizar en 
 * cada nuvel según el juego avanza, es abstracta pues para el método cobrar se
 * busca que para implementaciones futuras se realizen distintos ajustes según 
 * el tiempo.
 */
public abstract class Nivel {
    protected LinkedList<Proyecto> proyectos;
    protected ConstructorProyectos constructorProyectos;
    protected LinkedList<Patron> patronesDisponibles;
    protected LinkedList<Lenguaje> lenguajesDisponibles;
    protected String nombre;
    protected int maximo;

    
    /**
     * Regresa el maximo del nivel
     * @return el maximo del nivel
     */
    public int getMaximo() {
        return maximo;
    }
    
    /**
     * Regresa los proyectos del nivel
     * @return los proyectos del nivel
     */
    public LinkedList<Proyecto> getProyectos() {
        return proyectos;
    }
    
    /**
     * Regresa el constructor de proyectos del nivel
     * @return el constructor de proyectos del nivel
     */
    public ConstructorProyectos getConstructorProyectos() {
        return constructorProyectos;
    }
    
    /**
     * Regresa los patrones disponibles del nivel
     * @return los patrones disponibles del nivel
     */
    public LinkedList<Patron> getPatronesDisponibles() {
        return patronesDisponibles;
    }
    
    /**
     * Regresa los lenguajes disponibles del nivel
     * @return los lenguajes disponibles del nivel
     */
    public LinkedList<Lenguaje> getLenguajesDisponibles() {
        return lenguajesDisponibles;
    }
    
    /**
     * Regresa el nombre del nivel
     * @return el nombre del nivel
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
    * Le cobra a la empresa según el nivel en turno
    * @param em la empresa a la que se le cobrará
    */
    public abstract void cobrar(Empresa em);
    
}
