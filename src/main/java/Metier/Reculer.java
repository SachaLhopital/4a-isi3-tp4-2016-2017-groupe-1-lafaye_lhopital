package Metier;

/**
 * Created by lafay on 26/04/2017.
 */
public class Reculer implements IAction {

    int distance;
    IFormeDeplacement formeDeplacement;

    public Reculer(int distance, IFormeDeplacement formeDeplacement){
        this.distance = distance;
        this.formeDeplacement = formeDeplacement;
    }

    public void resolution(ModeleTortue tortue) {

    }
}
