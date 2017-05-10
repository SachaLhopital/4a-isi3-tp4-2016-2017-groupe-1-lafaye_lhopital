package controleur;

import model.Formes.Carre;
import model.Formes.Polygone;
import model.Formes.Spirale;
import model.Service.TracerFormeService;
import model.Tortue;
import view.Application;
import view.ViewTortueIndependante;

import java.util.LinkedList;

/**
 * Created by lafay on 27/04/2017.
 */
public class ControlerManipTortue {

    private static Tortue tortueCourante;
    public TracerFormeService formeService;

    public LinkedList<Tortue> listeTortues = new LinkedList<Tortue>();

    public ControlerManipTortue(){
        formeService = new TracerFormeService();
    }

    //Méthodes

    public void avancerTortue(int distance) {
        getTortueCourante().avancer(distance);
    }

    public void tournerTortueAGauche(int angle) {
        getTortueCourante().gauche(angle);
    }

    public void tournerTortueADroite(int angle) {
        getTortueCourante().droite(angle);
    }

    public void setCouleurTortue(Tortue.Colors couleur) {
        getTortueCourante().setColor(couleur);
    }

    public void tracerCarre() {
        getFormeService().doAction(getTortueCourante(), new Carre());
    }

    public void tracerSpiral() {
        getFormeService().doAction(getTortueCourante(), new Spirale());
    }

    public void tracerPolygone() {
        getFormeService().doAction(getTortueCourante(), new Polygone());
    }

    /***
     * Ajoute une tortue sur la feuille de dessin
     */
    public ViewTortueIndependante ajouterTortueEtGetVue() {
        Tortue tortue = new Tortue();
        getListeTortues().add(tortue);
        tortue.addObserver(Application.viewManipTortue);
        ControleurTortueIndependante controleurTortueIndependante = new ControleurTortueIndependante(tortue);

        return new ViewTortueIndependante(controleurTortueIndependante);


    }

    //Getters et Setters

    public TracerFormeService getFormeService() {
        return formeService;
    }

    public static Tortue getTortueCourante() {
        return tortueCourante;
    }

    public static void setTortueCourante(Tortue tortue){
        tortueCourante = tortue;
    }

    public LinkedList<Tortue> getListeTortues() {
        return listeTortues;
    }
}
