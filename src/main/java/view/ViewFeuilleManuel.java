package view;

import controleur.ControleurFeuilleManuel;
import model.MyColor;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lafay on 16/05/2017.
 */
public class ViewFeuilleManuel extends ViewFeuille {

    private JTextField txtPramettres;

    private JComboBox <MyColor.Color> choixCouleur;

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
        JButton btnEffacer = new JButton("Effacer");

        choixCouleur = new JComboBox<>();
        choixCouleur.addItem(MyColor.Color.NOIR);
        choixCouleur.addItem(MyColor.Color.VERT);
        choixCouleur.addItem(MyColor.Color.BLEU);
        choixCouleur.addItem(MyColor.Color.ROUGE);
        choixCouleur.addItem(MyColor.Color.ROSE);



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
                controleurFeuilleManuel.changerCouleur(MyColor.getColor((MyColor.Color)choixCouleur.getSelectedItem()));
            }
        });

        choixCouleur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleurFeuilleManuel.changerCouleur(MyColor.getColor((MyColor.Color)choixCouleur.getSelectedItem()));
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
