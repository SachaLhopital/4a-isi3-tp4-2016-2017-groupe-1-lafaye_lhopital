package controler;

import model.Tortue;
import view.ViewTortue;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by lafay on 27/04/2017.
 */
public class ControlerFeuille extends JPanel implements Observer{
        private JPanel panFeuille;

    public LinkedList<Tortue> tortues = new LinkedList<Tortue>();

    public ControlerFeuille(){

    }

    public ControlerFeuille(Tortue tortue){
        this.tortues.add(tortue);
        tortue.addObserver(this);
        tortue.setPos(this.getHeight()/2, this.getWidth()/2);
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        drawTortues(graphics);
    }

    public void drawTortues(Graphics graph){

        System.out.print("impression");
        if(graph == null){
            return;
        }

        System.out.print("netoyage");

        //nétoyage du graphique
        Color c = graph.getColor();

        Dimension dim = panFeuille.getSize();
        graph.setColor(Color.white);
        graph.fillRect(0,0,dim.width, dim.height);
        graph.setColor(c);

        //dessin des tortues
        for (Tortue t:
             tortues) {
            ViewTortue.dessine(t,graph);
        }

    }

    public void update(Observable o, Object arg) {
        System.out.println("Draw turtle");
        this.repaint();
        //drawTortues(this.getGraphics());

    }
}
