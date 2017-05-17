package model.Formes;

import model.Tortue;

import static utils.Constantes.*;

/**
 * Created by Sachouw Dev on 08/05/2017.
 */
public class Spirale implements IForme{

    public static final int AVANCEMENT = 40;
    public static final int ANGLE_SPIRALE = 6;
    public static int DISTANCE_SPIRALE = 50;

    @Override
    public void tracer(Tortue tortue) {
        for (int i = 0; i < AVANCEMENT; i++) {
            tortue.avancer(DISTANCE_SPIRALE);
            tortue.droite(DEGREES / ANGLE_SPIRALE);
            DISTANCE_SPIRALE = DISTANCE_SPIRALE + 1;

        }
    }
}
