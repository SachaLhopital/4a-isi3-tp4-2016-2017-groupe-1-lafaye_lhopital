package controler;

import model.Tortue;

import javax.swing.*;
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
    private JButton btnLever;
    private JButton btnBaisser;

    public Tortue tortueCourante;

    public ControlerMoveTurtle(){
        this.tortueCourante = new Tortue();

        ControlerFeuille controlleurFeuille = new ControlerFeuille(this.tortueCourante);
        panPrincipal.add(controlleurFeuille,"Center");

        btnAvancer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                avancer(getParametter());
                System.out.print("avancer");
            }
        });


        btnGauche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gauche(getParametter());
                System.out.print("gauche");
            }
        });

        btnDroite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                droite(getParametter());
                System.out.print("droite");
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
        int newX = (int) Math.round(tortueCourante.getPosX()+dist*Math.cos(Math.toRadians(tortueCourante.getDir())));
        int newY = (int) Math.round(tortueCourante.getPosY()+dist*Math.sin(Math.toRadians(tortueCourante.getDir())));

        /*if (crayon==true) {
            oldSrc.Tortue.Segment seg = new oldSrc.Tortue.Segment();

            seg.ptStart.x = x;
            seg.ptStart.y = y;
            seg.ptEnd.x = newX;
            seg.ptEnd.y = newY;
            seg.color = decodeColor(coul);

            listSegments.add(seg);
        }*/
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
        frame.pack();
        frame.setVisible(true);
    }
}
