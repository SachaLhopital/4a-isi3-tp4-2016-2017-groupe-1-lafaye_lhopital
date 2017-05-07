package view;

import controler.ControlerFeuille;
import controler.ControlerMoveTurtle;
import model.Tortue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Vue principale avec header et footer de boutons
 * Created by Sachouw Dev on 07/05/2017.
 */
public class ViewMenu extends JFrame implements Observer {

    private ControlerMoveTurtle controleurPrincipal;
    private ControlerFeuille controleurFeuille;

    public JPanel panelPrincipal;
    private JPanel panAction;
    private JPanel panActionAuto;
    private JButton btnEffacer;
    private JTextField txtParamettre;
    private JButton btnGauche;
    private JButton btnDroite;
    private JButton btnAvancer;
    private JButton btnAjouterTortue;
    private JComboBox cbColorSelector;
    private JButton btnAactionCarre;
    private JButton btnSpiral;
    private JButton btnPolygone;

    public ViewMenu(ControlerMoveTurtle controleur, ControlerFeuille controleurFeuille) {

        controleurPrincipal = controleur;
        this.controleurFeuille = controleurFeuille;

        //Setup de la fenêtre
        setContentPane(panelPrincipal);
        panelPrincipal.add(controleurFeuille,"Center");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(Tortue.WIDTH,Tortue.HEIGHT+67));
        setTitle("ControlerMoveTurtle");
        pack();
        setVisible(true);

        //Selecteur Couleurs
        for(Tortue.Colors c : Tortue.Colors.values()){
            cbColorSelector.addItem(c);
        }

        initActionListeners();
    }

    /***
     * Configure les actionsListeners
     */
    private void initActionListeners() {

        btnAvancer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controleurPrincipal.avancerTortue(getParametre());
            }
        });

        btnGauche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controleurPrincipal.tournerTortueAGauche(getParametre());
            }
        });

        btnDroite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controleurPrincipal.tournerTortueADroite(getParametre());
            }
        });

        btnAjouterTortue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controleurFeuille.ajouterTortue();
            }
        });

        cbColorSelector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controleurPrincipal.setCouleurTortue((Tortue.Colors)cbColorSelector.getSelectedItem());
            }
        });

        btnAactionCarre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controleurPrincipal.tracerCarre();
            }
        });

        btnSpiral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleurPrincipal.tracerSpiral();
            }
        });

        btnPolygone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleurPrincipal.tracerPolygone();
            }
        });
    }

    public int getParametre(){
        try{
            return Integer.parseInt(txtParamettre.getText());
        }catch(Exception e){
            return 0;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
