package controleur;

import model.Tortue;
import view.ViewTortueIndependante;

/**
 * Created by lafay on 10/05/2017.
 */
public class ControleurTortueIndependante {

    Tortue tortue;

    public ControleurTortueIndependante(Tortue tortue){
        this.tortue = tortue;
        ControlerManipTortue.setTortueCourante(tortue);


    }

    public void setTortueSelectionne() {
        ControlerManipTortue.setTortueCourante(tortue);
    }
}
