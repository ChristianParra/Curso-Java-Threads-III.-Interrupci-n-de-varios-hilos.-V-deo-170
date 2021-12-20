
package ec.edu.monster.main;

import ec.edu.monster.controlador.Controlador;
import ec.edu.monster.vista.VistaMarcoRebote;

public class HilosMVC {

    public static void main(String[] args) {
        
        VistaMarcoRebote vista = new VistaMarcoRebote();
        Controlador controlador=new Controlador(vista);
        controlador.iniciar_vista();
    }
    
}
