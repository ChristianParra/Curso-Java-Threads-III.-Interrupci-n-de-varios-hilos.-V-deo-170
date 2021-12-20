/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.vista;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Jhon
 */
public class Vista extends JFrame{
    private JLabel titulo = new JLabel("Transacciones");
    private JTextArea texto = new JTextArea();
    
	
    public Vista(){

        JPanel panel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 400);
        texto.setSize(600,1000);
        panel.add(titulo);
        panel.add(texto);

        this.add(panel);

    }
	
    public void anadir(String texto){
        
        this.texto.setText(this.texto.getText()+"\n"+texto);
        //this.texto.setText(texto);
    }
}
