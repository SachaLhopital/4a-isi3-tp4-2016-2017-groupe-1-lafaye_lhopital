package model;

/**
 * Created by lafay on 02/05/2017.
 */
public class ActionPolygone implements IAction {
    public void doAction(Tortue turtle) {
        poly(turtle, 60,8);
    }

    public void poly(Tortue turtle, int distance, int angle) {
        for (int j=0;j<angle;j++) {
            turtle.avancer(distance);
            turtle.droite(360/angle);

        }
    }
}
