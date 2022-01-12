
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 * Clase que funciona como controlador para la VistaPlayer con el ModeloPartida.
 * Se encarga de manejar la entrada del jugador.
 */
public class ControladorPlayer {

    private ModeloPartida modeloPartida;
    private VistaPlayer vistaPlayer;

    /**
     * Constructor para el controlador de VistaPlayer con el ModeloPartida.
     * Determina la acción que se realizará cuando el jugador ingrese texto en
     * el cuadro controlado, en este caso se mandará el texto al modelo para que
     * sea manejado por otro controlador.
     *
     * @param modeloPartida el modelo de la partida del juego.
     * @param vistaPlayer la vista que administrará este controlador.
     */
    public ControladorPlayer(ModeloPartida modeloPartida, VistaPlayer vistaPlayer) {
        this.modeloPartida = modeloPartida;
        this.vistaPlayer = vistaPlayer;

        // Definimos lo que pasará cuando el usuario presione enter en la vista
        // controlada, en este caso específico se pasará el texto ingresado
        // al modelo para que otros controladores puedan acceder a él, además se 
        // vaciará el cuadro de texto.
        Action textoIngresado = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ultimaEntrada = vistaPlayer.leerEntrada();
                modeloPartida.setUltimaEntradaJugador(ultimaEntrada);
                vistaPlayer.limpiar();
            }
        };

        this.vistaPlayer.añadeAccion(textoIngresado);
    }

}
