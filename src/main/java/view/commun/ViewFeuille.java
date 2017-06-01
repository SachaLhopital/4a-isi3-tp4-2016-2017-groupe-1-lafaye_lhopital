package view.commun;

import controleur.commun.ControleurFeuilleDessin;
import model.Tortue;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lafay on 15/05/2017.
 */
public class ViewFeuille extends JFrame {

    private JPanel panFeuille;

    public ViewFeuille(ControleurFeuilleDessin controleurFeuilleDessin){
        controleurFeuilleDessin.setFeuilleDessin(this);

        init();
    }

    private JPanel getPanFeuille() {
        return panFeuille;
    }

    private void setPanFeuille(JPanel nouvelleFeuille) {
        panFeuille = nouvelleFeuille;
    }

    public void init(){
        setPanFeuille(new JPanel());
        getPanFeuille().setLayout(null);
        getPanFeuille().setSize(Tortue.WIDTH, Tortue.HEIGHT);
        getContentPane().setPreferredSize(getPanFeuille().getSize());
        getContentPane().setSize(getPanFeuille().getSize());
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(getPanFeuille(),BorderLayout.CENTER);
        getPanFeuille().setBackground(Color.WHITE);
        getPanFeuille().setVisible(true);

        setVisible(true);
    }

    /***
     * Ajoute une vue de tortue à la feuille
     * @param viewTortue
     */
    public void ajouterVueTortue(ViewTortue viewTortue){
        getPanFeuille().add(viewTortue);
        viewTortue.repaint();
        pack();
    }
}
