package view;

import controleur.ControleurFeuilleFlocking;

/**
 * Created by lafay on 17/05/2017.
 */
public class ViewFeuilleFlocking extends ViewFeuille {
    public ViewFeuilleFlocking(ControleurFeuilleFlocking controleurFeuilleDessin) {

        super(controleurFeuilleDessin);
        controleurFeuilleDessin.ajouterTortues();
    }
}
