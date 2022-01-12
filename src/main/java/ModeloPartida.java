
import java.util.Iterator;
import java.util.HashMap;
import java.util.Date;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.LinkedList;

/**
 * Clase que funciona como el modelo de la partida de Software Dev Tycoon
 * Contiene métodos que pueden ser utilizados por controladores para reflejar
 * cambios en la vista. También funciona como sujeto que actualiza a
 * observadores registrados mediante un timer, los observadores en cuestión son
 * los controladores del patrón MVC.
 */
public class ModeloPartida implements Sujeto {

    private Nivel nivelActual;
    private Calendar calendario;
    private Timer timer;
    private Patrones patrones;
    private HashMap<Integer, String> reseñas;
    private Empresa jugador;
    private LinkedList<ObservadorPartida> observadores;
    private String ultimaEntradaJugador;
    private Proyecto proyectoActual;

    /**
     * Clase para la tarea que realizará el timer global de la partida, en
     * particular avanzar la fecha un día y realizar el cobro cada tres
     * segundos.
     */
    private class AvanzaDia extends TimerTask {

        public void run() {
            calendario.add(Calendar.DATE, 1);
            // Sustraemos al jugador el costo diario del nivel correspondiente
            jugador.setDinero(jugador.getDinero() - nivelActual.getCostoOperacional());
            notificaObservadores();
        }
    }

    /**
     * Constructor para el modelo de la partida. Cada jugador empieza con $100
     * 000 y el nombre por default es "Googlesoft", se empieza desde el primer
     * nivel (Independiente). Se crean reseñas por cada posible calificación y
     * se guardan en el HashMap. Por último se inicia el calendario en el día
     * 1/1/2022 y se inicia el timer con la tarea anteriormente mencionada.
     */
    public ModeloPartida() {
        ultimaEntradaJugador = "";
        observadores = new LinkedList<>();
        jugador = new Empresa(100000, "Googlesoft");
        nivelActual = new Independiente();
        patrones = new Patrones();

        // Reseñas de los clientes
        reseñas = new HashMap<>();
        reseñas.put(0, "No pienso pagarte por eso, no me solucionaste nada.");
        reseñas.put(1, "No funciona lo que hiciste, pero puedo pagarle a "
                + "otra empresa para que lo termine. Agradece que te doy algo.");
        reseñas.put(2, "Esto es difícil de usar, de verdad preferiría otra solución.");
        reseñas.put(3, "Supongo que es aceptable, pero queda muy por debajo de "
                + "lo prometido. La paga será menos.");
        reseñas.put(4, "En mi vida había visto un trabajo tan mediocre, por"
                + "lo menos funciona. Tendré que reconsiderar la paga.");
        reseñas.put(5, "Funciona según lo acordado, el pago ha sido depositado.");
        reseñas.put(6, "Bastante bien, merecen un bono sobre la paga acordada.");
        reseñas.put(7, "Queda por encima de nuestras expectativas, "
                + "felicitaciones por un buen trabajo. Será recomepensado.");
        reseñas.put(8, "Excelente trabajo, no me esperaba menos de una "
                + "empresa tan reconocida. Ojalá podamos trabajar en el futuro");
        reseñas.put(9, "Hemos quedado sin palabras, todo funciona de maravilla."
                + "Agregaremos un jugoso bono por su buen desempeño, esperemos"
                + "lo tomen como el inicio de una larga relación de negocios.");
        reseñas.put(10, "Simplemente perfecto, muchas gracias. No cabe duda que "
                + "el talento merece ser reconocido, y a tu empresa le sobra."
                + "Seguiremos trabajando en un futuro.");

        // Administración de tiempo
        calendario = Calendar.getInstance();
        calendario.clear();
        calendario.set(2022, 0, 1);
        timer = new Timer(true);
        // Periodo en milisegundos, es decir, se repite cada 3s
        timer.scheduleAtFixedRate(new AvanzaDia(), 5000, 3000);

    }

    /**
     * Evalua el proyecto construido por el jugador de acuerdo a los patrones
     * elegidos, los lenguajes elegidos y la cercanía a la fecha de entrega.
     * La elección de patrones es el 50% de la evaluación y la elección de 
     * lenguajes el otro 50%. Si se pasa de la fecha de entrega, la calificación
     * siempre es 0.
     *
     * @param proyecto El proyecto que el jugador debía completar.
     * @param patronesElegidos Los patrones que el jugador escogió.
     * @param lenguajesElegidos Los lenguajes que el jugador escogió.
     * @return La calificación del desempeño del jugador en el proyecto, que es
     * un número entero del 0 al 10.
     */
    public int evaluaProyectoJugador(Proyecto proyecto,
            LinkedList<Patron> patronesElegidos,
            LinkedList<Lenguaje> lenguajesElegidos) {
        int calificacion = 0;
        double porcentajePatrones = 5.0;
        double porcentajeLenguajes = 5.0;
        
        // Si se pasó de la fecha de entrega, la calificación es 0
        if (calendario.getTime().after(proyecto.getFechaDeEntrega()))
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
    
    /**
     * A partir de la primera lista, determina cuántos elementos de la primera 
     * lista aparecen en la segunda lista.
     * @param <T> El tipo de elementos de la LinkedList.
     * @param l1 La lista cuyos elementos se desea contar en otra.
     * @param l2 La lista en donde se busca contar las apariciones de elementos
     * de la primer lista.
     * @return El número de elementos de la primera lista en la segunda lista.
     */
    private <T> int cuentaCorrectos(LinkedList<T> l1, LinkedList<T> l2) {
        int correctos = 0;
        for (T elemento : l1) {
            if (l2.contains(elemento))
                ++correctos;
        }
        return correctos;
    } 

    @Override
    public void notificaObservadores() {
        for (ObservadorPartida observador : observadores) {
            observador.actualizaCambios(calendario.getTime(), getNivelActual(), getJugador());
        }
    }

    @Override
    public void registrarObservador(ObservadorPartida observador) {
        observadores.add(observador);
    }

    @Override
    public void removerObservador(ObservadorPartida observador) {
        observadores.remove(observador);
    }

    public Nivel getNivelActual() {
        return nivelActual;
    }

    public Calendar getCalendario() {
        return calendario;
    }

    public HashMap<Integer, String> getReseñas() {
        return reseñas;
    }

    public Empresa getJugador() {
        return jugador;
    }

    public void setNivelActual(Nivel nivelActual) {
        this.nivelActual = nivelActual;
    }

    public void setJugador(Empresa jugador) {
        this.jugador = jugador;
    }

    public String getUltimaEntradaJugador() {
        return ultimaEntradaJugador;
    }

    public void setUltimaEntradaJugador(String ultimaEntradaJugador) {
        this.ultimaEntradaJugador = ultimaEntradaJugador;
    }

    public Proyecto getProyectoActual() {
        return proyectoActual;
    }

    public void setProyectoActual(Proyecto proyectoActual) {
        this.proyectoActual = proyectoActual;
    }
    
    

}
