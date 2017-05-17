package controleur;

import model.Tortue;
import view.ViewFeuille;
import view.ViewFeuilleAuto;
import view.ViewFeuilleFlocking;
import view.ViewFeuilleManuel;

/**
 * Created by lafay on 15/05/2017.
 */
public class ControleurSelectionMode {

    public void quitter(){
        System.exit(0);
    }

    public void lancerTortueManuelle(){

        ControleurFeuilleManuel ctrl = new ControleurFeuilleManuel();
        ViewFeuilleManuel app = new ViewFeuilleManuel(ctrl);

        app.setVisible(true);
        Tortue t = new Tortue(10,10);
        ctrl.ajouterTortue(t);

    }

    public void lancerTortueFlocking(){

        ControleurFeuilleFlocking ctrl = new ControleurFeuilleFlocking();
        ViewFeuilleFlocking app = new ViewFeuilleFlocking(ctrl);

        app.setVisible(true);
        Tortue t = new Tortue(10,10);
        ctrl.ajouterTortue(t);

    }

    public void lancerTortueAuto(){
        ControleurFeuilleAuto ctrl = new ControleurFeuilleAuto();
        ViewFeuilleAuto app = new ViewFeuilleAuto(ctrl);

        app.setVisible(true);
        Tortue t = new Tortue(10,10);
        ctrl.ajouterTortue(t);
    }
}
