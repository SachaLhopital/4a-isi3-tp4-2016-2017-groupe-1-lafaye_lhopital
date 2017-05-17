package controleur;

import model.Tortue;
import utils.Constantes;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lafay on 16/05/2017.
 */
public class ControleurFeuilleAuto extends ControleurFeuilleDessin {

    private ControleurFeuilleAuto controleurFeuilleAuto;

    ControleurFeuilleAuto(){
        super();
        controleurFeuilleAuto = this;
        Timer timer = new Timer();
        TimerTask myTask = new TimerTask() {
            @Override
            public void run() {
                controleurFeuilleAuto.miseAJour();
            }
        };

        timer.schedule(myTask, 50, 50);
    }

    public void ajouter(){
        Tortue t = new Tortue(new Random().nextInt(Constantes.WIDTH),new Random().nextInt(Constantes.HEIGHT));
        this.ajouterTortue(t);
    }

    public void  miseAJour(){
        for(Tortue tortue:this.tortues){
            tortue.avancer(10 );
            tortue.droite(new Random().nextInt(Constantes.DEGREES/2));
            tortue.gauche(new Random().nextInt(Constantes.DEGREES/2));
        }
    }

}
