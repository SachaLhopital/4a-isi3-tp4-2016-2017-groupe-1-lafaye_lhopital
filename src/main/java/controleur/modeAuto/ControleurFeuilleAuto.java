package controleur.modeAuto;

import model.Tortue;

import java.util.Random;

/**
 * Created by lafay on 16/05/2017.
 */
public class ControleurFeuilleAuto extends ControleurModeAuto {

    private static int DEGREES = 360;

    public ControleurFeuilleAuto(){
        super();
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
                    //ne rien faire : la tortue avance tout droit
            }
        }
    }
}
