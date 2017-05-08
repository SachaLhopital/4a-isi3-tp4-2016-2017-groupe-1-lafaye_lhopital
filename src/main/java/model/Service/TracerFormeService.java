package model.Service;

import model.Formes.IForme;
import model.Tortue;

/**
 * Service faire faire une certaine forme à une tortue
 * Created by Sachouw Dev on 08/05/2017.
 */
public class TracerFormeService {

    /***
     * Trace la forme précisée en paramètre
     * @param tortue
     * @param forme
     */
    public void doAction(Tortue tortue, IForme forme) {
        forme.tracer(tortue);
    }
}
