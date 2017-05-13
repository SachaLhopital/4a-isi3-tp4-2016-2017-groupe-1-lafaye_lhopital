package controleur;


import model.Tortue;
import view.Application;

/**
 * Created by lafay on 10/05/2017.
 */
public class ControlerFlockingTortue extends ControlerManipTortue {

    public static final int NOMBRES_TORTUES = 3;

    public ControlerFlockingTortue() {
        super();
    }

    public void run() {

        for(int i = 0; i < NOMBRES_TORTUES; i++) {
            Application.viewManipTortue.ajouterTortue();
        }

        while(true) {
            int distance = Application.viewManipTortue.getParametre();
            if(distance != 0) {
                avancerTortue(distance);
            }
        }
    }

    @Override
    public void avancerTortue(int distance) {
        int nouvelleDirection = getDirectionsTortues();
        for(Tortue tortue : getListeTortues()) {
            tortue.setDir(nouvelleDirection);
            tortue.avancer(distance);
        }

        //todo : duplicata
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    public int getDirectionsTortues() {
        int somme = 0;
        for(Tortue tortue : getListeTortues()) {
            somme += tortue.getDir();
        }
        return somme / getListeTortues().size();
    }
}
