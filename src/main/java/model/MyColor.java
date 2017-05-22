package model;

import java.awt.*;

/**
 * Created by lafay on 22/05/2017.
 */
public class MyColor {

    public enum Color {
        NOIR,
        ROUGE,
        BLEU,
        VERT,
        ROSE;
    }

    public static java.awt.Color getColor(MyColor.Color couleur) {
        switch (couleur){
            case NOIR:
                return java.awt.Color.BLACK;
            case ROUGE:
                return java.awt.Color.red;
            case BLEU:
                return java.awt.Color.BLUE;
            case VERT:
                return java.awt.Color.GREEN;
            case ROSE:
                return java.awt.Color.pink;
        }

        return java.awt.Color.green;
    }

}
