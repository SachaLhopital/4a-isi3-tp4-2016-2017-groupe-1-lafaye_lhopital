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

    public void setFeuilleDessin(ViewFeuille applicationFrame){
        this.feuilleDessin = applicationFrame;
    }

    public void ajouterTortue(Tortue tortue){

        tortues.add(tortue);

        ControleurTortue controleurTortue = new ControleurTortue(this,tortue);
        ViewTortue viewTortue = new ViewTortue(controleurTortue);

        feuilleDessin.addTortue(viewTortue);

        tortueCourrante = tortue;

    }

    public void setTortueCourrante(Tortue tortue){
        this.tortueCourrante = tortue;
    }

}
