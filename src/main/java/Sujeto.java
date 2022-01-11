public interface Sujeto {
    public void registrarObservador(ObservadorPartida observador);
    public void removerObservador(ObservadorPartida observador);
    public void notificaObservadores();
}
