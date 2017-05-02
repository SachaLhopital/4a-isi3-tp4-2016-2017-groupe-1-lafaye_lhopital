package controler;

import model.ActionCarre;
import model.ActionPolygone;
import model.ActionSpiral;
import model.Tortue;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;

/**
 * Created by lafay on 27/04/2017.
 */
public class ControlerMoveTurtle {
    private JPanel panPrincipal;
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

    public Tortue tortueCourante;

    public ControlerMoveTurtle(){



        this.tortueCourante = new Tortue();

        final ControlerFeuille controlleurFeuille = new ControlerFeuille(this,this.tortueCourante);
        panPrincipal.add(controlleurFeuille,"Center");

        btnAvancer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tortueCourante.avancer(getParametter());
            }
        });


        btnGauche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tortueCourante.gauche(getParametter());
            }
        });

        btnDroite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tortueCourante.droite(getParametter());
            }
        });

        btnAjouterTortue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Tortue newT = new Tortue();
                controlleurFeuille.addTortue(newT);
                setCurrentTurlte(newT);

                controlleurFeuille.repaint();

            }
        });


        //add cb values
        for(Tortue.Colors c : Tortue.Colors.values()){
            cbColorSelector.addItem(c);
        }
        cbColorSelector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tortueCourante.setColor((Tortue.Colors)cbColorSelector.getSelectedItem());
            }
        });
        btnAactionCarre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ActionCarre().doAction(tortueCourante);
            }
        });
        btnSpiral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ActionSpiral().doAction(tortueCourante);
            }
        });
        btnPolygone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ActionPolygone().doAction(tortueCourante);
            }
        });
    }

    public int getParametter(){
        try{
            return Integer.parseInt(txtParamettre.getText());
        }catch(Exception e){
            return 0;
        }

    }

    public void setCurrentTurlte(Tortue turtle){
        this.tortueCourante = turtle;
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("ControlerMoveTurtle");
        frame.setContentPane(new ControlerMoveTurtle().panPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(Tortue.WIDTH,Tortue.HEIGHT+67));
        frame.pack();
        frame.setVisible(true);
    }
}
