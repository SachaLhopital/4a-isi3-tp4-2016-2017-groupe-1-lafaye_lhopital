package view;

import controleur.ControleurTortue;
import model.Tortue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * Created by lafay on 15/05/2017.
 */
public class ViewTortue extends AbstractButton {

    ControleurTortue controleurTortue;

    public ViewTortue(ControleurTortue controleurTortue){
        this.controleurTortue = controleurTortue;
        controleurTortue.setViewTortue(this);
        this.setVisible(true);
        this.setSize(20,20);
        this.setPreferredSize(this.getSize());

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controleurTortue.setCurrentTortue();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


    @Override
    public void paintComponent(Graphics g){
        Graphics2D graphics = (Graphics2D)g;
        Tortue tortue = controleurTortue.getTortue();

        this.setBounds(tortue.getPosX() - 10, tortue.getPosY() - 10, 20, 20);

        //dessine fleche
        graphics.setColor(Color.GREEN);

        //tourne la fleche
        //graphics.rotate(Math.toRadians(tortue.getDir()));


        //Calcule les 3 coins du triangle a partir de
        // la position de la tortue p
        Point p = new Point(10,10);
        Polygon arrow = new Polygon();

        //Calcule des deux bases
        //Angle de la droite
        double theta=Math.toRadians(-tortue.getDir());
        //Demi angle au sommet du triangle
        double alpha=Math.atan( (float)5 / (float)5 );
        //Rayon de la fleche
        double r=Math.sqrt( 5*5 + 5*5 );
        //Sens de la fleche

        //Pointe
        Point p2=new Point((int) Math.round(p.x+r*Math.cos(theta)),
                (int) Math.round(p.y-r*Math.sin(theta)));
        arrow.addPoint(p2.x,p2.y);
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta + alpha) ),
                (int) Math.round( p2.y+r*Math.sin(theta + alpha) ));

        //Base2
        arrow.addPoint((int) Math.round( p2.x-r*Math.cos(theta - alpha) ),
                (int) Math.round( p2.y+r*Math.sin(theta - alpha) ));

        arrow.addPoint(p2.x,p2.y);
        graphics.setColor(tortue.getCouleur());
        graphics.fillPolygon(arrow);
    }

}
