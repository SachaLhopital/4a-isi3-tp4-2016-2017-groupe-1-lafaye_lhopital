package model.Formes;

import model.Tortue;

/**
 * Created by Sachouw Dev on 08/05/2017.
 */
public class Polygone implements IForme {

    private static final int DISTANCE = 60;
    private static final int ANGLE = 8;

    @Override
    public void tracer(Tortue tortue) {
        for (int j=0;j<ANGLE;j++) {
            tortue.avancer(DISTANCE);
            tortue.droite(DEGREES / ANGLE);
        }
    }
}
