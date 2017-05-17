package controleur;

import model.Tortue;
import view.ViewFeuille;
import view.ViewTortue;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lafay on 15/05/2017.
 */
public class ControleurFeuilleDessin {

    List<Tortue> tortues;
    ViewFeuille feuilleDessin = null;
    Tortue tortueCourrante = null;

    ControleurFeuilleDessin(){
        this.tortues = new LinkedList<>();
    }

    //Getters & Setters

    public void setFeuilleDessin(ViewFeuille applicationFrame){
        this.feuilleDessin = applicationFrame;
    }

    private void setTortueCourrante(Tortue tortue){
        this.tortueCourrante = tortue;
    }

    List<Tortue> getTortues() {
        return tortues;
    }

    private ViewFeuille getFeuilleDessin() {
        return feuilleDessin;
    }

    //Méthodes

    /***
     * Ajoute une tortue sur la feuille de dessin
     * @param tortue
     */
    public void ajouterTortue(Tortue tortue){

        getTortues().add(tortue);

        ControleurTortue controleurTortue = new ControleurTortue(this, tortue);
        ViewTortue viewTortue = new ViewTortue(controleurTortue);

        getFeuilleDessin().ajouterVueTortue(viewTortue);

        setTortueCourrante(tortue);
    }

}
