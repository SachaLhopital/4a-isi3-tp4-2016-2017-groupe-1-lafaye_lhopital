package Metier;

import Vue.*;

import java.awt.*;
import java.util.Observable;

/**
 * Created by lafay on 26/04/2017.
 */
public class ModeleTortue extends Observable{
    int posX;
    int posY;
    int direction;
    int couleur; //TODO definir Objet couleur
    boolean isCrayonLeve;



    public static final int rp=10,rb=5;

    public ModeleTortue() {
        reset();
    }
    public void reset(){
        this.posX = 0;
        this.posY = 0;
        this.direction = 0;
        this.couleur = 0;

        notifyObservers();
    }

    public void setPosition(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        notifyObservers();
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
        notifyObservers();
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
        notifyObservers();
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
        notifyObservers();
    }

    public int getCouleur() {
        return couleur;
    }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
        notifyObservers();
    }

    public boolean isCrayonLeve() {
        return isCrayonLeve;
    }

    public void setCrayonLeve(boolean crayonLeve) {
        isCrayonLeve = crayonLeve;
    }

    public void avancer(int dist) {
        int newX = (int) Math.round(posX+dist*Math.cos(Math.toRadians(direction)));
        int newY = (int) Math.round(posY+dist*Math.sin(Math.toRadians(direction)));

        if (isCrayonLeve==true) {
            Segment seg = new Segment();

            seg.ptStart.x = posX;
            seg.ptStart.y = posY;
            seg.ptEnd.x = newX;
            seg.ptEnd.y = newY;
            seg.color = decodeColor(couleur);

            //listSegments.add(seg);
        }

        setPosX(newX);
        setPosY(newY);
    }

    public void droite(int ang) {
        direction = (direction + ang) % 360;
    }

    public void gauche(int ang) {
        direction = (direction - ang) % 360;
    }

    public void baisserCrayon() {
        isCrayonLeve = true;
    }

    public void leverCrayon() {
        isCrayonLeve = false;
    }

    protected Color decodeColor(int c) {
        switch(c) {
            case 0: return(Color.black);
            case 1: return(Color.blue);
            case 2: return(Color.cyan);
            case 3: return(Color.darkGray);
            case 4: return(Color.red);
            case 5: return(Color.green);
            case 6: return(Color.lightGray);
            case 7: return(Color.magenta);
            case 8: return(Color.orange);
            case 9: return(Color.gray);
            case 10: return(Color.pink);
            case 11: return(Color.yellow);
            default : return(Color.black);
        }
    }

    /** quelques classiques */

    public void carre() {
        for (int i=0;i<4;i++) {
            avancer(100);
            droite(90);
        }
    }

    public void poly(int n, int a) {
        for (int j=0;j<a;j++) {
            avancer(n);
            droite(360/a);
        }
    }

    public void spiral(int n, int k, int a) {
        for (int i = 0; i < k; i++) {
            setCouleur(couleur+1);
            avancer(n);
            droite(360/a);
            n = n+1;
        }
    }
}
