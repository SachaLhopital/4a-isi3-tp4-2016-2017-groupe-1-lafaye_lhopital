package controler;

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

    public Tortue tortueCourante;

    public ControlerMoveTurtle(){



        this.tortueCourante = new Tortue();

        ControlerFeuille controlleurFeuille = new ControlerFeuille(this.tortueCourante);
        panPrincipal.add(controlleurFeuille,"Center");

        btnAvancer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                avancer(getParametter());
            }
        });


        btnGauche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gauche(getParametter());
            }
        });

        btnDroite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                droite(getParametter());
            }
        });

        btnAjouterTortue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

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
    }

    public int getParametter(){
        try{
            return Integer.parseInt(txtParamettre.getText());
        }catch(Exception e){
            return 0;
        }

    }

    public void avancer(int dist) {
        int newX = ((int) Math.round(tortueCourante.getPosX()+dist*Math.cos(Math.toRadians(tortueCourante.getDir()))))%Tortue.WIDTH;
        int newY = ((int) Math.round(tortueCourante.getPosY()+dist*Math.sin(Math.toRadians(tortueCourante.getDir()))))%Tortue.HEIGHT;

        if(newX<0){
            newX = Tortue.HEIGHT + newX;
        }
        if(newY<0){
            newY = Tortue.WIDTH + newY;
        }

        tortueCourante.setPos(newX, newY);
    }

    public void droite(int ang) {
        tortueCourante.setDir((tortueCourante.getDir()+ang)%360);
    }

    public void gauche(int ang) {
        droite(-ang);
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
