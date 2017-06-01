package view.vuesAuto;

import controleur.modeAuto.ControleurFeuilleFlocking;
import view.commun.ViewFeuille;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lafay on 17/05/2017.
 */
public class ViewFeuilleFlocking extends ViewFeuille {

    public ViewFeuilleFlocking(ControleurFeuilleFlocking controleurFeuilleFlocking) {
        super(controleurFeuilleFlocking);

        this.setTitle("Flocking");

        JPanel menu = new JPanel();
        JButton btnDemarrer = new JButton("Démarrer");
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
