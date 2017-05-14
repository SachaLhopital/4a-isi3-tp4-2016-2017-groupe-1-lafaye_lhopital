package view;

import controleur.ControleurTortueIndependante;
import model.Tortue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static utils.Constantes.DEGREES;
import static utils.Constantes.RB;
import static utils.Constantes.RP;

/**
 * Created by lafay on 10/05/2017.
 */
public class ViewTortueIndependante extends JComponent {

    public ViewTortueIndependante(ControleurTortueIndependante controleur) {

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                controleur.setTortueSelectionne();
            }
        });
    }


    /***
     * Dessine une tortue sur la feuille
     * @param tortue
     * @param graphe
     */
    public static void dessine(Tortue tortue, Graphics graphe) {
        //Calcule les 3 coins du triangle a partir de la position de la tortue p
        Point position = tortue.getLocalisation();
        Polygon fleche = new Polygon();

        //Calcule des deux bases
        //Angle de la droite
        double theta = Math.toRadians(-tortue.getDir());
        //Demi angle au sommet du triangle
        double alpha = Math.atan((float) RB / (float) RP);
        //Rayon de la fleche
        double rayon = Math.sqrt(RP * RP + RB * RB);
        //Sens de la fleche

        //Pointe
        Point pointe = new Point((int) Math.round(position.x + rayon * Math.cos(theta)),
                (int) Math.round(position.y - rayon * Math.sin(theta)));
        fleche.addPoint(pointe.x, pointe.y);
        fleche.addPoint((int) Math.round(pointe.x - rayon * Math.cos(theta + alpha)),
                (int) Math.round(pointe.y + rayon * Math.sin(theta + alpha)));

        //Base2
        fleche.addPoint((int) Math.round(pointe.x - rayon * Math.cos(theta - alpha)),
                (int) Math.round(pointe.y + rayon * Math.sin(theta - alpha)));

        fleche.addPoint(pointe.x, pointe.y);
        graphe.setColor(tortue.getCouleur());
        graphe.fillPolygon(fleche);
    }
}
