package model.Comportements;

import model.Tortue;

/**
 * Created by Sachouw Dev on 10/05/2017.
 */
public interface IComportement {

    /***
     * Avance selon le comportement
     */
    void avancer(Tortue tortue, int dist);
}
