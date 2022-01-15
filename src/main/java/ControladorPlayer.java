
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

/**
 * Clase que funciona como controlador para la VistaPlayer con el ModeloPartida.
 * Se encarga de manejar la entrada del jugador.
 */
public class ControladorPlayer{

    private ModeloPartida modeloPartida;
    private VistaPlayer vistaPlayer;
    private int accion;
    private ControladorFeedback feedback;
    /**
     * Constructor para el controlador de VistaPlayer con el ModeloPartida.
     * Determina la acción que se realizará cuando el jugador ingrese texto en
     * el cuadro controlado, en este caso se mandará el texto al modelo para que
     * sea manejado por otro controlador.
     *
     * @param modeloPartida el modelo de la partida del juego.
     * @param vistaPlayer la vista que administrará este controlador.
     * @param controladorFeedback el controlador de la parte feedback del programa
     */
    public ControladorPlayer(ModeloPartida modeloPartida, VistaPlayer vistaPlayer, ControladorFeedback controladorFeedback) {
        this.modeloPartida = modeloPartida;
        this.vistaPlayer = vistaPlayer;
        this.feedback = controladorFeedback;

        // Definimos lo que pasará cuando el usuario presione enter en la vista
        // controlada, en este caso específico se pasará el texto ingresado
        // al modelo para que otros controladores puedan acceder a él, además se 
        // vaciará el cuadro de texto.
        Action textoIngresado = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ultimaEntrada = vistaPlayer.leerEntrada();
                if(!ultimaEntrada.equals(" "));{                                     
                    try {
                        int opcion = Integer.parseInt(ultimaEntrada);
                        feedback.setOpcionUsuario(opcion);
                        if(opcion == 0)
                            feedback.setSiguiente(0);
                        feedback.mensajes();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese un número", "Advertencia", JOptionPane.DEFAULT_OPTION);
                    }            
                    vistaPlayer.limpiar();
                }
            }
        };

        this.vistaPlayer.añadeAccion(textoIngresado);
    }

}
