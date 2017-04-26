package Vue;

import Controleur.CtrlManipTortue;
import Metier.ModeleTortue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by lafay on 26/04/2017.
 */
public class VueManipTortue extends JFrame implements Observer{

    VueFeuilleDessin vueFeuilleDessin;

    //controlleur
    CtrlManipTortue controlleur;

    //Éléménent SWING
    public JPanel panelAction;
    public JToolBar barreAction;
    public JButton btnEffacer;
    public JButton btnAvancer;
    public JButton btnDroite;
    public JButton btnGauche;
    public JButton btnLeverCrayon;
    public JButton btnBaisserCrayon;
    public JTextField txtParametreAction;
    public JLabel lblCouleur;
    public JComboBox comboBoxListeCouleurs;
    public JMenuBar mbBarreMenu;
    public JMenu btnFichier;
    public JMenu btnCommandes;
    public JPanel panelFormeDeplacement;
    public JButton btnFormeCarre;
    public JButton btnFomePolygone;
    public JButton btnFormSpirale;


    public static final Dimension HGAP = new Dimension(5,1);

    public VueManipTortue() {
        super("un logo tout simple");

        controlleur = new CtrlManipTortue(this);

        init();


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
    }

    public void init(){
        getContentPane().setLayout(new BorderLayout(10,10));



        // Boutons
        barreAction = new JToolBar();
        panelAction = new JPanel();
        panelAction.add(barreAction);

        getContentPane().add(panelAction,"North");

        addButton(barreAction,"Effacer","Nouveau dessin","/icons/index.png");

        barreAction.add(Box.createRigidArea(HGAP));
        txtParametreAction=new JTextField("45",5);
        barreAction.add(txtParametreAction);
        addButton(barreAction, "Avancer", "Avancer 50", null);
        addButton(barreAction, "Droite", "Droite 45", null);
        addButton(barreAction, "Gauche", "Gauche 45", null);
        addButton(barreAction, "Lever", "Lever Crayon", null);
        addButton(barreAction, "Baisser", "Baisser Crayon", null);

        String[] colorStrings = {"noir", "bleu", "cyan","gris fonce","rouge",
                "vert", "gris clair", "magenta", "orange",
                "gris", "rose", "jaune"};

        // Create the combo box
        barreAction.add(Box.createRigidArea(HGAP));
        lblCouleur = new JLabel("   Couleur: ");
        barreAction.add(lblCouleur);
        comboBoxListeCouleurs = new JComboBox(colorStrings);
        barreAction.add(comboBoxListeCouleurs);

        comboBoxListeCouleurs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                int n = cb.getSelectedIndex();
                //TODO creer methode dans le controlleur
                //courante.setColor(n);
            }
        });


        // Menus
        mbBarreMenu=new JMenuBar();
        setJMenuBar(mbBarreMenu);	// on installe le menu bar
        JMenu menuFile=new JMenu("File"); // on installe le premier menu
        mbBarreMenu.add(menuFile);

        addMenuItem(menuFile, "Effacer", "Effacer", KeyEvent.VK_N);
        addMenuItem(menuFile, "Quitter", "Quitter", KeyEvent.VK_Q);

        JMenu menuCommandes=new JMenu("Commandes"); // on installe le premier menu
        mbBarreMenu.add(menuCommandes);
        addMenuItem(menuCommandes, "Avancer", "Avancer", -1);
        addMenuItem(menuCommandes, "Droite", "Droite", -1);
        addMenuItem(menuCommandes, "Gauche", "Gauche", -1);
        addMenuItem(menuCommandes, "Lever Crayon", "Lever", -1);
        addMenuItem(menuCommandes, "Baisser Crayon", "Baisser", -1);

        JMenu menuHelp=new JMenu("Aide"); // on installe le premier menu
        mbBarreMenu.add(menuHelp);
        addMenuItem(menuHelp, "Aide", "Help", -1);
        addMenuItem(menuHelp, "A propos", "About", -1);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // les boutons du bas
        panelFormeDeplacement = new JPanel(new GridLayout());
        btnFormeCarre = new JButton("Proc1");
        panelFormeDeplacement.add(btnFormeCarre);
        btnFormeCarre.addActionListener(controlleur);
        btnFomePolygone = new JButton("Proc2");
        panelFormeDeplacement.add(btnFomePolygone);
        btnFomePolygone.addActionListener(controlleur);
        btnFormSpirale = new JButton("Proc3");
        panelFormeDeplacement.add(btnFormSpirale);
        btnFormSpirale.addActionListener(controlleur);

        getContentPane().add(panelFormeDeplacement,"South");

        vueFeuilleDessin = new VueFeuilleDessin(); //500, 400);
        vueFeuilleDessin.setBackground(Color.white);
        vueFeuilleDessin.setSize(new Dimension(600,400));
        vueFeuilleDessin.setPreferredSize(new Dimension(600,400));

        getContentPane().add(vueFeuilleDessin,"Center");

        // Creation de la tortue
        ModeleTortue tortue = new ModeleTortue();


        // Deplacement de la tortue au centre de la feuille
        tortue.setPosition(500/2, 400/2); //TODO supprimer?

        //courante = tortue;
        vueFeuilleDessin.addVueTortue(tortue);

        pack();
        setVisible(true);
    }

    public void addButton(JComponent p, String name, String tooltiptext, String imageName) {
        JButton b;
        if ((imageName == null) || (imageName.equals(""))) {
            b = (JButton)p.add(new JButton(name));
            //TODO REFACT_LAFAYE_LHOPITAL
        }
        else {
            java.net.URL u = this.getClass().getResource(imageName);
            if (u != null) {
                ImageIcon im = new ImageIcon (u);
                b = (JButton) p.add(new JButton(im));
            }
            else
                b = (JButton) p.add(new JButton(name));
            b.setActionCommand(name);
        }

        b.setToolTipText(tooltiptext);
        b.setBorder(BorderFactory.createRaisedBevelBorder());
        b.setMargin(new Insets(0,0,0,0));
        b.addActionListener(controlleur);
    }

    public void addMenuItem(JMenu m, String label, String command, int key) {
        JMenuItem menuItem;
        menuItem = new JMenuItem(label);
        m.add(menuItem);

        menuItem.setActionCommand(command);
        menuItem.addActionListener(controlleur);
        if (key > 0) {
            if (key != KeyEvent.VK_DELETE)
                menuItem.setAccelerator(KeyStroke.getKeyStroke(key, Event.CTRL_MASK, false));
            else
                menuItem.setAccelerator(KeyStroke.getKeyStroke(key, 0, false));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){

                VueManipTortue fenetre = new VueManipTortue();
                fenetre.setVisible(true);
            }
        });

    }

    public void update(Observable o, Object arg) {

    }
}
