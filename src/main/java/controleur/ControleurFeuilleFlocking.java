package controleur;

import model.Tortue;

import java.awt.*;

/**
 * Created by lafay on 17/05/2017.
 */
public class ControleurFeuilleFlocking extends ControleurFeuilleAuto {

    private static int DISTANCE_DEPLACEMENT = 10;
    private static int DISTANCE_SEPARATION = 10;
    private static int DISTANCE_VUE = 30;
    public static final int NOMBRES_TORTUES_BASE = 13;

    private boolean enRoute = false;

    ControleurFeuilleFlocking(){
        super();
    }

    public void ajouterToutesLesTortues() {
        for(int i = 0; i < NOMBRES_TORTUES_BASE; i++) {
            ajouterTortue(new Tortue());
        }
    }

    /***
     * Déplace les tortues selon le flocking
     */
    public void miseAJour(){
        if(!enRoute){
            return;
        }

        for (Tortue tortue : getTortues()) {

            int directionMoyenne = getDirectionMoyenne(tortue);
            int directionSeparation = getDirectionSeparation(tortue);
            int vitesseCohesion = getVitesseCohesion(tortue);

            tortue.setVitesse(tortue.getVitesse() + vitesseCohesion + directionMoyenne + directionSeparation);
            tortue.setDir(directionMoyenne + directionSeparation);
            tortue.avancer(DISTANCE_DEPLACEMENT);
        }
    }

    /***
     * Calcul la direction moyenne que la tortue doit suivre, en fonction de ses voisins
     * @return Direction moyenne (en degrée)
     */
    private int getDirectionMoyenne(Tortue tortueCourante) {

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
    private int getDirectionSeparation(Tortue tortueCourante) {

        int direction = 0;

        for(Tortue tortue : getTortues()) {

            if(tortuesSontVoisines(tortueCourante, tortue)) {

                double differencePosition = getDistanceEuclidienne(tortueCourante.getPosition(), tortue.getPosition());
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
    private int getVitesseCohesion(Tortue tortueCourante) {

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

    /***
     * Calcul la distance Euclidienne entre deux points
     * @param point1
     * @param point2
     * @return
     */
    private double getDistanceEuclidienne(Point point1, Point point2) {
        return Math.abs(Math.sqrt(Math.pow((point1.getX() - point2.getX()), 2) + Math.pow((point1.getY() - point2.getY()), 2)));
    }

    /***
     * Vérifie si deux tortues sont voisines
     * (Attention, si la même tortue est passé en paramètre 2 fois, on retourne faux)
     * @param tortue1
     * @param tortue2
     * @return
     */
    protected boolean tortuesSontVoisines(Tortue tortue1, Tortue tortue2) {
        if(tortue1.equals(tortue2)) {
            return false;
        }

        //Si leur distance euclidienne est inférieur à la distance de vue : elles sont voisines
        if(getDistanceEuclidienne(tortue1.getPosition(), tortue2.getPosition()) < DISTANCE_VUE) {
            return true;
        }
        return false;
    }

    public void démarrer(){
        enRoute = true;
    }
}
