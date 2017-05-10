package model.Comportements;

import model.Tortue;

/**
 * Created by Sachouw Dev on 10/05/2017.
 */
public class Manuel implements IComportement {

    @Override
    public void avancer(Tortue tortue, int dist) {
        int newX = ((int) Math.round(tortue.getPosX()+dist*Math.cos(Math.toRadians(tortue.getDir()))))% Tortue.WIDTH;
        int newY = ((int) Math.round(tortue.getPosY()+dist*Math.sin(Math.toRadians(tortue.getDir()))))%Tortue.HEIGHT;

        if(newX<0){
            newX = Tortue.HEIGHT + newX;
        }
        if(newY<0){
            newY = Tortue.WIDTH + newY;
        }

        tortue.setPos(newX, newY);
    }
}
