package controleur;

import modele.Tortue;
import vue.ViewFeuilleAuto;
import vue.ViewFeuilleFlocking;
import vue.ViewFeuilleManuel;

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

    public void lancerTortueFlockingSectaire() {
        ControleurFeuilleFlockingSectaire ctrl = new ControleurFeuilleFlockingSectaire();
        ViewFeuilleFlocking app = new ViewFeuilleFlocking(ctrl);

        app.setVisible(true);



    }
}
