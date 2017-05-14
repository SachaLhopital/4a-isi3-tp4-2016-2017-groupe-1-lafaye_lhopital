package view;

/**
 * Created by Sachouw Dev on 07/05/2017.
 */

import controleur.ControlerFlockingTortue;
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

        /*ControlerManipTortue controleurActionsTortues = new ControlerManipTortue();
        viewManipTortue = new ViewManipTortue(controleurActionsTortues);*/

        //Flocking
        ControlerFlockingTortue controleurActionsTortues = new ControlerFlockingTortue();
        viewManipTortue = new ViewManipTortue(controleurActionsTortues);

        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
        }
        viewManipTortue.ajouterTortue();//première tortue
        controleurActionsTortues.run();
    }
}
