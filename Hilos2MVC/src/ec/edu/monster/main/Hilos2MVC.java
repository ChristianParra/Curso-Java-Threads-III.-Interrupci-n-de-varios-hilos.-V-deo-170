
package ec.edu.monster.main;
import ec.edu.monster.vista.Vista;
import ec.edu.monster.modelo.Modelo;
import ec.edu.monster.controlador.Controlador;

public class Hilos2MVC {

    public static void main(String[] args) {
        Vista theView = new Vista();
        Modelo theModel = new Modelo();
        Controlador theController = new Controlador(theView,theModel);
        theView.setVisible(true);

    }
    
}
