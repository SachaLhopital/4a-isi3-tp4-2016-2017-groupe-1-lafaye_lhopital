package view.vuesManuelle;

import controleur.modeManuel.ControleurFeuilleManuel;
import model.MaCouleur;
import model.Tortue;
import view.commun.ViewFeuille;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lafay on 16/05/2017.
 */
public class ViewFeuilleManuel extends ViewFeuille {

    private JTextField txtPramettres;

    private JComboBox <MaCouleur.Couleur> choixCouleur;

    public ViewFeuilleManuel(ControleurFeuilleManuel controleurFeuilleManuel) {
        super(controleurFeuilleManuel);
        this.setTitle("Manuel");

        //menu du haut
        JPanel panHaut = new JPanel();

        JToolBar toolBar = new JToolBar();

        txtPramettres = new JTextField("10");
        JButton btnAvancer = new JButton("Avancer");
        JButton btnAjouter = new JButton("Ajouter");
        JButton btnDroite = new JButton("Droite");
        JButton btnGauche = new JButton("Gauche");

        choixCouleur = new JComboBox<>();
        choixCouleur.addItem(MaCouleur.Couleur.NOIR);
        choixCouleur.addItem(MaCouleur.Couleur.VERT);
        choixCouleur.addItem(MaCouleur.Couleur.BLEU);
        choixCouleur.addItem(MaCouleur.Couleur.ROUGE);
        choixCouleur.addItem(MaCouleur.Couleur.ROSE);



        toolBar.add(txtPramettres);
        toolBar.add(btnAvancer);
        toolBar.add(btnDroite);
        toolBar.add(btnGauche);
        toolBar.add(btnAjouter);
        toolBar.add(choixCouleur);

        panHaut.add(toolBar);

        this.getContentPane().add(panHaut, BorderLayout.NORTH);

        //ajout des listener
        btnAvancer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleurFeuilleManuel.avancer(getParameter());
            }
        });

        btnGauche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleurFeuilleManuel.gauche(getParameter());
            }
        });

        btnDroite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleurFeuilleManuel.droite(getParameter());
            }
        });

        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleurFeuilleManuel.ajouterTortue(new Tortue());
                controleurFeuilleManuel.changerCouleur(MaCouleur.getColor((MaCouleur.Couleur)choixCouleur.getSelectedItem()));
            }
        });

        choixCouleur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleurFeuilleManuel.changerCouleur(MaCouleur.getColor((MaCouleur.Couleur)choixCouleur.getSelectedItem()));
            }
        });


    }

    private int getParameter(){
        int valeur =0;
        try{
            valeur = Integer.parseInt(txtPramettres.getText());
        }catch (Exception e){
            //print message log
            System.out.println("Format du parametre invalide, merci de saisir un entier");
        }

        return valeur;
    }
}
