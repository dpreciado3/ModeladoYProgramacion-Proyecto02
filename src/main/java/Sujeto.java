/**
 * Interfaz para el sujeto, en este caso ModeloPartida, que administrará
 * a los observadores controladores.
 */
public interface Sujeto {
    
    /**
     * Añade al observador a la lista de observadores del sujeto.
     * @param observador El observador a añadir.
     */
    public void registrarObservador(ObservadorPartida observador);
    
    /**
     * Elimina al observador de la lista de observadores del sujeto.
     * @param observador El observador a eliminar.
     */
    public void removerObservador(ObservadorPartida observador);
    
    /**
     * Actualiza a los observadores con la nueva información del ModeloPartida.
     */
    public void notificaObservadores();
}
