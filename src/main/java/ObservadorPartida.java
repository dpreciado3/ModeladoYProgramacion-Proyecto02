import java.util.Date;

/**
 * Interfaz para los controladores observadores del ModeloPartida
 */
public interface ObservadorPartida {
    
    /**
     * Actualiza la fecha del observador con la fecha del ModeloPartida
     * @param fecha La fecha más reciente del ModeloPartida
     */
    public void actualizaFecha(Date fecha);
    
}
