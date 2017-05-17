package view;

import controleur.ControleurFeuilleFlocking;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lafay on 17/05/2017.
 */
public class ViewFeuilleFlocking extends ViewFeuille {

    JButton btnDemarrer;
    JPanel menu;

    public ViewFeuilleFlocking(ControleurFeuilleFlocking controleurFeuilleFlocking) {
        super(controleurFeuilleFlocking);

        this.setTitle("Flocking");

        menu = new JPanel();
        btnDemarrer = new JButton("Démarrer");
        menu.add(btnDemarrer);

        //this.getContentPane().add(menu, BorderLayout.SOUTH);
        controleurFeuilleFlocking.démarrer();
        btnDemarrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleurFeuilleFlocking.démarrer();
            }
        });
        controleurFeuilleFlocking.ajouterToutesLesTortues();
    }
}
