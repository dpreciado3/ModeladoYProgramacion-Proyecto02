public class Patron {
    private final String nombre;
    private final int tiempoNecesario;
    
    public Patron(String nombre, int tiempoNecesario) {
        this.nombre = nombre;
        this.tiempoNecesario = tiempoNecesario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTiempoNecesario() {
        return tiempoNecesario;
    }
    
    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        // Esto también considera el caso en que o es null
        if (!(o instanceof Patron)) return false;
        Patron patron = (Patron) o;
        return (patron.getNombre().equals(getNombre())) && (patron.getTiempoNecesario() == getTiempoNecesario());
    }
    
}
