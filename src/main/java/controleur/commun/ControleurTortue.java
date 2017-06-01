package controleur.commun;

import model.Tortue;

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

    public void setTortueCourante() {
        controleurFeuilleDessin.setTortueCourante(tortue);
    }
}
