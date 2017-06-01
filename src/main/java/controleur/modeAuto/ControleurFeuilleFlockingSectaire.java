package controleur.modeAuto;

import model.Tortue;

import java.awt.*;

/**
 * Created by lafay on 17/05/2017.
 */
public class ControleurFeuilleFlockingSectaire extends ControleurFeuilleFlocking {

    private static int NB_TORTUESPARCOULEUR = 10;

    public ControleurFeuilleFlockingSectaire(){
        super();
        démarrer();
    }

    @Override
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
}
