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

    private JTextField txtPramettres;

    private JComboBox <Color> choixCouleur;

    public ViewFeuilleManuel(ControleurFeuilleManuel controleurFeuilleManuel) {
        super(controleurFeuilleManuel);
        this.setTitle("Manuel");

        JPanel panHaut = new JPanel();

        JToolBar toolBar = new JToolBar();

        txtPramettres = new JTextField("10");
        JButton btnAvancer = new JButton("Avancer");
        JButton btnAjouter = new JButton("Ajouter");
        JButton btnDroite = new JButton("Droite");
        JButton btnGauche = new JButton("Gauche");
        JButton btnEffacer = new JButton("Effacer");

        choixCouleur = new JComboBox<>();
        choixCouleur.addItem(Color.BLACK);
        choixCouleur.addItem(Color.BLUE);
        choixCouleur.addItem(Color.RED);
        choixCouleur.addItem(Color.GREEN);
        choixCouleur.addItem(Color.PINK);



        toolBar.add(txtPramettres);
        toolBar.add(btnAvancer);
        toolBar.add(btnDroite);
        toolBar.add(btnGauche);
        toolBar.add(btnAjouter);
        toolBar.add(btnEffacer);
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
                controleurFeuilleManuel.ajouter();
            }
        });

        choixCouleur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleurFeuilleManuel.changerCouleur((Color)choixCouleur.getSelectedItem());
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
