package view;

import controleur.ControleurFeuilleAuto;
import controleur.ControleurTortue;
import model.Tortue;
import view.Forms.ViewTortue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lafay on 16/05/2017.
 */
public class ViewFeuilleAuto extends ViewFeuille{

    ControleurFeuilleAuto controleurFeuilleAuto;

    JToolBar menu;
    JButton btnAjouter;
    public ViewFeuilleAuto(ControleurFeuilleAuto controleurFeuilleAuto) {
        super(controleurFeuilleAuto);

        this.controleurFeuilleAuto = controleurFeuilleAuto;
        //ajout d'une toolbar
        menu = new JToolBar();
        btnAjouter = new JButton("Ajouter Tortue");
        menu.add(btnAjouter);

        this.getContentPane().add(menu, BorderLayout.NORTH);

        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleurFeuilleAuto.ajouter();
            }
        });

    }


}
