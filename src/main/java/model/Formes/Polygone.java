package model.Formes;

import model.Tortue;

/**
 * Created by Sachouw Dev on 08/05/2017.
 */
public class Polygone implements IForme {

    public static final int DISTANCE_POLYGONE = 60;
    public static final int ANGLE_POLYGONE = 8;

    @Override
    public void tracer(Tortue tortue) {
        for (int j=0;j<ANGLE_POLYGONE;j++) {
            tortue.avancer(DISTANCE_POLYGONE);
            tortue.droite(DEGREES / ANGLE_POLYGONE);
        }
    }
}
