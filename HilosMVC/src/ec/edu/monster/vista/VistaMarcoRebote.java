
package ec.edu.monster.vista;

import ec.edu.monster.modelo.ModeloPelota;
import java.awt.*;
import javax.swing.*;

public class VistaMarcoRebote extends JFrame{
    
    
    public JButton arranca1, arranca2, arranca3, detener1, detener2, detener3;
    public JPanel laminaBotones;
    public VistaLaminaPelota lamina;
    
    public void ponerBoton(Container c, String titulo, JButton button){
        button = new JButton(titulo);
        c.add(button);
    }
    public VistaLaminaPelota anadirPelota(ModeloPelota pelota){
        
        return lamina;
    }
    
    public VistaMarcoRebote(){
        setBounds(600,300,600,350);
        setTitle("Rebotes");
        laminaBotones = new JPanel();
        arranca1=new JButton("Hilo 1");
        arranca2=new JButton("Hilo 2");
        arranca3=new JButton("Hilo 3");
        detener1=new JButton("Detener 1");
        detener2=new JButton("Detener 2");
        detener3=new JButton("Detener 3");
        laminaBotones.add(arranca1);
        laminaBotones.add(arranca2);
        laminaBotones.add(arranca3);
        laminaBotones.add(detener1);
        laminaBotones.add(detener2);
        laminaBotones.add(detener3);
        add(laminaBotones, BorderLayout.SOUTH);
       
    }
}
