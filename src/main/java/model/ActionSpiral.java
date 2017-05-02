package model;

/**
 * Created by lafay on 02/05/2017.
 */
public class ActionSpiral implements IAction {
    public void doAction(Tortue turtle) {
        spiral(turtle, 50,40,6);
    }



    public void spiral(Tortue turtle, int distance, int avancement, int angle) {
        for (int i = 0; i < avancement; i++) {
            turtle.avancer(distance);
            turtle.droite(360/angle);
            distance = distance+1;

        }
    }
}
