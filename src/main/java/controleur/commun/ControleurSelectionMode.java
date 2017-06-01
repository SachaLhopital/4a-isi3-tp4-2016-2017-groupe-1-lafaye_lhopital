package controleur.commun;

import controleur.modeAuto.ControleurFeuilleAuto;
import controleur.modeAuto.ControleurFeuilleFlocking;
import controleur.modeAuto.ControleurFeuilleFlockingSectaire;
import controleur.modeManuel.ControleurFeuilleManuel;
import model.Tortue;
import view.vuesAuto.ViewFeuilleAuto;
import view.vuesAuto.ViewFeuilleFlocking;
import view.vuesManuelle.ViewFeuilleManuel;

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
        ViewFeuilleManuel app = new ViewFeuilleManuel(ctrl);

        app.setVisible(true);
        Tortue t = new Tortue(POSITION_INITIALE,POSITION_INITIALE);
        ctrl.ajouterTortue(t);

    }

    public void lancerTortueFlocking(){

        ControleurFeuilleFlocking ctrl = new ControleurFeuilleFlocking();
        ViewFeuilleFlocking app = new ViewFeuilleFlocking(ctrl);

        app.setVisible(true);
        Tortue t = new Tortue(POSITION_INITIALE,POSITION_INITIALE);
        ctrl.ajouterTortue(t);

    }

    public void lancerTortueAuto(){
        ControleurFeuilleAuto ctrl = new ControleurFeuilleAuto();
        ViewFeuilleAuto app = new ViewFeuilleAuto(ctrl);

        app.setVisible(true);
    }

    public void lancerTortueFlockingSectaire() {
        ControleurFeuilleFlockingSectaire ctrl = new ControleurFeuilleFlockingSectaire();
        ViewFeuilleFlocking app = new ViewFeuilleFlocking(ctrl);

        app.setVisible(true);
    }
}
