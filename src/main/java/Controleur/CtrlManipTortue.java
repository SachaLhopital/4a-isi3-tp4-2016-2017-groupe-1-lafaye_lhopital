package Controleur;

import Metier.ModeleTortue;
import Vue.FeuilleDessin;
import Vue.VueManipTortue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lafay on 26/04/2017.
 */
public class CtrlManipTortue implements ActionListener{

    ModeleTortue tortueCourante;
    VueManipTortue vueManipTortue;

    FeuilleDessin feuille;

    public CtrlManipTortue(VueManipTortue vueManipTortue){
        this.vueManipTortue = vueManipTortue;
        feuille = new FeuilleDessin();

    }


    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();

        // actions des boutons du haut
        if (c.equals("Avancer")) {
            System.out.println("command avancer");
            try {
                int v = Integer.parseInt(vueManipTortue.txtParametreAction.getText());
                tortueCourante.avancer(v);
            } catch (NumberFormatException ex){
                System.err.println("ce n'est pas un nombre : " + vueManipTortue.txtParametreAction.getText());
            }

        }
        else if (c.equals("Droite")) {
            try {
                int v = Integer.parseInt(vueManipTortue.txtParametreAction.getText());
                tortueCourante.droite(v);
            } catch (NumberFormatException ex){
                System.err.println("ce n'est pas un nombre : " + vueManipTortue.txtParametreAction.getText());
            }
        }
        else if (c.equals("Gauche")) {
            try {
                int v = Integer.parseInt(vueManipTortue.txtParametreAction.getText());
                tortueCourante.gauche(v);
            } catch (NumberFormatException ex){
                System.err.println("ce n'est pas un nombre : " + vueManipTortue.txtParametreAction.getText());
            }
        }
        else if (c.equals("Lever"))
            tortueCourante.leverCrayon();
        else if (c.equals("Baisser"))
            tortueCourante.baisserCrayon();
            // actions des boutons du bas
        else if (c.equals("Proc1"))
            proc1();
        else if (c.equals("Proc2"))
            proc2();
        else if (c.equals("Proc3"))
            proc3();
        else if (c.equals("Effacer"))
            effacer();
        else if (c.equals("Quitter"))
            quitter();

        feuille.repaint();
    }

    /** les procedures Logo qui combine plusieurs commandes..*/
    public void proc1() {
        tortueCourante.carre();
    }

    public void proc2() {
        tortueCourante.poly(60,8);
    }

    public void proc3() {
        tortueCourante.spiral(50,40,6);
    }

    // efface tout et reinitialise la feuille
    public void effacer() {
        feuille.reset();
        feuille.repaint();

        // Replace la tortue au centre
        Dimension size = feuille.getSize();
        tortueCourante.setPosition(size.width/2, size.height/2);
    }

    public void quitter(){
        System.exit(0);
    }
}

