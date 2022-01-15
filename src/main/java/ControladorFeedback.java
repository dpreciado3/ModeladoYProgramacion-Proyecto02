
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 * Clase que funciona como controlador para la VistaFeedback con el ModeloPartida
 * Se encarga de decirle al usuario que es es lo que tiene que hacer para poder 
 * ganar el juego
 */
public class ControladorFeedback implements ObservadorPartida {
    
    private ModeloPartida modeloPartida;
    private VistaFeedback vistaFeedback;
    private ControladorPlayer player;
    private int opcionUsuario;
    private Proyecto proyectoActual; 
    private LinkedList<Patron> patronesElegidos;
    private LinkedList<Lenguaje> lenguajesElegidos;
    private int siguiente;
    private  boolean[] agregadoPatrones;
    private boolean[] agregadoLenguajes;
                
    /**
     * Constructor de la clase ControladorFeedback
     * @param modeloPartida el modelo de este controlador
     * @param vistaFeedback la vista de este controlador
     */
    public ControladorFeedback(ModeloPartida modeloPartida, VistaFeedback vistaFeedback){
        this.modeloPartida = modeloPartida;
        this.vistaFeedback = vistaFeedback;
        siguiente = 0;
        mensajes();   
    }
    
    /**
     * Establece la opcionUsuairo del ControladorFeedback
     * @param opcionUsuario la opcionUsuairo del ControladorFeedback
     */
    public void setOpcionUsuario(int opcionUsuario) {
        this.opcionUsuario = opcionUsuario;
    }
    
    /**
     * Establece el player del ControladorFeedback
     * @param player el player del ControladorFeedback
     */
    public void setPlayer(ControladorPlayer player) {
        this.player = player;
    }   
    
    /**
     * Establece la siguiente accion a realizar del ControladorFeedback
     * @param siguiente la siguiente del ControladorFeedback
     */
    public void setSiguiente(int siguiente) {
        this.siguiente = siguiente;
    } 
    
    /**
     * Muestra en pantalla lo que toca hacer en el juego según las condiciones
     * actuales de este
     */
    public void mensajes(){
        switch(siguiente){
            //elige proyecto y se reinicia la partida
            case 0:
                modeloPartida.reiniciar();
                proyectoActual = null;
                lenguajesElegidos = new LinkedList<Lenguaje>();  
                patronesElegidos = new LinkedList<Patron>(); 
                //opcionUsuario = -2;
                vistaFeedback.actualizaVista("Listo para emprender?" + daProyectos() + "\n \n Presione 0 para reiniciar el juego");
                siguiente = 10;
                break;
            //elige proyecto y se sigue estando en el mismo nivel
            case 1:
                vistaFeedback.actualizaVista("Continua creciendo " + daProyectos() + "\n \n Presione 0 para reiniciar el juego");
                siguiente = 10;
                break;
            //elige proyecto y se cambia de nivel
            case 2:
                vistaFeedback.actualizaVista("Felicidades ahora eres nivel " + modeloPartida.getNivelActual().getNombre()
                        + daProyectos() + "\n \n Presione 0 para reiniciar el juego");
                siguiente = 10;
                break;
            //fin del juego
            case 3:
                vistaFeedback.actualizaVista("Felicidades, oficialmente estas listo para desarrollar tu empresa"+ 
                        "\n \n Presione 0 para reiniciar el juego" +
                        "\n \n"
                        + "     ██▄▄▄▄▄▄▄▄▄   \n" +
                        "    ▒▒▒▒▒▒▒▒▒▒▓██  \n" +
                        "   ▀▀▒▒▒▀▀▒▒▒▓▓▓▓█ \n" +
                        " ▄▄▄▒▒░    ░░▒▒▒▓█ \n" +
                        " ▀▀▀▒▄▄▄   ░░▒▒▒▓█ \n" +
                        "   █▄░   ░░▒▒▒▒▓▓█ \n" +
                        "    ▀█▄▄▄▄▄▄▄▄▄▀▀  " );
                siguiente = 0;
                break;
            //perder el juego
            case 4: 
                vistaFeedback.actualizaVista("Lo sentimos haz quebrado =("  + "\n \n Presione 0 para reiniciar el juego");
                siguiente = 0;
                break;
            //Muestra proyecto seleciconado y pide elegir patrones para este
            case 5: 
                vistaFeedback.actualizaVista("Proyecto:" + proyectoActual.toString() + daPatrones()+ 
                        "\n \n Presione 0 para reiniciar el juego");
                siguiente = 8; 
                break;
            //Muestra proyecto seleciconado y pide elegir lenguajes para este
            case 6: 
                vistaFeedback.actualizaVista("Proyecto:" + proyectoActual.toString() + daLenguajes()+ 
                        "\n \n Presione 0 para reiniciar el juego");
                siguiente = 9;
                break;
            //Muestra evaluacion de proyecto seleciconado
            case 7:
                 vistaFeedback.actualizaVista("Evaluación de proyecto:" + evaluar()+ 
                         "\n \n Presione 0 para reiniciar el juego o cualquier otro número para continuar con este");
                 siguiente = verificaNivel();
                 break;
            //guarda los patrones que se le van diciendo
            case 8:
                agregaPatrones();
                break;
            case 9:
            //guarda los lenguajes que se le van diciendo
                agregaLenguajes();
                break;
            //selecciona el proyecto que se le indica
            case 10:
                proyectoActual = (Proyecto)validaEntrada(modeloPartida.getNivelActual().getProyectos());
                if(proyectoActual != null){
                    siguiente = 5;
                    mensajes();
                }                
        }             
    }
    @Override
    public void actualizaCambios() {
        if(modeloPartida.getJugador().getDinero()<0){
            modeloPartida.reiniciar();
            siguiente = 4;
            mensajes();
       }
    }
    
