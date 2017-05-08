package controleur;

import model.Tortue;
import view.Application;

import java.util.LinkedList;

/**
 * Created by lafay on 27/04/2017.
 */
public class ControleurTortues {

    ControlerManipTortue controleurParent;
    public LinkedList<Tortue> listeTortues = new LinkedList<Tortue>();

    public ControleurTortues(ControlerManipTortue parent) {
        controleurParent = parent;
        getListeTortues().add(parent.getTortueCourante());
    }

    public LinkedList<Tortue> getListeTortues() {
        return listeTortues;
    }

    /***
     * Ajoute une tortue sur la feuille de dessin
     */
    public void ajouterTortue() {
        Tortue tortue = new Tortue();
        getListeTortues().add(tortue);
        tortue.addObserver(Application.viewManipTortue);
    }

    /***
     * Change la tortue courante
     * @param positionX
     * @param positionY
     */
    public void setTortueSelectionne(int positionX, int positionY) {
        Tortue tortueASelectionner = controleurParent.getTortueCourante();

        for(Tortue tortue :listeTortues){
            if(tortue.getPosX() > positionX
                    && tortue.getPosX()< positionX+10
                    && tortue.getPosY()>positionY
                    && tortue.getPosY()< positionY+10){
                tortueASelectionner = tortue;
            }
        }
        controleurParent.setTortueCourante(tortueASelectionner);
    }
}
