package view;

import controleur.ControleurFeuilleDessin;
import javax.swing.*;
import java.awt.*;

/**
 * Created by lafay on 15/05/2017.
 */
public class ViewFeuille extends JFrame {

    private static final int HEIGHT = 400;
    private static final int WIDTH = 500;

    private JPanel panFeuille;

    ViewFeuille(ControleurFeuilleDessin controleurFeuilleDessin){
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
        getPanFeuille().setSize(WIDTH, HEIGHT);
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
