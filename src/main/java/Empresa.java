/**
 * Clase que simula a un jugador de Software Dev Tycoon con su empresa.
 */
public class Empresa {
    private int dinero;
    private String nombre;

    /**
     * Constructor para la empresa que representa a un jugador de Software Dev Tycoon.
     * @param dinero El dinero inicial del jugador y su empresa.
     * @param nombre El nombre de la empresa del jugador.
     */
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
