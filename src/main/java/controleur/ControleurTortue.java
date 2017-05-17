package controleur;

import model.Tortue;
import view.ViewTortue;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by lafay on 16/05/2017.
 */
public class ControleurTortue implements Observer{
    private Tortue tortue;
    private ViewTortue viewTortue;
    private ControleurFeuilleDessin controleurFeuilleDessin;

    public ControleurTortue(ControleurFeuilleDessin controleurFeuilleDessin, Tortue tortue){
        this.tortue = tortue;
        this.tortue.addObserver(this);
        this.controleurFeuilleDessin = controleurFeuilleDessin;

    }


    @Override
    public void update(Observable o, Object arg) {
        viewTortue.repaint();
    }

    public void setViewTortue(ViewTortue viewTortue){
        this.viewTortue = viewTortue;
        this.viewTortue.repaint();
    }
    public Tortue getTortue() {
        return tortue;
    }

    public void setCurrentTortue() {
        controleurFeuilleDessin.setTortueCourrante(tortue);

        System.out.println("Tortue selectionnée");

    }
}
