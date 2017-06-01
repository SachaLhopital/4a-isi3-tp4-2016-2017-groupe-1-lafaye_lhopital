package controleur.commun;

import model.Tortue;
import vue.commun.VueFeuille;
import vue.commun.VueTortue;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lafay on 15/05/2017.
 */
public class ControleurFeuilleDessin {

    protected static final int DISTANCE_BASE = 10;

    List<Tortue> tortues;
    VueFeuille feuilleDessin = null;
    Tortue tortueCourrante = null;

    public ControleurFeuilleDessin(){
        tortues = new LinkedList<>();
    }

    //Getters & Setters

    public void setFeuilleDessin(VueFeuille applicationFrame){
        this.feuilleDessin = applicationFrame;
    }

    void setTortueCourante(Tortue tortue){
        this.tortueCourrante = tortue;
    }

    public List<Tortue> getTortues() {
        return tortues;
    }

    private VueFeuille getFeuilleDessin() {
        return feuilleDessin;
    }

    public Tortue getTortueCourrante() {
        return tortueCourrante;
    }

    //Méthodes

    /***
     * Ajoute une tortue sur la feuille de dessin
     * @param tortue
     */
    public void ajouterTortue(Tortue tortue){

        getTortues().add(tortue);

        ControleurTortue controleurTortue = new ControleurTortue(this, tortue);
        VueTortue vueTortue = new VueTortue(controleurTortue);
        tortue.addObserver(vueTortue);

        getFeuilleDessin().ajouterVueTortue(vueTortue);

        setTortueCourante(tortue);
    }

}
