/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author bbjbr
 */
public  class Lenguaje{
        
    protected String nombre;
    protected int precio;
    
    public String getNombre() {
        return nombre;
    }
    
    public int getPrecio() {
        return precio;
    }
    public boolean equals(Lenguaje l){
        return nombre.equals(l.getNombre());
    }
}
