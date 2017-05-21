package controleur;

import model.Tortue;
import view.ViewTortue;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by lafay on 16/05/2017.
 */
public class ControleurTortue{

    Tortue tortue;
    ControleurFeuilleDessin controleurFeuilleDessin;

    public ControleurTortue(ControleurFeuilleDessin controleurFeuilleDessin, Tortue tortue){
        this.tortue = tortue;
        this.controleurFeuilleDessin = controleurFeuilleDessin;

    }

    public Tortue getTortue() {
        return tortue;
    }

    public void setCurrentTortue() {
        controleurFeuilleDessin.setTortueCourrante(tortue);
        System.out.println("Tortue selectionnée");
    }
}
