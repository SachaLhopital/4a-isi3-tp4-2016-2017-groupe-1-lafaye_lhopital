package Vue;

import Metier.ModeleTortue;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by lafay on 26/04/2017.
 */
public class VueFeuilleDessin extends JPanel {

    ArrayList<VueTortue> vuesTortue = new ArrayList<VueTortue>();

    public void addVueTortue(ModeleTortue tortue){
        VueTortue vueTortue = new VueTortue(tortue,this);
        tortue.addObserver(vueTortue);
        vuesTortue.add(vueTortue);
    }

    public void dessiner(Graphics graph){
        for(VueTortue v:vuesTortue){
            v.dessiner(graph);
        }
    }
}
