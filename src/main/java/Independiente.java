/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author bbjbr
 */
public class Independiente extends Nivel{
    
    public Independiente(){
        
    }
    @Override
    public void cobrar(Empresa em) {
        em.setDinero(10);
    }
    
}
