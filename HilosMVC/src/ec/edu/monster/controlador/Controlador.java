
package ec.edu.monster.controlador;

import ec.edu.monster.modelo.ModeloPelota;
import ec.edu.monster.vista.VistaLaminaPelota;
import ec.edu.monster.vista.VistaMarcoRebote;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Controlador implements ActionListener {
    private VistaMarcoRebote marcoRebote;
    
    
    public Controlador(VistaMarcoRebote vista){
        this.marcoRebote=vista;
        this.marcoRebote.arranca1.addActionListener(this);
        this.marcoRebote.arranca2.addActionListener(this);
        this.marcoRebote.arranca3.addActionListener(this);
        this.marcoRebote.detener1.addActionListener(this);
        this.marcoRebote.detener2.addActionListener(this);
        this.marcoRebote.detener3.addActionListener(this);
        this.marcoRebote.lamina=new VistaLaminaPelota();
        this.marcoRebote.add(this.marcoRebote.lamina, BorderLayout.CENTER);

    }
    private void comienza_juego(ActionEvent e){
        boolean aux=false;
        
        if (e.getSource().equals(this.marcoRebote.arranca1)) {
            try{
                aux=t1.isInterrupted();
            }
            catch(Exception ex){
                aux=true;
            }
            if (aux) {
                ModeloPelota pelota = new ModeloPelota();
                this.marcoRebote.lamina.add(pelota);
                Runnable r = new PelotaHilos(pelota, this.marcoRebote.lamina);
                t1=new Thread(r);
                t1.start();
            }
            
        }else if(e.getSource().equals(this.marcoRebote.arranca2)){
            try{
                aux=t2.isInterrupted();
            }
            catch(Exception ex){
                aux=true;
            }
            if (aux) {
                ModeloPelota pelota = new ModeloPelota();
                this.marcoRebote.lamina.add(pelota);
                Runnable r = new PelotaHilos(pelota, this.marcoRebote.lamina);
                t2=new Thread(r);
                t2.start();
            }
        }else if(e.getSource().equals(this.marcoRebote.arranca3)){
            try{
                aux=t3.isInterrupted();
            }
            catch(Exception ex){
                aux=true;
            }
            if (aux) {
                ModeloPelota pelota = new ModeloPelota();
                this.marcoRebote.lamina.add(pelota);
                Runnable r = new PelotaHilos(pelota, this.marcoRebote.lamina);
                t3=new Thread(r);
                t3.start();
            }
        }
    }
    private void detener(ActionEvent e){
        if (e.getSource().equals(this.marcoRebote.detener1)) {
            t1.interrupt();
            t1=null;
        }else if(e.getSource().equals(this.marcoRebote.detener2)){
            t2.interrupt();
            t1=null;
        }else if(e.getSource().equals(this.marcoRebote.detener3)){
            t3.interrupt();
            t1=null;
        }
    }
    public void iniciar_vista(){
        
        marcoRebote.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoRebote.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent evento){
        if(this.marcoRebote.arranca1==evento.getSource())
            comienza_juego(evento);
        if(this.marcoRebote.arranca2==evento.getSource())
            comienza_juego(evento);
        if(this.marcoRebote.arranca3==evento.getSource())
            comienza_juego(evento);
        if(this.marcoRebote.detener1==evento.getSource())
            detener(evento);
        if(this.marcoRebote.detener2==evento.getSource())
            detener(evento);
        if(this.marcoRebote.detener3==evento.getSource())
            detener(evento);
    }
    Thread t1,t2,t3;
}
