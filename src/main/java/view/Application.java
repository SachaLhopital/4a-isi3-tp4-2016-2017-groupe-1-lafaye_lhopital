package view;

/**
 * Created by Sachouw Dev on 07/05/2017.
 */

import controleur.ControlerManipTortue;
import javafx.stage.Stage;


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


        ControlerManipTortue controleurActionsTortues = new ControlerManipTortue();


       // ViewTortues viewTortues = new ViewTortues(controleurFeuille);
        viewManipTortue = new ViewManipTortue(controleurActionsTortues);

        //premiereTortue.addObserver(viewManipTortue);
    }
}