    /**
     * Verifica que el patrón que el usuario seleccionó sea valido (que exista y 
     * no lo haya agregado antes) y de ser así lo agrega a patronesElegidos para
     * la posterior evaluación del patrón
     */  
    private void agregaPatrones(){
        switch (opcionUsuario) {
            case -1:
                if (patronesElegidos.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tienes que escoger por lo menos un patrón", "Advertencia", JOptionPane.DEFAULT_OPTION);
                    break;
                }
                siguiente = 6;
                mensajes();
                break;
            default:
               Patron propuesta = (Patron)validaEntrada(modeloPartida.getNivelActual().getPatronesDisponibles());
                if(propuesta != null){
                    if(agregadoPatrones[opcionUsuario-1] == false){
                        patronesElegidos.add(propuesta);
                        agregadoPatrones[opcionUsuario-1] = true;
                    }else
                        JOptionPane.showMessageDialog(null, "Ya habías agregado este patrón", "Advertencia", JOptionPane.DEFAULT_OPTION);
                }
                break;
        }
    }
    
    /**
     * Verifica que el lenguaje que el usuario seleccionó sea valido (que exista y 
     * no lo haya agregado antes) y de ser así lo agrega a lenguajesElegidos para
     * la posterior evaluación del patrón
     */  
    private void agregaLenguajes(){
        switch (opcionUsuario) {
            case -1:
                if (lenguajesElegidos.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tienes que escoger por lo menos un lenguaje", "Advertencia", JOptionPane.DEFAULT_OPTION);
                    break;
                }
                siguiente = 7;
                mensajes();
                break;
            default:
                Lenguaje propuesta = (Lenguaje)validaEntrada(modeloPartida.getNivelActual().getLenguajesDisponibles());
                if(propuesta != null){
                    if(agregadoLenguajes[opcionUsuario-1] == false){
                        lenguajesElegidos.add(propuesta);
                        agregadoLenguajes[opcionUsuario-1] = true;
                    }else
                        JOptionPane.showMessageDialog(null, "Ya habías agregado este lenguaje", "Advertencia", JOptionPane.DEFAULT_OPTION);
                }
                break;
        }
    }
    
    /**
     * Verifica que la opción seleccionada por el usuario sea en verdad una opción
     * @return el objeto al que hacía referencia la opción o null si no existía dicha opción
     */  
    private <T> T validaEntrada(LinkedList<T> lista){
        int i=1;
        if(opcionUsuario> lista.size() || opcionUsuario<1)
                JOptionPane.showMessageDialog(null, "La opción ingresada no existe", "Advertencia", JOptionPane.DEFAULT_OPTION);
        else
            for(T t: lista){
                if(i++ == opcionUsuario)
                    return t;    
            }
        return null;
    }
    
    
    /**
     * Actualiza el nivel del usuario con base a las condiciones actuales del 
     * juego
     * @return entero que indica como es el nuevo nivel respecto el anterior
     */  
    private int verificaNivel(){
        Nivel nivelActual = modeloPartida.getNivelActual();
        if(nivelActual.getMaximo()< modeloPartida.getJugador().getDinero()){
            switch(nivelActual.getNombre())   {
                //Cambio de nivel y se sigue jugando
                case "Independiente":
                    modeloPartida.setNivelActual(new PequenaEmpresa());
                    return 2;
                case "Pequeña empresa":
                    modeloPartida.setNivelActual(new Coorporativo());
                    return 2;
                //Cambio de nivel y no se sigue jugando
                default:
                    return 3;                        
            }
        }
        //se queda en el mismo nivel
        return 1;            
    }
    
