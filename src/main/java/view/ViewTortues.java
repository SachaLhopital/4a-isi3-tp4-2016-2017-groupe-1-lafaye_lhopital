package view;

import controleur.ControleurTortues;
import model.Tortue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by lafay on 27/04/2017.
 */
public class ViewTortues extends JPanel {

    private ControleurTortues controleur;
    private JPanel panFeuille;

    public ViewTortues(ControleurTortues controleurF) {

        controleur = controleurF;

        setPreferredSize(new Dimension(Tortue.WIDTH,Tortue.HEIGHT));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                controleur.setTortueSelectionne(e.getX(), e.getY());
            }
        });
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        if(graphics == null){
            return;
        }

        //nettoyage du graphique
        Color c = graphics.getColor();

        Dimension dim = panFeuille.getSize();
        graphics.setColor(Color.white);
        graphics.fillRect(0,0,dim.width, dim.height);
        graphics.setColor(c);

        //dessin des tortues
        for (Tortue t: controleur.getListeTortues()) {
            ViewTortues.dessine(t,graphics);
        }
    }

    /***
     * Dessine une tortue sur la feuille
     * @param tortue
     * @param graph
     */
    public static void dessine(Tortue tortue, Graphics graph){
        //Calcule les 3 coins du triangle a partir de la position de la tortue p
        Point position = new Point(tortue.getPosX(),tortue.getPosY());
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
        Point pointe=new Point((int) Math.round(position.x+rayon*Math.cos(theta)),
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
    }
}
