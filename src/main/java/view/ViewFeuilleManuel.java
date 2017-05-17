package view;

import controleur.ControleurFeuilleManuel;
import utils.Constantes;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lafay on 16/05/2017.
 */
public class ViewFeuilleManuel extends ViewFeuille {

    JPanel panHaut;

    JToolBar toolBar;

    JTextField txtPramettres;

    JButton btnAvancer;
    JButton btnDroite;
    JButton btnGauche;
    JButton btnEffacer;
    JButton btnAjouter;

    JButton btnCouleur;

    public ViewFeuilleManuel(ControleurFeuilleManuel controleurFeuilleManuel) {
        super(controleurFeuilleManuel);

        panHaut = new JPanel();

        toolBar = new JToolBar();

        txtPramettres = new JTextField("10");
        btnAvancer = new JButton("Avancer");
        btnAjouter = new JButton("Ajouter");
        btnDroite = new JButton("Droite");
        btnGauche = new JButton("Gauche");
        btnEffacer = new JButton("Effacer");
        btnCouleur = new JButton("Couleur");


        toolBar.add(txtPramettres);
        toolBar.add(btnAvancer);
        toolBar.add(btnDroite);
        toolBar.add(btnGauche);
        toolBar.add(btnAjouter);
        toolBar.add(btnEffacer);
        toolBar.add(btnCouleur);

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
                controleurFeuilleManuel.ajouter();
            }
        });


    }

    private int getParameter(){
        int valeur =0;
        try{
            valeur = Integer.parseInt(txtPramettres.getText());
        }catch (Exception e){
            //print message log
            System.out.println("Format du paramettre invalide, il faut un nombre en entrée");
        }

        return valeur;
    }
}
