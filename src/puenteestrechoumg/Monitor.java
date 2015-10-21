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
public class Monitor extends Thread {
    @Override
    public void run() {
        while(true){
            if(Main.gui.obtenerNumeroCarros() == Main.gui.MAX_CARROS){
                Main.gui.cambiarDireccionActual(1 - Main.gui.obtenerDireccionActual());
                System.out.println("MAXIMO SOPORTADO");
                try{
                    System.out.println("CARROS ESPERA DIRECCION 0 : " + Main.gui.obtenerColaEspera(0) + " CARROS ESPERA DIRECCION 1 : " + Main.gui.obtenerColaEspera(1) + "CARROS EN PUENTE : " +  Main.gui.obtenerNumeroCarros() + " DIRECCION ACTUAL : " + Main.gui.obtenerDireccionActual());
                    sleep(500);
                }catch(InterruptedException e){}
            }
        }
    }
}
