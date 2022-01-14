import java.util.Date;

/**
 * Interfaz para los controladores observadores del ModeloPartida
 */
public interface ObservadorPartida {
    
    /**
     * Actualiza los datos del observador con los cambios del ModeloPartida
     * @param fecha La fecha más reciente del ModeloPartida
     * @param nivel El nivel más reciente del jugador
     * @param jugador El estatus más reciente del jugador, lo que nos interesa
     * en realidad es su cantidad de dinero restante
     */
    public void actualizaCambios();
    
}
