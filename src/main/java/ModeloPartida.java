
import java.util.HashMap;
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

    public Patrones getPatrones() {
        return patrones;
    }

}
