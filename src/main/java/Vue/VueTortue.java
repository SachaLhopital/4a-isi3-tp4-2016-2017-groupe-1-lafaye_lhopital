package Vue;

import Metier.ModeleTortue;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by lafay on 26/04/2017.
 */
public class VueTortue implements Observer{

    ModeleTortue tortue;
    VueFeuilleDessin vueFeuilleDessin;

    public VueTortue(ModeleTortue tortue, VueFeuilleDessin vueFeuilleDessin){
        this.tortue = tortue;
        this.vueFeuilleDessin = vueFeuilleDessin;
    }

    public void dessiner(Graphics graph){
        if (graph==null)
            return;

        /*// Dessine les segments
        for(Iterator it = listSegments.iterator(); it.hasNext();) {
            Tortue.Segment seg = (Tortue.Segment) it.next();
            seg.drawSegment(graph);
        }*/

        //Calcule les 3 coins du triangle a partir de
        // la position de la tortue p
        Point p = new Point(tortue.getPosX(),tortue.getPosY());
        Polygon arrow = new Polygon();

        //Calcule des deux bases
        //Angle de la droite
        double theta=Math.toRadians(-tortue.getDirection());
        //Demi angle au sommet du triangle
        double alpha=Math.atan( (float)tortue.rb / (float)tortue.rp );
        //Rayon de la fleche
        double r=Math.sqrt( tortue.rp*tortue.rp + tortue.rb*tortue.rb );
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
        graph.setColor(Color.green);
        graph.fillPolygon(arrow);
    }


    public void update(Observable o, Object arg) {
        dessiner(vueFeuilleDessin.getGraphics());
    }
}
