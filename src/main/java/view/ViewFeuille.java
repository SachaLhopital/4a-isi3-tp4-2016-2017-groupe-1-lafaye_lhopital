package view;

import controleur.ControleurFeuilleDessin;
import utils.Constantes;
import view.Forms.ViewTortue;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lafay on 15/05/2017.
 */
public class ViewFeuille extends JFrame {

    private JPanel panFeuille;

    private ControleurFeuilleDessin controleurFeuilleDessin;

    public ViewFeuille(ControleurFeuilleDessin controleurFeuilleDessin){
        this.controleurFeuilleDessin = controleurFeuilleDessin;
        controleurFeuilleDessin.setFeuilleDessin(this);

        init();
    }

    public void init(){
        panFeuille = new JPanel();
        panFeuille.setLayout(null);
        panFeuille.setSize(Constantes.WIDTH,Constantes.HEIGHT);
        this.getContentPane().setPreferredSize(panFeuille.getSize());
        this.getContentPane().setSize(panFeuille.getSize());
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panFeuille,BorderLayout.CENTER);
        panFeuille.setBackground(Color.WHITE);
        panFeuille.setVisible(true);

        this.setVisible(true);
    }

    public void addTortue(ViewTortue viewTortue){
        panFeuille.add(viewTortue);
        viewTortue.repaint();

        this.pack();
    }


}
