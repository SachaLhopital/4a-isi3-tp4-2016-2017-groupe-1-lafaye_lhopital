package controler;

import model.Tortue;
import view.TortueApplication;
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
public class ControlerFeuille extends JPanel {
    //todo : remove extends JPanel
        private JPanel panFeuille;

    ControlerMoveTurtle parent;
    public LinkedList<Tortue> listeTortues = new LinkedList<Tortue>();
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

        currentTurtle = tortue;
        getListeTortues().add(tortue);

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

    public LinkedList<Tortue> getListeTortues() {
        return listeTortues;
    }

    /***
     * Ajoute une tortue sur la feuille de dessin
     */
    public void ajouterTortue() {
        Tortue tortue = new Tortue();
        getListeTortues().add(tortue);
        tortue.addObserver(TortueApplication.viewMenu);
        repaint();
    }

    //todo remove
    public void addTortue(Tortue tortue){
        ajouterTortue();
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
             listeTortues) {
            ViewTortue.dessine(t,graph);
        }

    }

    public Tortue selectTurtle(int posX, int posY){
        for(Tortue t:listeTortues){
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
