
import java.util.Date;
import java.util.LinkedList;
import java.text.SimpleDateFormat;

/**
 *
 * @author bbjbr
 */
public class Proyecto {
    
    private String nombreCliente;
    private String nombreProyecto;
    private String descripcion;
    private int paga;
    private LinkedList<Patron> patronesRequeridos = new LinkedList<>();    
    private LinkedList<Lenguaje> lenguajesRequeridos = new LinkedList<>();
    private Date fechaDeEntrega;
    private SimpleDateFormat formatoFecha;
    
    public String getNombreCliente() {
        return nombreCliente;
    }
    
    public String getNombreProyecto() {
        return nombreProyecto;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public int getPaga() {
        return paga;
    }
    
    public LinkedList<Patron> getPatronesRequeridos() {
        return patronesRequeridos;
    }
    
    public LinkedList<Lenguaje> getLenguajesRequeridos() {
        return lenguajesRequeridos;
    }
    
    public Date getFechaDeEntrega() {
        return fechaDeEntrega;
    }
    
    public void agregaNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    public void agregaNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }
    
    public void agregaDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void agregaPaga(int paga) {
        this.paga = paga;
    }
    
    public void agregaFechaDeEntrega(Date fechaDeEntrega) {
        this.fechaDeEntrega = fechaDeEntrega;
    }
    
    public void agregaLenguajesRequeridos(Lenguaje l) {
        lenguajesRequeridos.add(l);
    }

    public void agregaPatronesRequeridos(Patron pt) {
        patronesRequeridos.add(pt);
    }

    public int obtenCostoLenguajes() {
        int costo = 0;
        for (Lenguaje l : lenguajesRequeridos) {
            costo += l.getPrecio();
        }
        return costo;
    }

    public int obtenTiempoPatrones() {
        int tiempo = 0;
        for (Patron pt : patronesRequeridos) {
            tiempo += pt.getTiempoNecesario();
        }
        return tiempo;
    }

    @Override
    public String toString() {
        formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        return nombreProyecto
                + "\nCliente : " + nombreCliente
                + "\nDescripción: " + descripcion
                + "\nPago: " + paga + " pesos"
                + "\nFecha de entrega: " + formatoFecha.format(fechaDeEntrega);
    }
    
}
