package vue.commun;

import controleur.commun.ControleurSelectionMode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lafay on 15/05/2017.
 */
public class VueSelectionMode extends JFrame{
    private JPanel panPrincipal;
    private JButton btnManuel;
    private JButton btnAutomatique;
    private JButton btnFlocking;
    private JButton btnQuitter;
    private JButton btnFlockingSectaire;

    ControleurSelectionMode controleur;

    public VueSelectionMode(ControleurSelectionMode controleur){
        this.controleur = controleur;

        this.setTitle("Selection du Mode");

        setContentPane(panPrincipal);

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Selection mode de lancement");
        setVisible(true);

        btnManuel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.lancerTortueManuelle();
            }
        });
        btnAutomatique.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.lancerTortueAuto();
            }
        });
        btnFlocking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.lancerTortueFlocking();
            }
        });
        btnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.quitter();
            }
        });
        btnFlockingSectaire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.lancerTortueFlockingSectaire();
            }
        });
    }
}
