package vue;

import controleur.ControleurFeuilleAuto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lafay on 16/05/2017.
 */
public class ViewFeuilleAuto extends ViewFeuille{

    public ViewFeuilleAuto(ControleurFeuilleAuto controleurFeuilleAuto) {
        super(controleurFeuilleAuto);

        this.setTitle("Automatique");

        //ajout d'une toolbar
        JToolBar menu = new JToolBar();
        JButton btnAjouter = new JButton("Ajouter Tortue");
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
