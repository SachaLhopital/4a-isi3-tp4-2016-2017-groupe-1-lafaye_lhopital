package model.Formes;

import model.Tortue;

/**
 * Created by Sachouw Dev on 08/05/2017.
 */
public class Carre implements IForme {

    @Override
    public void tracer(Tortue tortue) {
        for (int i=0;i<4;i++) {
            tortue.avancer(100);
            tortue.droite(90);
        }
    }
}
