package controleur;

import model.Tortue;
import view.ViewFeuille;
import view.Forms.ViewTortue;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lafay on 15/05/2017.
 */
public class ControleurFeuilleDessin {

    List<Tortue> tortues;
    ViewFeuille feuilleDessin = null;
    Tortue tortueCourrante = null;

    public ControleurFeuilleDessin(){
        this.tortues = new LinkedList<>();
    }

    //Getters & Setters

    public void setFeuilleDessin(ViewFeuille applicationFrame){
        this.feuilleDessin = applicationFrame;
    }

    public void setTortueCourrante(Tortue tortue){
        this.tortueCourrante = tortue;
    }

    public List<Tortue> getTortues() {
        return tortues;
    }

    public void setTortues(List<Tortue> tortues) {
        this.tortues = tortues;
    }

    public ViewFeuille getFeuilleDessin() {
        return feuilleDessin;
    }

    public Tortue getTortueCourrante() {
        return tortueCourrante;
    }

    //Méthodes

    public void ajouterTortue(Tortue tortue){

        tortues.add(tortue);

        ControleurTortue controleurTortue = new ControleurTortue(this,tortue);
        ViewTortue viewTortue = new ViewTortue(controleurTortue);

        feuilleDessin.addTortue(viewTortue);

        tortueCourrante = tortue;

    }

}
