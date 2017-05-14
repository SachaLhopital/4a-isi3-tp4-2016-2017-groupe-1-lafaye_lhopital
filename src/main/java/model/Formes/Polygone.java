package model.Formes;

import model.Tortue;

import static utils.Constantes.ANGLE_POLYGONE;
import static utils.Constantes.DEGREES;
import static utils.Constantes.DISTANCE_POLYGONE;

/**
 * Created by Sachouw Dev on 08/05/2017.
 */
public class Polygone implements IForme {

    @Override
    public void tracer(Tortue tortue) {
        for (int j=0;j<ANGLE_POLYGONE;j++) {
            tortue.avancer(DISTANCE_POLYGONE);
            tortue.droite(DEGREES / ANGLE_POLYGONE);
        }
    }
}
