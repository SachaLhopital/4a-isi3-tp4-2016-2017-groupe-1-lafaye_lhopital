package model;

/**
 * Created by lafay on 02/05/2017.
 */
public class ActionCarre implements IAction{

    public void doAction(Tortue turtle) {
        for (int i=0;i<4;i++) {
            turtle.avancer(100);
            turtle.droite(90);

        }
    }
}
