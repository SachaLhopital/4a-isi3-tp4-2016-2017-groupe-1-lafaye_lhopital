package controleur;

import model.Tortue;
import utils.Constantes;

import javax.swing.*;
import java.util.Random;

/**
 * Created by lafay on 16/05/2017.
 */
public class ControleurFeuilleManuel extends ControleurFeuilleDessin{



    public void avancer(int distance){
        this.tortueCourrante.avancer(distance);
    }

    public void droite(int angle){
        this.tortueCourrante.droite(angle);
    }

    public void gauche(int angle){
        this.tortueCourrante.gauche(angle);
    }

    public void ajouter(){
        Tortue t = new Tortue(new Random().nextInt(Constantes.WIDTH),new Random().nextInt(Constantes.HEIGHT));
        this.ajouterTortue(t);
    }

}
