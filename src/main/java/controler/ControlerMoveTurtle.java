package controler;

import model.ActionCarre;
import model.ActionPolygone;
import model.ActionSpiral;
import model.Tortue;

/**
 * Created by lafay on 27/04/2017.
 */
public class ControlerMoveTurtle {

    public Tortue tortueCourante;

    public ControlerMoveTurtle(Tortue tortue){
        tortueCourante = tortue;
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
        new ActionCarre().doAction(getTortueCourante());
    }

    public void tracerSpiral() {
        new ActionSpiral().doAction(getTortueCourante());
    }

    public void tracerPolygone() {
        new ActionPolygone().doAction(getTortueCourante());
    }

    //Getters et Setters

    public Tortue getTortueCourante() {
        return tortueCourante;
    }

    public void setCurrentTurlte(Tortue turtle){
        this.tortueCourante = turtle;
    }
}
