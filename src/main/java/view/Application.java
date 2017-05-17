package view;

/**
 * Created by Sachouw Dev on 07/05/2017.
 */

import controleur.ControleurSelectionMode;
import javafx.stage.Stage;


/***
 * Application de gestion de tortues
 */
public class Application extends javafx.application.Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ControleurSelectionMode controleurSelectionMode = new ControleurSelectionMode();
        new ViewSelectionMode(controleurSelectionMode);
    }
}
