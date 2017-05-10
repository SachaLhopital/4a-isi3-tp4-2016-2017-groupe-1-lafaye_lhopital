package model;

import java.util.LinkedList;

/**
 * Created by lafay on 10/05/2017.
 */
public class TortueFlocking extends Tortue {

    public int separation;
    public int distanceDeVue;
    public int angleVue;
    public int vitesse;

    public static int maxTurnTheta = 15;

    public TortueFlocking(int separation, int distanceDeVue, int angleVue, int vitesse) {
        super();
        this.separation = separation;
        this.distanceDeVue = distanceDeVue;
        this.angleVue = angleVue;
        this.vitesse = vitesse;
    }

    /**
            * Causes the bird to attempt to face a new direction.
 * Based on maxTurnTheta, the bird may not be able to complete the turn.
            * @param  newHeading The direction in degrees that the bird should turn toward.
 */
    public void move(int newHeading) {
        // determine if it is better to turn left or right for the new heading
        int left = (newHeading - getDir() + 360) % 360;
        int right = (getDir() - newHeading + 360) % 360;

        // after deciding which way to turn, find out if we can turn that much
        int thetaChange = 0;
        if (left < right) {
            // if left > than the max turn, then we can't fully adopt the new heading
            thetaChange = Math.min(maxTurnTheta, left);
        }
        else {
            // right turns are negative degrees
            thetaChange = -Math.min(maxTurnTheta, right);
        }

        // Make the turn
        setDir((getDir() + thetaChange + 360) % 360);

        // Now move currentSpeed pixels in the direction the bird now faces.
        // Note: Because values are truncated, a speed of 1 will result in no
        // movement unless the bird is moving exactly vertically or horizontally.
        int x = getPosX() + (int)(vitesse * Math.cos(getDir() * Math.PI/180)) + Tortue.WIDTH;
        x %= Tortue.WIDTH;
        int y = getPosY() - (int)(vitesse * Math.sin(getDir() * Math.PI/180)) - Tortue.HEIGHT;
       y %= Tortue.HEIGHT;

       setPos(x,y);
    }

    /**
     * Get the distance in pixels between this bird and another
     *
     * @param  autreTortue The other bird to measure the distance between
     * @return The distance to the other bird
     */
    public int getDistance(Tortue autreTortue) {
        int dX = autreTortue.getPosX() - getPosX();
        int dY = autreTortue.getPosY() - getPosY();

        return (int)Math.sqrt( Math.pow( dX, 2 ) + Math.pow( dY, 2 ));
    }

}