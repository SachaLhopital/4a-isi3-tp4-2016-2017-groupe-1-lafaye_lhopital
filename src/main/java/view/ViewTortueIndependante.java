package view;

import controleur.ControleurTortueIndependante;
import model.Tortue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by lafay on 10/05/2017.
 */
public class ViewTortueIndependante extends JComponent {

    public ViewTortueIndependante(ControleurTortueIndependante controleur){

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
     * @param graph
     */
    public static void dessine(Tortue tortue, Graphics graph){
        //Calcule les 3 coins du triangle a partir de la position de la tortue p
        Point position = tortue.getLocalisation();
        Polygon arrow = new Polygon();

        //Calcule des deux bases
        //Angle de la droite
        double theta= Math.toRadians(-tortue.getDir());
        //Demi angle au sommet du triangle
        double alpha=Math.atan( (float)Tortue.RB / (float)Tortue.RP );
        //Rayon de la fleche
        double rayon=Math.sqrt( Tortue.RP*Tortue.RP + Tortue.RB*Tortue.RB );
        //Sens de la fleche

        //Pointe
        Point pointe = new Point((int) Math.round(position.x+rayon*Math.cos(theta)),
                (int) Math.round(position.y-rayon*Math.sin(theta)));
        arrow.addPoint(pointe.x,pointe.y);
        arrow.addPoint((int) Math.round( pointe.x-rayon*Math.cos(theta + alpha) ),
                (int) Math.round( pointe.y+rayon*Math.sin(theta + alpha) ));

        //Base2
        arrow.addPoint((int) Math.round( pointe.x-rayon*Math.cos(theta - alpha) ),
                (int) Math.round( pointe.y+rayon*Math.sin(theta - alpha) ));

        arrow.addPoint(pointe.x,pointe.y);
        graph.setColor(tortue.getColor());
        graph.fillPolygon(arrow);

        //setBounds(tortue.getPosX(),tortue.getPosY(),Tortue.RP,Tortue.RB);

    }

    public static int getAngle(Point target, Point origin) {
        float angle = (float) Math.toDegrees(Math.atan2(target.y - origin.y, target.x - origin.x));

        if(angle < 0){
            angle += 360;
        }

        return Math.round(angle);
    }
}
