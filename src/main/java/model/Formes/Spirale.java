package model.Formes;

import model.Tortue;

/**
 * Created by Sachouw Dev on 08/05/2017.
 */
public class Spirale implements IForme{

    private static final int AVANCEMENT = 40;
    private static final int ANGLE = 6;
    private static int DISTANCE = 50;

    @Override
    public void tracer(Tortue tortue) {
        for (int i = 0; i < AVANCEMENT; i++) {
            tortue.avancer(DISTANCE);
            tortue.droite(DEGREES / ANGLE);
            DISTANCE = DISTANCE + 1;

        }
    }
}
