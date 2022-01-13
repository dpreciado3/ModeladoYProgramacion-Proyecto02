
import java.util.Date;
import java.util.LinkedList;
import java.util.Iterator;

public class ControladorFeedback implements ObservadorPartida {

    private ModeloPartida modeloPartida;
    private VistaFeedback vistaFeedback;

    public ControladorFeedback(ModeloPartida modeloPartida, VistaFeedback vistaFeedback) {
        this.modeloPartida = modeloPartida;
        this.vistaFeedback = vistaFeedback;
        vistaFeedback.actualizaVista("Listo para emprender? \n Eige tu primer proyecto");
    }

    @Override
    public void actualizaCambios(Date fecha, Nivel nivel, Empresa jugador) {
        if (modeloPartida != null) {
            String opcion = modeloPartida.getUltimaEntradaJugador();
            switch (opcion) {
                case "0":
                    vistaFeedback.actualizaVista("Listo para emprender? \n Eige tu primer proyecto");
                    break;
                case "1":
                    vistaFeedback.actualizaVista("Proyecto:" + modeloPartida.getProyectoActual().toString() + " \n");
                    break;
                // case "2":
                //vistaFeedback.actualizaVista("Evaluación de proyecto:" + evaluar(modeloPartida.getProyectoActual(),modeloPartida.getPatronesElegidos(), modeloPartida.getLenguajesElegidos()) +" \n");
                //break;
                case "3":
                    vistaFeedback.actualizaVista("Oficialmente haz pasado al " + modeloPartida.getNivelActual()/*.getNombre() */ + "\n");
                    break;

            }
        }
    }

    private int evaluar(Proyecto proyecto, LinkedList<Patron> patronesElegidos, LinkedList<Lenguaje> lenguajesElegidos) {
        int calificacion = 0;
        double porcentajePatrones = 5.0;
        double porcentajeLenguajes = 5.0;

        // Si se pasó de la fecha de entrega, la calificación es 0
        if (modeloPartida.getCalendario().getTime().after(proyecto.getFechaDeEntrega())) {
            return calificacion;
        }

        // Puntaje de patrones
        double puntajePorPatron;
        puntajePorPatron = porcentajePatrones / ((double) proyecto.getPatronesRequeridos().size());
        double puntajePatrones;
        double patronesCorrectos = cuentaPatronesCorrectos(proyecto.getPatronesRequeridos(), patronesElegidos);
        puntajePatrones = patronesCorrectos * puntajePorPatron;
        calificacion += (int) Math.round(puntajePatrones);

        // Puntaje de lenguajes
        double puntajePorLenguaje;
        puntajePorLenguaje = porcentajeLenguajes / ((double) proyecto.getLenguajesRequeridos().size());
        double puntajeLenguajes;
        double lenguajesCorrectos = (double) cuentaLenguajesCorrectos(proyecto.getLenguajesRequeridos(), lenguajesElegidos);
        puntajeLenguajes = lenguajesCorrectos * puntajePorLenguaje;
        calificacion += (int) Math.round(puntajeLenguajes);

        return calificacion;
    }

    // Cuenta la cantidad de lenguajes de la primer lista que aparecen
    // en la segunda lista
    private int cuentaLenguajesCorrectos(LinkedList<Lenguaje> l1, LinkedList<Lenguaje> l2) {
        int correctos = 0;
        for (Lenguaje elemento : l1) {
            if (l2.contains(elemento)) {
                ++correctos;
            }
        }
        return correctos;
    }

    /*
    * Cuenta la cantidad de patrones de la primer lista que aparecen en 
    * la segunda lista.
    * Si un patrón de la primera lista no aparece pero sí aparece algún otro 
    * patrón de la misma categoría, cuenta como medio. 
     */
    private double cuentaPatronesCorrectos(LinkedList<Patron> l1, LinkedList<Patron> l2) {
        double correctos = 0.0;
        LinkedList<String> categoriasElegidas = new LinkedList<>();
        for (Patron elemento : l2) {
            categoriasElegidas.add(getCategoria(elemento));
        }

        for (Patron elemento : l1) {
            String categoriaElemento = getCategoria(elemento);
            if (l2.contains(elemento)) {
                ++correctos;
            } else if (categoriasElegidas.contains(categoriaElemento)) {
                // Removemos la categoría para que no se cuente más de una vez
                // el medio punto (solo corresponde a una coincidencia)
                categoriasElegidas.remove(categoriaElemento);
                correctos += 0.5;
            }
        }

        return correctos;
    }

    // Regresa la categoria del patrón en forma de Cadena
    private String getCategoria(Patron p) {
        Iterator patronesComportamiento = modeloPartida.getPatrones().getIteradorComportamiento();
        Iterator patronesEstructurales = modeloPartida.getPatrones().getIteradorEstructurales();
        Iterator patronesCreacion = modeloPartida.getPatrones().getIteradorCreacion();

        while (patronesComportamiento.hasNext()) {
            if (((Patron) patronesComportamiento.next()).equals(p)) {
                return "Comportamiento";
            }
        }

        while (patronesEstructurales.hasNext()) {
            if (((Patron) patronesEstructurales.next()).equals(p)) {
                return "Estructural";
            }
        }

        while (patronesCreacion.hasNext()) {
            if (((Patron) patronesCreacion.next()).equals(p)) {
                return "Creacion";
            }
        }

        return "";
    }
}
