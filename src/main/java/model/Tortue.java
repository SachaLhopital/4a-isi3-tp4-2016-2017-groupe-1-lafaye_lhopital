package model;

import java.awt.*;
import java.util.Observable;
import java.util.Random;

/**
 * Created by lafay on 27/04/2017.
 */
public class Tortue extends Observable {

    public static final int HEIGHT = 400;
    public static final int WIDTH = 500;
    private static int DEGREES = 360;
    private static int MAXIMUM_SPEED = 5;

    int dir;
    int vitesse;
    Point position;
    Color couleur = Color.GREEN;

    public Tortue(){
        resetInRandomPosition();
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

        if(posX > WIDTH){
            nouveauX = posX - WIDTH;
        }

        if(posX < 0){
            nouveauX = posX + WIDTH;
        }

        if(posY > HEIGHT){
            nouveauY = posY - HEIGHT;
        }

        if(posY < 0){
            nouveauY = posY + HEIGHT;
        }

        position = new Point(nouveauX, nouveauY);

        setChanged();
        notifyObservers();
    }

    public void setDirection(int direction){
        this.dir = direction;

        if(direction > DEGREES){
            this.dir = direction - DEGREES;
        }

        if(direction < 0){
            this.dir = direction + DEGREES;
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

    public void resetInRandomPosition(){
        Random rand = new Random();
        dir = rand.nextInt(DEGREES);
        vitesse = rand.nextInt(MAXIMUM_SPEED);
        setPosition(rand.nextInt(WIDTH),rand.nextInt(HEIGHT));
    }

    public void avancer(int distance) {
        int nouveauX = ((int) Math.round(getPosX()+distance*Math.cos(Math.toRadians(getDir()))));
        int nouveauY = ((int) Math.round(getPosY()+distance*Math.sin(Math.toRadians(getDir()))));

        setPosition(nouveauX, nouveauY);
    }

    public void droite(int angle) {
        setDirection((getDir()+angle));
    }

    public void gauche(int angle) {
        droite(-angle);
    }
}
