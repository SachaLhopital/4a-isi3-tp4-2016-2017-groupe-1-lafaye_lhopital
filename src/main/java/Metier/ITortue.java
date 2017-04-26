package Metier;

import javafx.beans.Observable;

/**
 * Created by lafay on 26/04/2017.
 */
public abstract class ITortue implements Observable{
    int posX;
    int posY;
    int direction;
    int couleur; //TODO definir Objet couleur
    boolean isCrayonLeve;

    public ITortue(int posX, int posY, int direction, int couleur) {
        this.posX = posX;
        this.posY = posY;
        this.direction = direction;
        this.couleur = couleur;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
        notify();
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
        notify();
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
        notify();
    }

    public int getCouleur() {
        return couleur;
    }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
        notify();
    }

    public boolean isCrayonLeve() {
        return isCrayonLeve;
    }

    public void setCrayonLeve(boolean crayonLeve) {
        isCrayonLeve = crayonLeve;
    }
}
