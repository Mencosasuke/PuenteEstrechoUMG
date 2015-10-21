/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puenteestrechoumg;

/**
 *
 * @author David Mencos
 */
public class Carro extends Thread{
    
    int direccion = (int)(Math.random() * 2);
    
    @Override
    public void run() {
        llegaPuente(direccion);
        try{
            sleep(1000);
        }catch(InterruptedException e){}
        salePuente(direccion);
    }
    
    public boolean isSafe(int direccion){
        if(Main.gui.obtenerNumeroCarros() == 0){
            return true;
        }else if((Main.gui.obtenerNumeroCarros() < Main.gui.MAX_CARROS) && (Main.gui.obtenerDireccionActual() == direccion)){
            return true;
        }else{
            return false;
        }
    }
    
    public void llegaPuente(int direccion){
        Main.gui.incrementarColaEspera(direccion);
        while(!isSafe(direccion)){
            try{
                sleep(300);
            }catch(InterruptedException e){}
        }
        Main.gui.incrementarNumeroCarros();
        Main.gui.decrecerColaEspera(direccion);
        
        //Main.gui.cambiarDireccionActual(direccion);
        Main.gui.cambiarImagenPuente(direccion);
    }
    
    public void salePuente(int direccion){
        Main.gui.decrecerNumeroCarros();
        if(Main.gui.obtenerNumeroCarros() == 0){
            System.out.println("YA NO HAY CARROS EN EL PUENTE");
        }
        if(Main.gui.obtenerNumeroCarros() < 1){
            if(Main.gui.obtenerColaEspera(1 - direccion) != 0){
                Main.gui.cambiarDireccionActual(1 - direccion);
            }
        }
    }
}
