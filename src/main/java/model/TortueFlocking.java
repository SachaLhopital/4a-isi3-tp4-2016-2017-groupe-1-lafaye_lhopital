package model;

/**
 * Created by lafay on 10/05/2017.
 */
public class TortueFlocking extends Tortue {

    //TODO TO REMOVE AT THE END

    private static int DISTANCE_SEPARATION = 30;
    private static int DISTANCE_VUE = 60;
    private static int SPEED = 5;

    public int separation;
    public int distanceDeVue;
    public int vitesse;

    public static int maxTurnTheta = 15;

    public TortueFlocking() {
        super();
        this.separation = DISTANCE_SEPARATION;
        this.distanceDeVue = DISTANCE_VUE;
        this.vitesse = SPEED;
    }

   /* *//**
            * Causes the bird to attempt to face a new direction.
 * Based on maxTurnTheta, the bird may not be able to complete the turn.
            * @param  newHeading The direction in degrees that the bird should turn toward.
 *//*
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
    }*/



}