    /**
     * Regresa los proyectos disponibles para el nivel actual
     * @return proyectos los proyectos disponibles para el nivel actual
     */  
    private String daProyectos(){                
        agregadoLenguajes = new boolean[modeloPartida.getNivelActual().getLenguajesDisponibles().size()];
        agregadoPatrones = new boolean[modeloPartida.getNivelActual().getPatronesDisponibles().size()];
        String proyectos = "\nIngresa el número del proyecto que desees desarrollar: ";
        LinkedList<Proyecto> proyectosDisponibles = modeloPartida.getNivelActual().getProyectos();
        int i=1;
        for(Proyecto p: proyectosDisponibles)
            proyectos += "\n    "+Integer.toString(i++) + ": " + p.getNombreProyecto();
        return proyectos;
    }
    
    /**
     * Regresa los lenguajes disponibles para el nivel actual
     * @return lenguajes los lenguajes disponibles para el nivel actual
     */ 
    private String daLenguajes(){
        String lenguajes = "\nIngresa el número del proyecto que desees desarrollar: ";
        LinkedList<Lenguaje> lenguajesDisponibles = modeloPartida.getNivelActual().getLenguajesDisponibles();
        int i=1;
        for(Lenguaje l: lenguajesDisponibles)
            lenguajes += "\n    "+Integer.toString(i++) + ": " + l.getNombre() + " ($"+ l.getPrecio() +")" ;
        lenguajes += "\n    -1: No agregar más lenguajes";
        return lenguajes;
    }
    
    /**
     * Regresa los patrones disponibles para el nivel actual
     * @return patrones los patrones disponibles para el nivel actual
     */ 
    private String daPatrones(){
        String patrones = "\nIngresa el número de los patrones que vas a ocupar en el proyecto: ";
        LinkedList<Patron> patronesDisponibles = modeloPartida.getNivelActual().getPatronesDisponibles();
        int i=1;
        for(Patron pt: patronesDisponibles)
            patrones += "\n    "+Integer.toString(i++) + ": " + pt.getNombre()+ " ("+ pt.getTiempoNecesario()+" días para implementar)" ;
        patrones += "\n    -1: No agregar más patrones";        
        return patrones;
    }
    
    /**
     * Evalua el proyecto actual y cambia el dinero de la jugador de ModeloPartida
     * según esta evaluación
     * @return evaluacion la evaluación del proyecto actual
     */
    private String evaluar() {
        for(Lenguaje l: lenguajesElegidos)
            System.out.println(l.getNombre());
        String evaluacion = "\n";
        int calificacion = 0;
        double porcentajePatrones = 5.0;
        double porcentajeLenguajes = 5.0;
        int ganancia = -costoLenguajes();// si no pasó se le descuenta el precio de los lenguajes
        
        // Si se pasó de la fecha de entrega, la calificación es 0
        if (modeloPartida.getCalendario().getTime().after(proyectoActual.getFechaDeEntrega())){
            modeloPartida.getJugador().setDinero(modeloPartida.getJugador().getDinero() + ganancia);
            return "Tristemente entregaste después de la fecha de entrega \n Calificación final: 0 \n Ganancia: "+ ganancia;
        }
        double[] calificacionParcialPatrones = cuentaPatronesCorrectos(proyectoActual.getPatronesRequeridos(),patronesElegidos);    
        // Puntaje de patrones
        double puntajePorPatron;
        puntajePorPatron = porcentajePatrones / ((double) patronesElegidos.size());
        double puntajePatrones;
        puntajePatrones = calificacionParcialPatrones[3]*puntajePorPatron;
        // Calificación reprobatoria
        if (puntajePatrones < 0)
            puntajePatrones = 0;
        calificacion += (int) Math.round(puntajePatrones);
        evaluacion +="Calificación patrones: " + (int) Math.round(puntajePatrones);
        evaluacion +="\n    Patrones correctos: " + calificacionParcialPatrones[0];
        evaluacion +="\n    Patrones parcialmente correctos: " + calificacionParcialPatrones[1]; 
        evaluacion +="\n    Patrones incorrectos: " + calificacionParcialPatrones[2];        
        // Puntaje de lenguajes
        double puntajePorLenguaje;
        puntajePorLenguaje = porcentajeLenguajes / ((double) proyectoActual.getLenguajesRequeridos().size());
        double puntajeLenguajes;
        int[] calificacionParcialLenguajes = cuentaLenguajesCorrectos(proyectoActual.getLenguajesRequeridos(),lenguajesElegidos);     
        double lenguajesCorrectos = (double)(calificacionParcialLenguajes[0]+calificacionParcialLenguajes[1]) ;
        puntajeLenguajes = lenguajesCorrectos*puntajePorLenguaje;
        // Calificación reprobatoria
        if (puntajeLenguajes < 0)
            puntajeLenguajes = 0;
        calificacion += (int) Math.round(puntajeLenguajes);        
        evaluacion +="\nCalificación lenguajes: " + (int) Math.round(puntajeLenguajes);
        evaluacion +="\n    Lenguajes correctos: " + calificacionParcialLenguajes[0];
        evaluacion +="\n    Lenguajes incorrectos: " + calificacionParcialLenguajes[1]*-1;
        if(calificacion > 5)
            ganancia += (calificacion * proyectoActual.getPaga())/10; // si pasó se le da un parte proporcional de la ganancia 
        modeloPartida.getJugador().setDinero(modeloPartida.getJugador().getDinero() + ganancia);
        evaluacion +="\nCalificación final : "+ calificacion + "\n";
        evaluacion += "\nReseña del cliente: ''" + modeloPartida.getReseñas().get(calificacion) + "''";
        evaluacion += "\n \n Tu balance de este proyecto es: $" + ganancia + " pesos";
        // Avanzamos el calendario la cantidad de días que se tardó en implementar los patrones
        avanzaDias(tiempoPatrones());
        // Reiniciar listas
        lenguajesElegidos.clear();
        patronesElegidos.clear();
        return evaluacion;
    }

