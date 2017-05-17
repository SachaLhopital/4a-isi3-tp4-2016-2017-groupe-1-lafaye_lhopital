package utils;

import java.awt.*;
import java.util.Vector;

/**
 * Created by minis on 17/05/2017.
 */
public class Vecteur {

    int x;
    int y;

    public Vecteur() {
        this.x = 1;
        this.y = 1;
    }

    public Vecteur(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Getters and setters

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //Méthodes

    public void ajouterVecteur(Vecteur v) {
        if(v != null && v.getX() != 0 && v.getY() != 0) {
            setX(getX() + v.getX());
            setY(getY() + v.getY());
        }
    }

    public void ajouterEntier(int valeur) {
        setX(getX() + valeur);
        setY(getY() + valeur);
    }

    public Point ajouterPoint(Point p) {
        return new Point( getX() + (int)p.getX(), getY() +(int) p.getY());
    }

    public void soustraireVecteur(Vecteur v) {
        if(v != null && v.getX() != 0 && v.getY() != 0) {
            setX(getX() - v.getX());
            setY(getY() - v.getY());
        }
    }

    public void diviserEntier(int valeur) {
        if(valeur > 0) {
            setX(getX() / valeur);
            setY(getY() / valeur);
        }
    }
}
