import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Clase que funciona como controlador para la VistaStatus con el ModeloPartida
 */
public class ControladorStatus implements ObservadorPartida {
    private ModeloPartida modeloPartida;
    private VistaStatus vistaStatus;
    private Date fechaActual;
    private Nivel nivelActual;
    private Empresa jugadorActual;
    private SimpleDateFormat formatoFecha;

    /**
     * Constructor para el controlador de VistaStatus con ModeloPartida
     * @param modeloPartida el modelo de la partida del juego
     * @param vistaStatus la vista que administrará este controlador
     */
    public ControladorStatus(ModeloPartida modeloPartida, VistaStatus vistaStatus) {
        this.modeloPartida = modeloPartida;
        this.vistaStatus = vistaStatus;
        fechaActual = modeloPartida.getCalendario().getTime();
        nivelActual = modeloPartida.getNivelActual();
        jugadorActual = modeloPartida.getJugador();
        formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        actualizaVista();
    }
    
    @Override
    public void actualizaFecha(Date fecha) {
        fechaActual = fecha;
        // Refrescamos la vista con los datos nuevos
        actualizaVista();
    }
    
    public void actualizaVista() {
        vistaStatus.actualizarStatus("NOMBRE: " + jugadorActual.getNombre()
                + "\nFECHA: " + formatoFecha.format(fechaActual)
                + "\nDINERO: $" + jugadorActual.getDinero()
                + "\nNIVEL: " + nivelActual.getNombre());
    }
    
}
