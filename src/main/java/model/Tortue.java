package model;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import utils.Constantes;

import java.awt.*;
import java.util.Observable;

import static utils.Constantes.*;

/**
 * Created by lafay on 27/04/2017.
 */
public class Tortue extends Observable {

    int vitesse;
    int posX,posY;
    int dir;

    Color couleur = Color.GREEN;

    //Constructeurs

    public Tortue(){
        reset();
    }

    public Tortue(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        this.dir =0;

        setChanged();
        notifyObservers();
    }

    //Getters & Setters

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getDir() {
        return dir;
    }

    public Color getCouleur(){return this.couleur;}

    public void setPos(int posX, int posY){
        this.posX = posX;
        this.posY = posY;

        if(posX > Constantes.WIDTH){
            this.posX = posX - Constantes.WIDTH;
        }

        if(posX < 0){
            this.posX = posX + Constantes.WIDTH;
        }

        if(posY > Constantes.HEIGHT){
            this.posY = posY - Constantes.HEIGHT;
        }

        if(posY < 0){
            this.posY = posY + Constantes.HEIGHT;
        }

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

    public Point getLocalisation() {
        return new Point(getPosX(), getPosY());
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    // Méthodes

    public void reset(){

        //Coordonées aléatoires pour positionner la tortue
        posX = (int)(Math.random() * HEIGHT);
        posY = (int)(Math.random() * WIDTH);
        dir = (int)(Math.random() * DEGREES);
        vitesse = (int) (Math.random() * MAXIMUM_SPEED);

        setChanged();
        notifyObservers();
    }

    public void avancer(int distance) {
        int nouveauX = ((int) Math.round(getPosX()+distance*Math.cos(Math.toRadians(getDir()))));
        int nouveauY = ((int) Math.round(getPosY()+distance*Math.sin(Math.toRadians(getDir()))));

        setPos(nouveauX, nouveauY);
    }

    public void droite(int angle) {
        setDir((getDir()+angle));
    }

    public void gauche(int angle) {
        droite(-angle);
    }
}
