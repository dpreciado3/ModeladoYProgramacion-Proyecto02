/**
 * Clase que representa los lenguajes para los proyectos.
 */
public abstract class Lenguaje{
        
    protected String nombre;
    protected int precio;
    
    /**
     * Regresa el nombre del lenguaje
     * @return el nombre del lenguaje
     */    
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Regresa el precio del lenuaje
     * @return el precio del lenuaje
     */
    public int getPrecio() {
        return precio;
    }
    
    /**
     * Compara dos lenguajes de acuerdo con su nombre.
     * @param o El lenguaje a comparar.
     * @return true si los lenguajes son el mismo, false en otro caso.
     */
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Lenguaje))
            return false;
        Lenguaje l = (Lenguaje) o;
        return nombre.equals(l.getNombre());
    }
}
