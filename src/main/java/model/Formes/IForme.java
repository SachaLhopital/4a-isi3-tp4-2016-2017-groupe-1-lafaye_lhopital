package model.Formes;

import model.Tortue;

/**
 * Interface de formes de tracés
 * Created by Sachouw Dev on 08/05/2017.
 */
public interface IForme {

    int DEGREES = 360;

    void tracer(Tortue tortue);
}
