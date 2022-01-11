/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Date;
import java.util.LinkedList;

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
    public int obtenCostoLenguajes(){
        int costo = 0;
        for(Lenguaje l: lenguajesRequeridos)
            costo += l.getPrecio();
        return costo;
    }
    public int obtenTiempoPatrones(){
        int tiempo = 0;
        for(Patron pt: patronesRequeridos)
            tiempo += pt.getTiempoNecesario();
        return tiempo;
    }
    public String mostrar(){
        String proyecto = nombreProyecto + 
                "\nCliente : " + nombreCliente +
                "\nDescripción: "+ descripcion +
                "\n Pago: $" + paga +
                "\nLenguaje(s) preferido(s): \n";
        for(Lenguaje l: lenguajesRequeridos)
            proyecto += "   -" + l.getNombre() + "\n";
        proyecto += "Costo total de lenguajes: $" + obtenCostoLenguajes() + "\n";
        proyecto += "\nPatron(es) preferido(s): \n";
        for(Patron pt: patronesRequeridos)
            proyecto += "   -" + pt.getNombre() + "\n\n";
        proyecto += "Tiempo total de patrones: $" + obtenTiempoPatrones() + "\n";
        return proyecto;
    }
    /*public int calificaPatrones(LinkedList<Patron> patronesPropuestos){
        int califPatrones = 0;
        Collections.sort(patronesPropuestos);//falta agregar comparator
        for(int i=0; i< patronesRequeridos.size(); i++)
            if(patronesPropuestos.get(i).getNombre().equals(patronesRequeridos.get(i).getNombre()))
                califPatrones ++;
        return (califPatrones * 25)/ patronesRequeridos.size();
    }*/
}
