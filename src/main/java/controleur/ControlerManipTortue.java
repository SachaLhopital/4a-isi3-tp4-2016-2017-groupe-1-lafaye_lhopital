package controleur;

import model.Formes.Carre;
import model.Formes.Polygone;
import model.Formes.Spirale;
import model.Service.TracerFormeService;
import model.Tortue;

/**
 * Created by lafay on 27/04/2017.
 */
public class ControlerManipTortue {

    public Tortue tortueCourante;
    public TracerFormeService formeService;

    public ControlerManipTortue(Tortue tortue){
        tortueCourante = tortue;
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

    //Getters et Setters

    public TracerFormeService getFormeService() {
        return formeService;
    }

    public Tortue getTortueCourante() {
        return tortueCourante;
    }

    public void setTortueCourante(Tortue turtle){
        this.tortueCourante = turtle;
    }
}
