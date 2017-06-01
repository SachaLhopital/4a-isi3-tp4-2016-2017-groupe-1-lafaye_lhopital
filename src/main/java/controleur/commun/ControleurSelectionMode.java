package controleur.commun;

import controleur.modeAuto.ControleurFeuilleAuto;
import controleur.modeAuto.ControleurFeuilleFlocking;
import controleur.modeAuto.ControleurFeuilleFlockingSectaire;
import controleur.modeManuel.ControleurFeuilleManuel;
import model.Tortue;
import vue.vuesAuto.VueFeuilleAuto;
import vue.vuesAuto.VueFeuilleFlocking;
import vue.vuesManuelle.VueFeuilleManuel;

/**
 * Created by lafay on 15/05/2017.
 */
public class ControleurSelectionMode {

    private static final int POSITION_INITIALE = 10;

    public void quitter(){
        System.exit(0);
    }

    public void lancerTortueManuelle(){

        ControleurFeuilleManuel ctrl = new ControleurFeuilleManuel();
        VueFeuilleManuel app = new VueFeuilleManuel(ctrl);

        app.setVisible(true);
        Tortue t = new Tortue(POSITION_INITIALE,POSITION_INITIALE);
        ctrl.ajouterTortue(t);

    }

    public void lancerTortueFlocking(){

        ControleurFeuilleFlocking ctrl = new ControleurFeuilleFlocking();
        VueFeuilleFlocking app = new VueFeuilleFlocking(ctrl);

        app.setVisible(true);
        Tortue t = new Tortue(POSITION_INITIALE,POSITION_INITIALE);
        ctrl.ajouterTortue(t);

    }

    public void lancerTortueAuto(){
        ControleurFeuilleAuto ctrl = new ControleurFeuilleAuto();
        VueFeuilleAuto app = new VueFeuilleAuto(ctrl);

        app.setVisible(true);
    }

    public void lancerTortueFlockingSectaire() {
        ControleurFeuilleFlockingSectaire ctrl = new ControleurFeuilleFlockingSectaire();
        VueFeuilleFlocking app = new VueFeuilleFlocking(ctrl);

        app.setVisible(true);
    }
}
