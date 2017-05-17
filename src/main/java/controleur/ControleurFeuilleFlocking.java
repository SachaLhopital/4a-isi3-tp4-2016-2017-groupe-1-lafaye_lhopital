package controleur;

import model.Tortue;

import java.awt.*;

/**
 * Created by lafay on 17/05/2017.
 */
public class ControleurFeuilleFlocking extends ControleurFeuilleAuto {

    private static int DISTANCE_SEPARATION = 10;
    private static final int NOMBRES_TORTUES = 13;
    private static int DISTANCE_VUE = 30;
    private static int DISTANCE = 10;

    public ControleurFeuilleFlocking(){
        super();
    }

    public void ajouterTortues() {
        for(int i = 0; i < NOMBRES_TORTUES; i++) {
            ajouterTortue(new Tortue());
        }
    }


    public void miseAJour(){
        for (Tortue tortue : getTortues()) {

            int directionMoyenne = getDirectionMoyenne(tortue);
            int directionSeparation = getDirectionSeparation(tortue);
            int vitesseCohesion = getVitesseCohesion(tortue);

            tortue.setVitesse(vitesseCohesion + tortue.getVitesse() + directionMoyenne + directionSeparation);
            tortue.setDir(directionMoyenne + directionSeparation);
            tortue.avancer(DISTANCE);
        }
    }

    /***
     * Calcul la direction moyenne que la tortue doit suivre, en fonction de ses voisins
     * @return Direction moyenne (en degrée)
     */
    public int getDirectionMoyenne(Tortue tortueCourante) {

        int somme = 0;
        int nombreVoisins = 0;

        for(Tortue tortue : getTortues()) {
            if(tortuesSontVoisines(tortueCourante, tortue)) {
                somme += tortue.getDir();
                nombreVoisins++;
            }
        }

        if(nombreVoisins == 0) {
            return tortueCourante.getDir();
        }

        return somme / nombreVoisins;
    }

    /***
     * Calcul la direction à prendre pour ne pas rentrer en collision avec une autre tortue
     * @param tortueCourante
     * @return
     */
    public int getDirectionSeparation(Tortue tortueCourante) {

        int direction = 0;

        for(Tortue tortue : getTortues()) {

            if(tortuesSontVoisines(tortueCourante, tortue)) {
                //TODO refactoring localisation !
                double differencePosition = getDistanceEuclidienne(tortue, tortueCourante);
                if(differencePosition < DISTANCE_SEPARATION) {
                    direction = direction - (int) differencePosition;
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

        int nombreVoisins = 0;
        int vitesse = 0;

        for(Tortue tortue : getTortues()) {
            if(tortuesSontVoisines(tortue, tortueCourante)) {
                vitesse += tortue.getVitesse();
                nombreVoisins++;
            }
        }

        if(nombreVoisins > 0) {
            vitesse = (vitesse/ nombreVoisins);
        }
        return (vitesse - tortueCourante.getVitesse()) / 8;
    }

    private double getDistanceEuclidienne(Tortue tortue1, Tortue tortue2) {
        Point point1 = tortue1.getLocalisation();
        Point point2 = tortue2.getLocalisation();
        return Math.abs(Math.sqrt(Math.pow((point1.x - point2.x), 2) + Math.pow((point1.y - point2.y), 2)));
    }

    private boolean tortuesSontVoisines(Tortue tortue1, Tortue tortue2) {
        if(tortue1.equals(tortue2)) {
            return false;
        }

        Point point1 = tortue1.getLocalisation();
        Point point2 = tortue2.getLocalisation();

        //Si leur distance euclidienne est inférieur à la distance de vue : elles sont voisines
        if(getDistanceEuclidienne(tortue1, tortue2) < DISTANCE_VUE) {
            return true;
        }
        return false;
    }
}
