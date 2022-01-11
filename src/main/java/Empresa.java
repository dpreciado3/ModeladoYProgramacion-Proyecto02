public class Empresa {
    private int dinero;
    private String nombre;

    public Empresa() {
    }

    public Empresa(int dinero, String nombre) {
        this.dinero = dinero;
        this.nombre = nombre;
    }

    
    
    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
