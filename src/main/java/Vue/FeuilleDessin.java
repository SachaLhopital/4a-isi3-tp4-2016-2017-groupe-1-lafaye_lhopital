package Vue;// package logo;

import Metier.ModeleTortue;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Titre :        Logo
 * Description :  Un exemple de programme graphique utilisant la celebre Tortue Logo
 * Copyright :    Copyright (c) 2000
 * Societe :      LIRMM
 * @author J. Ferber
 * @version 2.0
 */

public class FeuilleDessin extends JPanel {
	private ArrayList<ModeleTortue> tortues; // la liste des tortues enregistrees
	
	public FeuilleDessin() {
		tortues = new ArrayList<ModeleTortue>();
	}

	/*public void addTortue(ModeleTortue tortue) {
		VueTortue o = new VueTortue(tortue,this);
		tortues.add(tortue);
	}*/

	public void reset() {
		for (Iterator it = tortues.iterator();it.hasNext();) {
			ModeleTortue t = (ModeleTortue) it.next();
			t.reset();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Color c = g.getColor();
		
		Dimension dim = getSize();
		g.setColor(Color.white);
		g.fillRect(0,0,dim.width, dim.height);
		g.setColor(c);

		showTurtles(g);
	}
	
	public void showTurtles(Graphics g) {
		for(Iterator it = tortues.iterator();it.hasNext();) {
			VueTortue t = (VueTortue) it.next();
			t.dessiner(g);
		}
	}
}
