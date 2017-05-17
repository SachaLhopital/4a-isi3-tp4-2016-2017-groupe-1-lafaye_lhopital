package model;

import utils.Constantes;

import java.awt.*;
import java.util.Observable;

import static utils.Constantes.*;

/**
 * Created by lafay on 27/04/2017.
 */
public class Tortue extends Observable {

    int dir;
    int vitesse;
    Point position;

    Color couleur = Color.GREEN;

    //Constructeurs

    public Tortue(){
        reset();
    }

    public Tortue(int posX, int posY){
        position = new Point(posX, posY);
        this.dir =0;

        setChanged();
        notifyObservers();
    }

    //Getters & Setters

    public int getPosX() {
        return (int) position.getX();
    }

    public int getPosY() {
        return (int) position.getY();
    }

    public Point getPosition() {
        return position;
    }

    public int getDir() {
        return dir;
    }

    public Color getCouleur(){return this.couleur;}

    public int getVitesse() {
        return vitesse;
    }

    public void setPosition(int posX, int posY){
        int nouveauX = posX;
        int nouveauY = posY;

        if(posX > Constantes.WIDTH){
            nouveauX = posX - Constantes.WIDTH;
        }

        if(posX < 0){
            nouveauX = posX + Constantes.WIDTH;
        }

        if(posY > Constantes.HEIGHT){
            nouveauY = posY - Constantes.HEIGHT;
        }

        if(posY < 0){
            nouveauY = posY + Constantes.HEIGHT;
        }

        position = new Point(nouveauX, nouveauY);

        setChanged();
        notifyObservers();
    }

    public void setDir(int dir){
        this.dir = dir;

        if(dir> Constantes.DEGREES){
            this.dir = dir - Constantes.DEGREES;
        }

        if(dir < 0){
            this.dir = dir + Constantes.DEGREES;
        }

        setChanged();
        notifyObservers();
    }

    public void setCouleur(Color couleur){
        this.couleur = couleur;

        setChanged();
        notifyObservers();
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    // Méthodes

    public void reset(){
        dir = (int)(Math.random() * DEGREES);
        vitesse = (int)(Math.random() * MAXIMUM_SPEED);
        position = new Point((int)(Math.random() * HEIGHT), (int)(Math.random() * WIDTH));

        setChanged();
        notifyObservers();
    }

    public void avancer(int distance) {
        int nouveauX = ((int) Math.round(getPosX()+distance*Math.cos(Math.toRadians(getDir()))));
        int nouveauY = ((int) Math.round(getPosY()+distance*Math.sin(Math.toRadians(getDir()))));

        setPosition(nouveauX, nouveauY);
    }

    public void droite(int angle) {
        setDir((getDir()+angle));
    }

    public void gauche(int angle) {
        droite(-angle);
    }
}
