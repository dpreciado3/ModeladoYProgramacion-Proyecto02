
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Clase que funciona como controlador para la VistaStatus con el ModeloPartida
 * Se encarga de reportar cambios en la partida al jugador.
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
     *
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
    public void actualizaCambios() {
       /* fechaActual = fecha;
        nivelActual = nivel;
        jugadorActual = jugador;
        // Refrescamos la vista con los datos nuevos
        actualizaVista();*/
        fechaActual = modeloPartida.getCalendario().getTime();
        nivelActual = modeloPartida.getNivelActual();
        jugadorActual = modeloPartida.getJugador();
        // Refrescamos la vista con los datos nuevos
        actualizaVista();
    }

    /**
     * Actualiza el texto de VistaStatus con los valores más recientes de los
     * atributos de clase
     */
    public void actualizaVista() {
        vistaStatus.actualizarStatus("NOMBRE: " + jugadorActual.getNombre()
                + "\nFECHA: " + formatoFecha.format(fechaActual)
                + "\nDINERO: $" + jugadorActual.getDinero()
                + "\nNIVEL: " + nivelActual.getNombre());
    }

}
