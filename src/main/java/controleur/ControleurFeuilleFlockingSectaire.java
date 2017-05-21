package controleur;

import modele.Tortue;

import java.awt.*;

/**
 * Created by lafay on 17/05/2017.
 */
public class ControleurFeuilleFlockingSectaire extends ControleurFeuilleFlocking {

    private static int NB_TORTUESPARCOULEUR = 10;

    ControleurFeuilleFlockingSectaire(){
        super();
        this.démarrer();

    }

    public void ajouterToutesLesTortues() {
        for(int i = 0 ; i < NB_TORTUESPARCOULEUR; i++){
            Tortue tNoire = new Tortue();
            tNoire.setCouleur(Color.BLACK);
            ajouterTortue(tNoire);
            Tortue tRouge = new Tortue();
            tRouge.setCouleur(Color.RED);
            ajouterTortue(tRouge);
            Tortue tVerte = new Tortue();
            tVerte.setCouleur(Color.GREEN);
            ajouterTortue(tVerte);
            Tortue tBleue = new Tortue();
            tBleue.setCouleur(Color.BLUE);
            ajouterTortue(tBleue);
        }
    }

    protected boolean tortuesSontVoisines(Tortue tortue1, Tortue tortue2) {
        return tortue1.getCouleur().equals(tortue2.getCouleur()) && super.tortuesSontVoisines(tortue1, tortue2);
    }
}
