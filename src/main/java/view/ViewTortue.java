package view;

import controleur.ControleurTortue;
import model.Tortue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;


/**
 * Created by lafay on 15/05/2017.
 */
public class ViewTortue extends AbstractButton implements Observer {

    private static final int TAILLE_FENETRE = 20;
    private static final int CORRECTEUR_COORDONNES = 10;
    private static final int VALEUR_ARC_TANGANTE = 5;

    ControleurTortue controleurTortue;

    public ViewTortue(ControleurTortue controleurTortue){

        this.controleurTortue = controleurTortue;
        setVisible(true);
        setSize(TAILLE_FENETRE,TAILLE_FENETRE);
        setPreferredSize(this.getSize());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controleurTortue.setCurrentTortue();
            }
        });
    }

    @Override
    public void paint(Graphics g){
        Graphics2D graphics = (Graphics2D)g;
        Tortue tortue = controleurTortue.getTortue();

        setBounds(tortue.getPosX() - CORRECTEUR_COORDONNES,
                tortue.getPosY() - CORRECTEUR_COORDONNES,
                TAILLE_FENETRE,
                TAILLE_FENETRE);

        //dessine fleche
        graphics.setColor(Color.GREEN);

        //Calcule les 3 coins du triangle a partir de
        // la position de la tortue
        Point position = new Point(CORRECTEUR_COORDONNES,CORRECTEUR_COORDONNES);
        Polygon fleche = new Polygon();

        //Calcule des deux bases
        //Angle de la droite
        double theta=Math.toRadians(-tortue.getDir());
        //Demi angle au sommet du triangle
        double alpha=Math.atan((float) VALEUR_ARC_TANGANTE / (float) VALEUR_ARC_TANGANTE );
        //Rayon de la fleche
        double r=Math.sqrt(VALEUR_ARC_TANGANTE*VALEUR_ARC_TANGANTE
                + VALEUR_ARC_TANGANTE*VALEUR_ARC_TANGANTE);

        //Pointe
        Point pointe = new Point((int) Math.round(position.getX()+r*Math.cos(theta)),
                (int) Math.round(position.getY()-r*Math.sin(theta)));
        fleche.addPoint(pointe.x,pointe.y);
        fleche.addPoint((int) Math.round( pointe.x-r*Math.cos(theta + alpha) ),
                (int) Math.round( pointe.y+r*Math.sin(theta + alpha) ));

        //Base2
        fleche.addPoint((int) Math.round( pointe.x-r*Math.cos(theta - alpha) ),
                (int) Math.round( pointe.y+r*Math.sin(theta - alpha) ));

        fleche.addPoint(pointe.x,pointe.y);
        graphics.setColor(tortue.getCouleur());
        graphics.fillPolygon(fleche);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
