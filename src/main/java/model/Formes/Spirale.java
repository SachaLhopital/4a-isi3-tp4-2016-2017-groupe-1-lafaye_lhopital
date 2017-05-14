package model.Formes;

import model.Tortue;

import static utils.Constantes.*;

/**
 * Created by Sachouw Dev on 08/05/2017.
 */
public class Spirale implements IForme{

    @Override
    public void tracer(Tortue tortue) {
        for (int i = 0; i < AVANCEMENT; i++) {
            tortue.avancer(DISTANCE_SPIRALE);
            tortue.droite(DEGREES / ANGLE_SPIRALE);
            DISTANCE_SPIRALE = DISTANCE_SPIRALE + 1;

        }
    }
}
