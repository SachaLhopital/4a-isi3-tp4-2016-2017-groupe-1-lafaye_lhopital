package controleur;

import model.Tortue;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lafay on 16/05/2017.
 */
public class ControleurFeuilleAuto extends ControleurFeuilleDessin {

    private static int DEGREES = 360;
    private static final int DELAI = 50;
    private static final int PERIODE = 50;
    protected static final int DISTANCE_BASE = 10;

    ControleurFeuilleAuto(){
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

    public void ajouter(){
        Tortue t = new Tortue();
        ajouterTortue(t);
    }

    public void miseAJour(){
        for(Tortue tortue: getTortues()){

            tortue.avancer(DISTANCE_BASE);

            switch((int) (Math.random() * 2)) {
                case 1 :
                    tortue.droite(new Random().nextInt(DEGREES/2));
                    break;
                case 2 :
                    tortue.gauche(new Random().nextInt(DEGREES/2));
                    break;
                default:
                    //ne rien faire : la tortue avancera tout droit
            }
        }
    }

}
