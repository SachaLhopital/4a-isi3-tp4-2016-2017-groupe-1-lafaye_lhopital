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

        for (Tortue tortue : getListeTortues()) {

            int directionMoyenne = getDirectionMoyenne(tortue);
            int directionSeparation = getDirectionSeparation(tortue);
            int vitesseCohesion = getVitesseCohesion(tortue);

            tortue.setVitesse(tortue.getVitesse() + vitesseCohesion + directionSeparation + directionMoyenne);
            tortue.setDir(directionMoyenne);
            tortue.avancer(distance + vitesseCohesion);
        }

        //todo : duplicata avec Application
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    /***
     * Calcul la direction moyenne que la tortue doit suivre, en fonction de ses voisins
     * @return Direction moyenne (en degrée)
     */
    public int getDirectionMoyenne(Tortue tortueCourante) {

        int somme = 0;

        for(Tortue tortue : getListeTortues()) {
            if(tortue.equals(tortueCourante)) {
                //ne rien faire
            } else {
                somme += tortue.getDir();
            }
        }
        return somme / (getListeTortues().size() - 1);
    }

    /***
     * Calcul la direction à prendre pour ne pas rentrer en collision avec une autre tortue
     * @param tortueCourante
     * @return
     */
    public int getDirectionSeparation(Tortue tortueCourante) {

        int direction = 0;

        for(Tortue tortue : getListeTortues()) {

            if(tortue.equals(tortueCourante)) {
                //ne rien faire
            } else {
                int differenceDirection = tortueCourante.getDir() - tortue.getDir();
                if(Math.abs(differenceDirection) < Tortue.DISTANCE_SEPARATION) {
                    direction = direction - differenceDirection;
                }
            }
        }
        return direction;
    }

    /***
     * Récupère la vitesse de cohésion des tortues
     * @param tortueCourante
     * @return
     */
    public int getVitesseCohesion(Tortue tortueCourante) {

        int vitesse = 0;

        for(Tortue tortue : getListeTortues()) {
            if(tortue.equals(tortueCourante)) {
                //ne rien faire
            } else {
                vitesse = vitesse + tortue.getVitesse();
            }
        }

        vitesse = vitesse / (getListeTortues().size() - 1);
        return (vitesse - tortueCourante.getVitesse()) / 8;
    }
}
