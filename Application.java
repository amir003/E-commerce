import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListModel;


public class Application extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JFrame cadre;
	
	
	

	public Application(){
		cadre = new JFrame("e-Commerce");
		Container bigPanel = cadre.getContentPane();
		
		GridLayout layout = new GridLayout(0,2);
		bigPanel.setLayout(layout);
		
		final ArrayList<Tab> tabList = new ArrayList<Tab>();
		Tab tab1 = new Tab();
		tabList.add(tab1);
		Tab tab2 = new Tab();
		tabList.add(tab2);
		
		
		/* TabbedPane */
		
		final JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon icon = null;
		

		/* premier panier */
		
		tabbedPane.addTab("Panier", icon, tabList.get(0).getPannel(), "Votre premier panier");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		
		/* fin premier panier */
		
		
		/* second panier */

		tabbedPane.addTab("Panier", icon, tabList.get(1).getPannel(), "Votre second panier");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		/* fin second panier */
		
		
		/* Fin tabbedPane */
		
		
		
		
		/* Panel de la liste */
		
		JPanel listePrincipal = new JPanel(new BorderLayout());
		JPanel liste = new JPanel();
		BoxLayout layoutliste = new BoxLayout(liste, BoxLayout.Y_AXIS);
		GridLayout layoutliste1 = new GridLayout(0,1);
		
		liste.setLayout(layoutliste1);
		
		
		
		
		
		
		
		
		JLabel listeLabel = new JLabel("Catalogue");
		listeLabel.setMaximumSize(new Dimension(10, 10));
		ListModel<String> model = new DefaultListModel<String>();
		final JList<String> listePanier = new JList<String>(model);
		JButton boutonListe = new JButton("Mettre dans le panier");
		/*boutonListe.addMouseListener(new java.awt.event.MouseAdapter() {
		      public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	  addElement(tabbedPane.getTabComponentAt(tabbedPane.getSelectedIndex()), price);
		      }
		  }); */
		
		
		liste.add(listePanier);
		listePrincipal.add(listeLabel,BorderLayout.NORTH);
		listePrincipal.add(liste,BorderLayout.CENTER);
		listePrincipal.add(boutonListe,BorderLayout.SOUTH);
		Product livre = new Product("The Livre", 15);
		Product cd = new Product("The CD", 15);
		Product dvd = new Product("The DVD", 15);
		Product blueray = new Product("The BlueRay", 15);
		Product phone = new Product("The Phone", 15);
		Product phonetel = new Product("Telephone tres cher", 400);
		
		final Catalogue cat = new Catalogue();
		
		cat.addProduitDansCatalogue(livre);
		cat.addProduitDansCatalogue(cd);
		cat.addProduitDansCatalogue(dvd);
		cat.addProduitDansCatalogue(blueray);
		cat.addProduitDansCatalogue(phone);
		cat.addProduitDansCatalogue(phonetel);
		
	    for (Product p : cat.getCatalogue())
	    	((DefaultListModel<String>)listePanier.getModel()).addElement(p.getDescription() +" "+ Double.toString(p.getPrix()));

		
boutonListe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = listePanier.getSelectedIndex();
				Product p = cat.getCatalogue().get(i);
				int j = tabbedPane.getSelectedIndex();
				if (!tabList.get(j).hasProduct(p)){	
					tabList.get(j).addtolist(p);
					addElement(tabList.get(j).getPannel(), p.getDescription() , p.getPrix());
					tabList.get(j).getPannel().updateUI();
				}
			}
		});
		
		
		/* Fin Panel de la liste */

		bigPanel.add(tabbedPane);
		bigPanel.add(listePrincipal);
		
		cadre.setContentPane(bigPanel);
		cadre.pack();
		cadre.setVisible(true);
		cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	

	private void addElement(JPanel panel, String name, Double Price){
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout());
		
		pane.add(new JLabel(name));
		
		JTextField txt = new JTextField();
		txt.setColumns(5);
		pane.add(txt);
		
		pane.add(new JLabel(Double.toString(Price)+"€"));
		
		panel.add(pane);
	}



}
