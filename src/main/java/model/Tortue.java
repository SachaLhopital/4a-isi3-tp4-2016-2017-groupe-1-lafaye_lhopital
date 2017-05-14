package model;

import java.awt.*;
import java.util.Observable;

/**
 * Created by lafay on 27/04/2017.
 */
public class Tortue extends Observable {

    //Constantes
    public static int DISTANCE_SEPARATION = 30;
    public static int DISTANCE_VUE = 60;
    public static int MAXIMUM_SPEED = 5;
    public static final int HEIGHT = 400;
    public static final int WIDTH = 500;
    public static int RB =10, RP =10;

    public enum Colors{
        VERT,
        ROUGE,
        NOIR
    }

    //Attributs

    int vitesse;
    int posX,posY;
    int dir;

    Colors color = Colors.VERT;

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

    public Color getColor(){return this.bindColor();}

    public void setPos(int posX, int posY){
        this.posX = posX;
        this.posY = posY;

        setChanged();
        notifyObservers();
    }

    public void setDir(int dir){
        this.dir = dir;

        setChanged();
        notifyObservers();
    }

    public void setColor(Colors color){
        this.color = color;

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
        posX = (int)(Math.random() * (HEIGHT));
        posY = (int)(Math.random() * (WIDTH));
        dir = (int)(Math.random() * (360)); //todo constante
        vitesse = (int) (Math.random() * MAXIMUM_SPEED);

        setChanged();
        notifyObservers();
    }

    private Color bindColor(){
        switch (color){
            case VERT:
                return Color.green;

            case NOIR:
                return Color.BLACK;

            case ROUGE:
                return Color.RED;
            default:
                return Color.green;

        }
    }

    public void avancer(int dist) {
        int newX = ((int) Math.round(getPosX()+dist*Math.cos(Math.toRadians(getDir()))))%Tortue.WIDTH;
        int newY = ((int) Math.round(getPosY()+dist*Math.sin(Math.toRadians(getDir()))))%Tortue.HEIGHT;

        if(newX<0){
            newX = Tortue.HEIGHT + newX;
        }
        if(newY<0){
            newY = Tortue.WIDTH + newY;
        }

        setPos(newX, newY);
    }

    public void droite(int ang) {
        setDir((getDir()+ang)%360);
    }

    public void gauche(int ang) {
        droite(-ang);
    }
}
