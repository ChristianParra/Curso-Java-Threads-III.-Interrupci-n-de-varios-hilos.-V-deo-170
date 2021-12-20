/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ec.edu.monster.vista.Vista;
import ec.edu.monster.modelo.Modelo;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Jhon
 */
public class Controlador {
    private Vista theView;
    private Modelo theModel;

    public Controlador(Vista theView, Modelo theModel) {
        this.theView = theView;
        this.theModel = theModel;

        HilosVarios hilo1= new HilosVarios();
        //HilosVarios hilo2= new HilosVarios();
        HilosVarios2 hilo2= new HilosVarios2(hilo1);
        
        hilo2.start();
        hilo1.start();
        theView.anadir("Terminadas las tareas");
    }

    class HilosVarios extends Thread{
    public void run(){
        for (int i = 0; i < 15; i++) {
            try {
                theView.anadir("Ejecutando Hilo " + getName());
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(HilosVarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class HilosVarios2 extends Thread{
    
    public HilosVarios2(Thread hilo){
        
        this.hilo=hilo;
        
    }
    
    public void run(){
        
        try {
            hilo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(HilosVarios2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < 15; i++) {
            try {
                theView.anadir("Ejecutando Hilo " + getName());
                
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(HilosVarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private Thread hilo;
}
    
}
