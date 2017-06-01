package controleur.modeAuto;

import controleur.commun.ControleurFeuilleDessin;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Classe abstraite pour les controleurs qui ne nécéssite pas de manipulation de la part de l'utilisateur
 * (controleurs qui se mettent à jour Automatiquement)
 * Created by Sachouw on 01/06/2017.
 */
public abstract class ControleurModeAuto extends ControleurFeuilleDessin {

    private static final int DELAI = 50;
    private static final int PERIODE = 50;

    public ControleurModeAuto() {
        super();

        Timer timer = new Timer();
        TimerTask myTask = new TimerTask() {
            @Override
            public void run() {
                miseAJour();
            }
        };

        timer.schedule(myTask, DELAI, PERIODE);
    }

    public abstract void miseAJour();
}
