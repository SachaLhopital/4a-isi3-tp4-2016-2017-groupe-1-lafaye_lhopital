package vue.vuesManuelle;

import controleur.modeManuel.ControleurFeuilleManuel;
import model.Tortue;
import model.CouleurManager;
import vue.commun.VueFeuille;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lafay on 16/05/2017.
 */
public class VueFeuilleManuel extends VueFeuille {

    private JTextField txtPramettres;

    private JComboBox <CouleurManager.Couleur> choixCouleur;

    public VueFeuilleManuel(ControleurFeuilleManuel controleurFeuilleManuel) {
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
        choixCouleur.addItem(CouleurManager.Couleur.NOIR);
        choixCouleur.addItem(CouleurManager.Couleur.VERT);
        choixCouleur.addItem(CouleurManager.Couleur.BLEU);
        choixCouleur.addItem(CouleurManager.Couleur.ROUGE);
        choixCouleur.addItem(CouleurManager.Couleur.ROSE);



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
                controleurFeuilleManuel.changerCouleur(CouleurManager.getCouleur((CouleurManager.Couleur)choixCouleur.getSelectedItem()));
            }
        });

        choixCouleur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleurFeuilleManuel.changerCouleur(CouleurManager.getCouleur((CouleurManager.Couleur)choixCouleur.getSelectedItem()));
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
