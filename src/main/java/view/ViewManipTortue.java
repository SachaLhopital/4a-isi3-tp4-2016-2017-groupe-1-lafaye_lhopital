package view;

import controleur.ControlerManipTortue;
import model.Tortue;
import utils.Constantes;

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
public class ViewManipTortue extends JFrame implements Observer {

    private ControlerManipTortue controleurPrincipal;

    public JPanel panelPrincipal;
    private JPanel panAction;
    private JPanel panActionAuto;
    private JButton btnEffacer;
    private JTextField txtParametre;
    private JButton btnGauche;
    private JButton btnDroite;
    private JButton btnAvancer;
    private JButton btnAjouterTortue;
    private JComboBox cbColorSelector;
    private JButton btnAactionCarre;
    private JButton btnSpiral;
    private JButton btnPolygone;
    private JPanel panelFeuille;

    public ViewManipTortue(ControlerManipTortue controleurA) {

        controleurPrincipal = controleurA;

        setContentPane(panelPrincipal);

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(WIDTH,HEIGHT+67)); //todo constante
        setTitle("Mode Manuel");
        setVisible(true);

        for(Constantes.Couleurs c : Constantes.Couleurs.values()){
            cbColorSelector.addItem(c);
        }

        initActionListeners();
    }

    /***
     * Configure les actionsListeners de la vue
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
                ajouterTortue();
            }
        });

        cbColorSelector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controleurPrincipal.setCouleurTortue((Constantes.Couleurs)cbColorSelector.getSelectedItem());
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

    /***
     * Récupère le paramètre saisie par l'utilisateur
     * @return
     */
    public int getParametre(){
        try{
            return Integer.parseInt(txtParametre.getText());
        }catch(Exception e){
            return 0;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    public void repaint(){

        Graphics graphic = panelFeuille.getGraphics();

        if(graphic == null){
            return;
        }

        //nettoyage du graphique
        Color couleur = graphic.getColor();

        Dimension dimensions = panelFeuille.getSize();
        graphic.setColor(Color.white);
        graphic.fillRect(0,0,dimensions.width, dimensions.height);
        graphic.setColor(couleur);

        //dessin des tortues
        for (Tortue tortue : controleurPrincipal.getListeTortues()) {
            ViewTortueIndependante.dessine(tortue, graphic);
        }
    }

    /***
     * Ajoute une tortue sur la vue
     */
    public void ajouterTortue() {
        panelFeuille.add(controleurPrincipal.ajouterTortueEtGetVue());
        repaint();
    }
}
