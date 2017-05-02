package controler;

import model.Tortue;
import view.ViewTortue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by lafay on 27/04/2017.
 */
public class ControlerFeuille extends JPanel implements Observer{
        private JPanel panFeuille;

    ControlerMoveTurtle parent;
    public LinkedList<Tortue> tortues = new LinkedList<Tortue>();
    public Tortue currentTurtle;

    public ControlerFeuille(){

        panFeuille.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Tortue selected = selectTurtle(e.getX(),e.getY());
                currentTurtle=selected==null?selected:currentTurtle;
                parent.setCurrentTurlte(currentTurtle);

                System.out.println(e.paramString());
            }
        });
        panFeuille.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                Tortue selected = selectTurtle(e.getX(),e.getY());
                currentTurtle=selected==null?selected:currentTurtle;
                parent.setCurrentTurlte(currentTurtle);

                System.out.println(e.paramString());
            }
        });
    }

    public ControlerFeuille(ControlerMoveTurtle parent,Tortue tortue){

        this.addTortue(tortue);
        currentTurtle = tortue;
        this.parent = parent;

        this.setPreferredSize(new Dimension(Tortue.WIDTH,Tortue.HEIGHT));

        panFeuille.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Tortue selected = selectTurtle(e.getX(),e.getY());
                currentTurtle=selected==null?selected:currentTurtle;
                //parent.setCurrentTurlte(currentTurtle);

                System.out.println(e.paramString());
            }
        });
    }

    public void addTortue(Tortue tortue){
        this.tortues.add(tortue);
        tortue.addObserver(this);
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        drawTortues(graphics);
    }

    public void drawTortues(Graphics graph){

        if(graph == null){
            return;
        }
;

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

    public Tortue selectTurtle(int posX, int posY){
        for(Tortue t:tortues){
            if(t.getPosX()>posX && t.getPosX()< posX+10 && t.getPosY()>posY && t.getPosY()< posY+10){
                return t;
            }
        }
        return null;
    }

    public void update(Observable o, Object arg) {
        this.repaint();
    }
}
