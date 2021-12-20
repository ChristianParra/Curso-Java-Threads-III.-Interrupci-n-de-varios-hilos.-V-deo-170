
package ec.edu.monster.vista;

import ec.edu.monster.modelo.ModeloPelota;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class VistaLaminaPelota extends JPanel {
    
    private ArrayList<ModeloPelota> pelotas = new ArrayList<ModeloPelota>();
    
    public void add(ModeloPelota b){
        pelotas.add(b);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for(ModeloPelota b: pelotas){
            g2.fill(b.getShape());
        }
    }
}
