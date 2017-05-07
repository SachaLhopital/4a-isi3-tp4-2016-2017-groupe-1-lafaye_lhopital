package view;/**
 * Created by Sachouw Dev on 07/05/2017.
 */

import controler.ControlerFeuille;
import controler.ControlerMoveTurtle;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Tortue;

/***
 * Application de gestion des tortues
 */
public class TortueApplication extends Application {

    public static ViewMenu viewMenu;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Tortue premiereTortue = new Tortue();

        ControlerMoveTurtle controleurActionsTortues = new ControlerMoveTurtle(premiereTortue);
        ControlerFeuille controleurFeuille = new ControlerFeuille(controleurActionsTortues, premiereTortue);

        viewMenu = new ViewMenu(controleurActionsTortues, controleurFeuille);

        premiereTortue.addObserver(viewMenu);
    }
}
