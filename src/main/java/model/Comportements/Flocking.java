package model.Comportements;

import model.Tortue;

/**
 * Created by Sachouw Dev on 10/05/2017.
 */
public class Flocking implements IComportement {

    private static int DISTANCE_SEPARATION = 30;
    private static int DISTANCE_VUE = 60;
    private static int VITESSE = 5;
    private static int DEGREE_MAX_ROTATION = 15;

    @Override
    public void avancer(Tortue tortue, int dist) {

        // determine if it is better to turn left or right for the new heading
        int left = (dist - tortue.getDir() + 360) % 360;
        int right = (tortue.getDir() - dist + 360) % 360;

        // after deciding which way to turn, find out if we can turn that much
        int thetaChange = 0;
        if (left < right) {
            // if left > than the max turn, then we can't fully adopt the new heading
            thetaChange = Math.min(DEGREE_MAX_ROTATION, left);
        }
        else {
            // right turns are negative degrees
            thetaChange = -Math.min(DEGREE_MAX_ROTATION, right);
        }

        // Make the turn
        tortue.setDir((tortue.getDir() + thetaChange + 360) % 360);

        // Now move currentSpeed pixels in the direction the turtle now faces.
        // Note: Because values are truncated, a speed of 1 will result in no
        // movement unless the bird is moving exactly vertically or horizontally.
        /*int x = tortue.getPosX() + (int)(VITESSE * Math.cos(tortue.getDir() * Math.PI/180)) + Tortue.WIDTH;
        x %= Tortue.WIDTH;
        int y = tortue.getPosY() - (int)(VITESSE * Math.sin(tortue.getDir() * Math.PI/180)) - Tortue.HEIGHT;
        y %= Tortue.HEIGHT;*/

        /*int newX = tortue.getPosX() + ((int) Math.round(VITESSE*Math.cos(Math.toRadians(tortue.getDir()))) + Tortue.WIDTH) % Tortue.WIDTH;
        int newY = tortue.getPosY() - ((int) Math.round(VITESSE*Math.sin(Math.toRadians(tortue.getDir()))) - Tortue.HEIGHT) % Tortue.HEIGHT;

        if(newX<0){
            newX = Tortue.HEIGHT + newX;
        }
        if(newY<0){
            newY = Tortue.WIDTH + newY;
        }*/

        //TODO : set degree sur tortue.getDir().

        tortue.getLocalisation().x += tortue.getPosX() + (int)(VITESSE * Math.cos(tortue.getDir() * Math.PI/180)) + Tortue.WIDTH;
        tortue.getLocalisation().x %= Tortue.WIDTH;
        tortue.getLocalisation().y -= tortue.getPosY() - (int)(VITESSE * Math.sin(tortue.getDir() * Math.PI/180)) - Tortue.HEIGHT;
        tortue.getLocalisation().y %= Tortue.HEIGHT;

        System.out.println("x : " + tortue.getLocalisation().x  + " || y : " + tortue.getLocalisation().y );

        tortue.update();
    }
}
