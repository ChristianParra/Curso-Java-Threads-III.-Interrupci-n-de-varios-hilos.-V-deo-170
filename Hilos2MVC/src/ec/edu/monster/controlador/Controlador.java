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

        Banco b=new Banco();
        for (int i = 0; i < 100; i++) {
            EjecucionTransferencia r=new EjecucionTransferencia(b, i, 2000);
            Thread t= new Thread(r);
            t.start();
        }
    }

    class Banco{
    
        public Banco(){
            cuentas=new double[100];
            for (int i = 0; i < cuentas.length; i++) {
                cuentas[i]=2000;
            }
            //saldoSuficiente=cierreBanco.newCondition();
        }
    
        public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException{
            while (cuentas[cuentaOrigen]<cantidad) {
                wait(); //el resto de hilos esperan
            }
            System.out.println(Thread.currentThread());

            cuentas[cuentaOrigen]-=cantidad; //dinero que sale de la cuenta origen
            theView.anadir(cantidad+" de "+ cuentaOrigen + " para "+cuentaDestino);
            cuentas[cuentaDestino]+=cantidad;
            
            theView.anadir(" Saldo Total: "+getSaldoTotal());

            notifyAll(); //informar a los hilos

        }
        public double getSaldoTotal(){
            double suma_cuentas=0;
            for (double a: cuentas) {
                suma_cuentas+=a;
            }
            return suma_cuentas;
        }
    
    private final double[] cuentas;
}

class EjecucionTransferencia implements Runnable{

    public EjecucionTransferencia(Banco b, int de, double max){
        banco=b;
        deLaCuenta=de;
        cantidadMax=max;
    }
    
    @Override
    public void run() {
        try {
            while(true){
                int paraLaCuenta = (int)(100*Math.random());
                double cantidad = cantidadMax*Math.random();
                banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);

                Thread.sleep(5000);
            
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(EjecucionTransferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Banco banco;
    private int deLaCuenta;
    private double cantidadMax;
    
}
}
