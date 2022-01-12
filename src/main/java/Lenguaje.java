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
    
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Lenguaje))
            return false;
        Lenguaje l = (Lenguaje) o;
        return nombre.equals(l.getNombre());
    }
}
