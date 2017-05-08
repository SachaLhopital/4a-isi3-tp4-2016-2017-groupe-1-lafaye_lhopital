package view;

/**
 * Created by Sachouw Dev on 07/05/2017.
 */

import controleur.ControleurTortues;
import controleur.ControlerManipTortue;
import javafx.stage.Stage;
import model.Tortue;

/***
 * Application de gestion de tortues
 */
public class Application extends javafx.application.Application {

    public static ViewManipTortue viewManipTortue;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Tortue premiereTortue = new Tortue();

        ControlerManipTortue controleurActionsTortues = new ControlerManipTortue(premiereTortue);
        ControleurTortues controleurFeuille = new ControleurTortues(controleurActionsTortues);

        ViewTortues viewTortues = new ViewTortues(controleurFeuille);
        viewManipTortue = new ViewManipTortue(controleurActionsTortues, controleurFeuille, viewTortues);

        premiereTortue.addObserver(viewManipTortue);
    }
}
