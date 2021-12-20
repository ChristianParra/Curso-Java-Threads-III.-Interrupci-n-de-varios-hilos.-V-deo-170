
package ec.edu.monster.controlador;

import ec.edu.monster.modelo.ModeloPelota;
import java.awt.*;

public class PelotaHilos implements Runnable {
    
    private ModeloPelota pelota;
    private Component componente;
    
    public PelotaHilos(ModeloPelota unaPelota, Component unComponente){
        pelota = unaPelota;
        componente = unComponente;
    }

    @Override
    public void run() {
        System.out.println("Estado del hilo al empezar: "+Thread.currentThread().isInterrupted());
        while(!Thread.currentThread().isInterrupted()){
            pelota.mueve_pelota(componente.getBounds());
            componente.paint(componente.getGraphics());
            try {
                Thread.sleep(4);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Estado del hilo al terminar: "+Thread.currentThread().isInterrupted());

    }
}
