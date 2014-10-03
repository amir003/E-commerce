package part2_ecomm;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

public class FenetreComm {
	private JTextArea quantite_livre;
	private JTextArea quantite_cd;
	private JTextArea quantite_dvd;
	private JTextField label_prix_livre;
	private JList jlst;
	
	
	public String getStringQuantCd(){
		String res = quantite_cd.getText();
		return res;
	}
	
	public JTextArea getQuantCdTA(){
		return quantite_cd;
	}
	
	public JTextArea getQuantDvdTA(){
		return quantite_dvd;
	}
	
	public String getStringQuantDvd(){
		String res = quantite_dvd.getText();
		return res;
	}
	
	
	public JList getList(){
		return jlst;
	}
	
	public MouseListener[] mouse; 
	
	public MouseListener[] getMouse(){
		return mouse;
	}
	
	public MouseListener[] getIntoJlist(){
		
		mouse = jlst.getMouseListeners();
		return mouse;
	}
	
	public JTextField getPrixLivre(){
		return label_prix_livre;
	}
	
	public String getLivreq(){
		String res = quantite_livre.getText();
		return res;
	}
	
	
	public JTextArea getQuantLivreTA(){
		return quantite_livre;
	}
	
	public FenetreComm(){
		JFrame frame = new JFrame("eCommerce");
		
		JPanel principal = new JPanel();
		principal.setLayout(new GridLayout());
		
		//Lien avec ActionListener
		ButtonCommerce list = new ButtonCommerce(this);
		
		JPanel panierPrincipal = new JPanel(new BorderLayout());
		JPanel panier = new JPanel(); 
		panier.setLayout(new GridBagLayout());
		JLabel label_panier = new JLabel("Panier \n");
		label_panier.setForeground(Color.BLUE);
		// Premier produit
		JLabel label_livre = new JLabel("The Livre");
		label_livre.setPreferredSize(new Dimension(70,20));
		quantite_livre = new JTextArea();
		quantite_livre.setPreferredSize(new Dimension(70,20));
		label_prix_livre = new JTextField("15");
		//label_prix_livre.addActionListener(list);
		label_prix_livre.setEditable(false);
		label_prix_livre.setPreferredSize(new Dimension(70,20));
		
		//2eme produit
		JLabel label_cd = new JLabel("The CD");
		label_cd.setPreferredSize(new Dimension(70,20));
		quantite_cd = new JTextArea();
		quantite_cd.setPreferredSize(new Dimension(70,20));
		JTextField label_prix_cd = new JTextField("15");
		label_prix_cd.setEditable(false);
		label_prix_cd.setPreferredSize(new Dimension(70,20));
		
		//3eme produit 
		JLabel label_dvd = new JLabel("The DVD");
		label_dvd.setPreferredSize(new Dimension(70,20));
		quantite_dvd = new JTextArea();
		quantite_dvd.setPreferredSize(new Dimension(70,20));
		JTextField label_prix_dvd = new JTextField("15");
		label_prix_dvd.setEditable(false);
		label_prix_dvd.setPreferredSize(new Dimension(70,20));
		
		JButton commander = new JButton("Commander le panier");
		//ACTION LISTENER
		commander.addActionListener(list);
		//KEY LISTENER
		//commander.addKeyListener(list);
		//
		//MOUSE LISTENER
		//commander.addMouseListener(list);
		panier.add(label_livre, new GBC(0, 0).setAnchor(GBC.EAST));
		panier.add(quantite_livre, new GBC(1, 0).setAnchor(GBC.EAST));
		panier.add(label_prix_livre, new GBC(2, 0).setAnchor(GBC.EAST));
		
		panier.add(label_cd, new GBC(0, 1).setAnchor(GBC.EAST));
		panier.add(quantite_cd, new GBC(1, 1).setAnchor(GBC.EAST));
		panier.add(label_prix_cd, new GBC(2, 1).setAnchor(GBC.EAST));
		
		panier.add(label_dvd, new GBC(0, 2).setAnchor(GBC.EAST));
		panier.add(quantite_dvd, new GBC(1, 2).setAnchor(GBC.EAST));
		panier.add(label_prix_dvd, new GBC(2, 2).setAnchor(GBC.EAST));
		
		/*
	      cp.add(face, new GBC(1, 0).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
	      cp.add(sizeLabel, new GBC(0, 1).setAnchor(GBC.EAST));
	      cp.add(size, new GBC(1, 1).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
	      cp.add(bold, new GBC(0, 2, 2, 1).setAnchor(GBC.CENTER).setWeight(100, 100));
	      cp.add(italic, new GBC(0, 3, 2, 1).setAnchor(GBC.CENTER).setWeight(100, 100));
	      cp.add(sample, new GBC(2, 0, 1, 4).setFill(GBC.BOTH).setWeight(100, 100));
	      */
		//
		
		//panier.add(label_livre);
		//panier.add(quantite_livre);
		//panier.add(label_prix_livre);
		
		//panier.add(label_cd);
		//panier.add(quantite_cd);
		//panier.add(label_prix_cd);
		
		panierPrincipal.add(BorderLayout.NORTH,label_panier);
		panierPrincipal.add(BorderLayout.CENTER,panier);
		panierPrincipal.add(BorderLayout.SOUTH,commander);
		
		
		JPanel cataloguePrinc = new JPanel(new BorderLayout());
		JLabel label_catalogue = new JLabel("Catalogue");	
		label_catalogue.setForeground(Color.BLUE);
		
		JPanel catalogue = new JPanel();
		//catalogue.setLayout(new GridLayout(3,3));
		
		//JTextArea listElement = new JTextArea("The Livre 15.0");
		//faire une liste defilante
		String[] str= {"The Livre 15.0","The Cd 15.0","The DVD 15.0","The BlueRay 15.0","The Phone 15.0"};
		jlst = new JList<>(str);
		
		
		
		
		
		//ajout de le JList via le ContainerListener
		jlst.addContainerListener(list);
		
		JScrollPane scrol = new JScrollPane(jlst);
		
		//KEY LISTENER
		//ajouter la Scroll a KeyListener ?? Comme ça ? --> Marche pas 
		//scrol.addKeyListener(list);
		//MOUSE LISTENER
		jlst.addMouseListener(list);
		
		catalogue.add(scrol);
		//listElement.setSize(50,50);
		JButton dansPanier = new JButton("Mettre dans le panier");
		dansPanier.addActionListener(list);
		//catalogue.add(label_catalogue);
		//catalogue.add(listElement);
		//catalogue.add(dansPanier);
		cataloguePrinc.add(BorderLayout.NORTH,label_catalogue);
		cataloguePrinc.add(BorderLayout.CENTER,catalogue);
		cataloguePrinc.add(BorderLayout.SOUTH,dansPanier);
		
		
		
		principal.add(panierPrincipal);
		principal.add(cataloguePrinc);
		frame.add(principal);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
		
		
	}
}
