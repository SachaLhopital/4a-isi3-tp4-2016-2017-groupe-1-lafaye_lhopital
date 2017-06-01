package controleur.modeManuel;

import controleur.commun.ControleurFeuilleDessin;

import java.awt.*;

/**
 * Created by lafay on 16/05/2017.
 */
public class ControleurFeuilleManuel extends ControleurFeuilleDessin {

    public void avancer(int distance){
        getTortueCourrante().avancer(distance);
    }

    public void droite(int angle){
        getTortueCourrante().droite(angle);
    }

    public void gauche(int angle){
        getTortueCourrante().gauche(angle);
    }

    public void changerCouleur(Color couleur){
        getTortueCourrante().setCouleur(couleur);
    }
}
