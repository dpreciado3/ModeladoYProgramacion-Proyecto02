
import java.util.Date;
import java.util.LinkedList;

public class ControladorFeedback implements ObservadorPartida {
    private ModeloPartida modeloPartida;
    private VistaFeedback vistaFeedback;
    
    public ControladorFeedback(ModeloPartida modeloPartida, VistaFeedback vistaFeedback){
        this.modeloPartida = modeloPartida;
        this.vistaFeedback = vistaFeedback;
        vistaFeedback.actualizaVista("Listo para emprender? \n Eige tu primer proyecto");
    }
    @Override
    public void actualizaCambios(Date fecha, Nivel nivel, Empresa jugador) {
       if (modeloPartida != null) {
	String opcion = modeloPartida.getUltimaEntradaJugador();
            switch(opcion){
                case "0":
                    vistaFeedback.actualizaVista("Listo para emprender? \n Eige tu primer proyecto");
                    break;
                case "1":
                    vistaFeedback.actualizaVista("Proyecto:" + modeloPartida.getProyectoActual().toString() +" \n");
                    break;
               // case "2":
                    //vistaFeedback.actualizaVista("Evaluación de proyecto:" + evaluar(modeloPartida.getProyectoActual(),modeloPartida.getPatronesElegidos(), modeloPartida.getLenguajesElegidos()) +" \n");
                    //break;
                case "3":
                    vistaFeedback.actualizaVista("Oficialmente haz pasado al " + modeloPartida.getNivelActual()/*.getNombre() */+"\n");
                    break;

                }
            }
    }
    private int evaluar(Proyecto proyecto, LinkedList<Patron> patronesElegidos, LinkedList<Lenguaje> lenguajesElegidos) {
        int calificacion = 0;
        double porcentajePatrones = 5.0;
        double porcentajeLenguajes = 5.0;
        
        // Si se pasó de la fecha de entrega, la calificación es 0
        if (modeloPartida.getCalendario().getTime().after(proyecto.getFechaDeEntrega()))
            return calificacion;
        
        // Puntaje de patrones
        double puntajePorPatron;
        puntajePorPatron = porcentajePatrones / ((double) proyecto.getPatronesRequeridos().size());
        double puntajePatrones;
        double patronesCorrectos = (double) cuentaCorrectos(proyecto.getPatronesRequeridos(), patronesElegidos);
        puntajePatrones = patronesCorrectos*puntajePorPatron;
        calificacion += (int) Math.round(puntajePatrones);
        
        // Puntaje de lenguajes
        double puntajePorLenguaje;
        puntajePorLenguaje = porcentajeLenguajes / ((double) proyecto.getLenguajesRequeridos().size());
        double puntajeLenguajes;
        double lenguajesCorrectos = (double) cuentaCorrectos(proyecto.getLenguajesRequeridos(), lenguajesElegidos);
        puntajeLenguajes = lenguajesCorrectos*puntajePorLenguaje;
        calificacion += (int) Math.round(puntajeLenguajes);
        
        return calificacion;
    }
    private <T> int cuentaCorrectos(LinkedList<T> l1, LinkedList<T> l2) {
        int correctos = 0;
        for (T elemento : l1) {
            if (l2.contains(elemento))
                ++correctos;
        }
        return correctos;
    } 
}
