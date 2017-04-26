package Metier;

/**
 * Created by lafay on 26/04/2017.
 */
public class Avancer implements IAction {
    int distance;
    IFormeDeplacement formeDeplacement;

    public Avancer(int distance, IFormeDeplacement formeDeplacement){
        this.distance = distance;
        this.formeDeplacement = formeDeplacement;
    }


    public void resolution(ITortue tortue) {

    }
}
