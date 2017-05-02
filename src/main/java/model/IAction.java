package model;

/**
 * Created by lafay on 02/05/2017.
 */
public interface IAction {

    long VITESSE_AFFICHAGE = 10;

    default void doAction(Tortue turtle) {
        //doNothing
    }
}
