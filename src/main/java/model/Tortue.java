package model;

import java.util.Observable;

/**
 * Created by lafay on 27/04/2017.
 */
public class Tortue extends Observable {

    //Static values
    public static final int HEIGHT = 400;
    public static final int WIDTH = 500;



    int posX,posY;
    int dir;

    public static int RB =10,RP =10;

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

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getDir() {
        return dir;
    }

    public void reset(){
        posX =HEIGHT/2;
        posY =WIDTH/2;
        dir =0;

        setChanged();
        notifyObservers();
    }

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



}
