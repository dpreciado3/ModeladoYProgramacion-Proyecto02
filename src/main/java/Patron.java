/**
 * Clase abstracta que representa los patrones para los proyectos, 
 * es abstracta para que las propiedades de los patrones que la extienden
 * sean constantes entre sus diferentes instancias.
 */
public abstract class Patron {
    protected String nombre;
    protected int tiempoNecesario;

    public String getNombre() {
        return nombre;
    }

    public int getTiempoNecesario() {
        return tiempoNecesario;
    }
    
    /**
     * Compara dos patrones de acuerdo con su nombre y su tiempo necesario.
     * @param o El patron a comparar.
     * @return true si los patrones son el mismo, false en otro caso.
     */
    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        // Esto también considera el caso en que o es null
        if (!(o instanceof Patron)) return false;
        Patron patron = (Patron) o;
        return (patron.getNombre().equals(getNombre())) && (patron.getTiempoNecesario() == getTiempoNecesario());
    }
    
}
