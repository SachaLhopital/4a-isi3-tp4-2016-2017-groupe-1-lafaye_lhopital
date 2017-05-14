package model;

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

    Couleurs couleur = Couleurs.VERT;

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

    public Color getCouleur(){return this.bindColor();}

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

    public void setCouleur(Couleurs couleur){
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

    private Color bindColor(){
        switch (couleur){
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

    public void avancer(int distance) {
        int nouveauX = ((int) Math.round(getPosX()+distance*Math.cos(Math.toRadians(getDir()))))% WIDTH;
        int nouveauY = ((int) Math.round(getPosY()+distance*Math.sin(Math.toRadians(getDir()))))% HEIGHT;

        if(nouveauX<0){
            nouveauX = HEIGHT + nouveauX;
        }
        if(nouveauY<0){
            nouveauY = WIDTH + nouveauY;
        }

        setPos(nouveauX, nouveauY);
    }

    public void droite(int angle) {
        setDir((getDir()+angle) % DEGREES);
    }

    public void gauche(int angle) {
        droite(-angle);
    }
}