    /**
     * Evalua como son los lenguajes escogidos por el usuario respecto a los del
     * proyecto
     * @param l1 lista con los lenguajes correctos 
     * @param l2 lista con los lenguajes ingresados
     * @return resultados los resultados de la evaluacion de los lenguajes
     */
    private int[] cuentaLenguajesCorrectos(LinkedList<Lenguaje> l1, LinkedList<Lenguaje> l2) {
        int[] correctos = new int[2];
        for (Lenguaje elemento : l2) {
            if (l1.contains(elemento)) {
                ++correctos[0];
            }else
                --correctos[1];
        }
        return correctos;
    }

    /**
     * Evalua como son los patrones escogidos por el usuario respecto a los del
     * proyecto
     * @return resultados los resultados de la evaluacion de los patrones
     * @param l1 lista con los patrones correctos
     * @param l2 lista con los patrones ingresados
     */
    private double[] cuentaPatronesCorrectos(LinkedList<Patron> l1, LinkedList<Patron> l2) {
        double[] resultados = new double[4];
        LinkedList<String> categoriasElegidas = new LinkedList<>();
        for (Patron elemento : l1) {
            categoriasElegidas.add(getCategoria(elemento));
        }
        for (Patron elemento : l2) {
            String categoriaElemento = getCategoria(elemento);
            if (l1.contains(elemento)) {
                resultados[0]++;
                ++resultados[3];
            } else if (categoriasElegidas.contains(categoriaElemento)) {
                // Removemos la categoría para que no se cuente más de una vez
                // el medio/entero punto (solo corresponde a una coincidencia)
                categoriasElegidas.remove(categoriaElemento); 
                resultados[1] ++;
                resultados[3] += 0.5;   
            }else{
                resultados[2] ++;
                resultados[3] -= 0.5;
            }            
        }
        return resultados;
    }
    
    /**
     * Regresa la categoria del patrón en forma de Cadena
     * @return la categoria del patrón en forma de Cadena
     */
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
    
    private int costoLenguajes(){
        int costo = 0;
        for(Lenguaje l: lenguajesElegidos)
            costo += l.getPrecio();
        return costo;
    }
    
    private int tiempoPatrones(){
        int dias = 0;
        for(Patron p: patronesElegidos)
            dias += p.getTiempoNecesario();
        return dias;
    }
    
    private void avanzaDias(int dias) {
        modeloPartida.getCalendario().add(Calendar.DATE, dias);
        modeloPartida.getJugador().setDinero(modeloPartida.getJugador().getDinero() - modeloPartida.getNivelActual().getCostoOperativo()*dias);
    }
}
