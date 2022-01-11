import java.util.Date;

/**
 * Clase que funciona como controlador para la VistaStatus con el ModeloPartida
 */
public class ControladorStatus implements ObservadorPartida {
    private ModeloPartida modeloPartida;
    private VistaStatus vistaStatus;
    private Date fechaActual;

    /**
     * Constructor para el controlador de VistaStatus con ModeloPartida
     * @param modeloPartida el modelo de la partida del juego
     * @param vistaStatus la vista que administrará este controlador
     */
    public ControladorStatus(ModeloPartida modeloPartida, VistaStatus vistaStatus) {
        this.modeloPartida = modeloPartida;
        this.vistaStatus = vistaStatus;
        fechaActual = modeloPartida.getCalendario().getTime();
    }
    
    @Override
    public void actualizaFecha(Date fecha) {
        fechaActual = fecha;
        vistaStatus.setFecha(fechaActual.toString());
    }
    
}
