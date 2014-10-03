package part2_ecomm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class ButtonCommerce implements ActionListener, KeyListener, ContainerListener, MouseListener {

	private FenetreComm fen;
	
	private JScrollPane pan;
	
	private JTextArea txt1_l;
	
	private JTextArea txt2_cd;
	
	private JTextField prix1;
	private JList list;
	
	
	public ButtonCommerce(FenetreComm f){
		fen =f;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		
		//La TextArea txt_l est initialise ici
		txt1_l =fen.getQuantLivreTA();
		
		// ici on met dans un String ce qu'on a entre dans la TextArea du livre
		String qteLivre;
		qteLivre = fen.getLivreq();
		
		if(command=="Mettre dans le panier" ){
			if(qteLivre!=null && !fen.getQuantLivreTA().getText().equals("")){
				//puis on convertit le  String en Int
				int qte = Integer.parseInt(qteLivre);
				//on incremente de +1
				qte = qte+1;
				//on remet dans un string
				String nvlqLivre = String.valueOf(qte);
				// on edite la TextArea
				txt1_l.setText(nvlqLivre); // pour ajouter a ce qui est deja
				
				//ici on fait la multiplication par 15 pour obtenir le prix
				prix1 =fen.getPrixLivre();
				String price = prix1.getText();
				int inPrix = Integer.parseInt(price);
				inPrix = qte*15;
				String nvPrice = String.valueOf(inPrix);
				prix1.setText(nvPrice);
			}
			else{
				int qte = 1;
				//on remet dans un string
				String nvlqLivre = String.valueOf(qte);
				// on edite la TextArea
				txt1_l.setText(nvlqLivre);
				
			}
		}
		else{
			System.out.println(command);// c'est le bouton "Mettre dans le panier qui est actif la
		}
		
	}
	
	public String ajout(){
		String ajout;
		ajout =fen.getQuantLivreTA().getText();
		return ajout;
	}

	//Actif quand sur la touche : tappe (presse puis relachée)
	public void keyTyped(KeyEvent e) {
		
		//e.getCode recupere le code de la touche presse
		System.out.println(e.getKeyCode());
		System.out.println("KEY LISTENER ACTIF");
		
	}

	//presse
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		System.out.println("KEY LISTENER ACTIF");
		
	}

	//relache
	public void keyReleased(KeyEvent e) {
		
		System.out.println(e.getKeyCode());
		System.out.println("KEY LISTENER ACTIF");
		
	}

	
	public void componentAdded(ContainerEvent e) {
		
		
	}


	public void componentRemoved(ContainerEvent e) {
		
		
	}

	//KEY LISTENER TESTE SUR LE BOUTON "Mettre dans le panier"
	//la souris a ete pressee puis relachee
	public void mouseClicked(MouseEvent e) {
		String param = e.paramString();
		System.out.println(e.paramString());
		
		txt2_cd=fen.getQuantCdTA();
		
		String qteCd = fen.getStringQuantCd();
		
		/*txt1_l =fen.getQuantLivreTA();
		
		// ici on met dans un String ce qu'on a entre dans la TextArea du livre
		String qteLivre;
		qteLivre = fen.getLivreq();
		
		if(e.getClickCount()==1){
			System.out.println("Supposons qu'on clique 1 fois sur le 1er element");
			if(qteLivre!=null && !fen.getQuantLivreTA().getText().equals("")){
				//puis on convertit le  String en Int
				int qte = Integer.parseInt(qteLivre);
				//on incremente de +1
				qte = qte+1;
				//on remet dans un string
				String nvlqLivre = String.valueOf(qte);
				// on edite la TextArea
				txt1_l.setText(nvlqLivre); // pour ajouter a ce qui est deja
				
				//ici on fait la multiplication par 15 pour obtenir le prix
				prix1 =fen.getPrixLivre();
				String price = prix1.getText();
				int inPrix = Integer.parseInt(price);
				inPrix = qte*15;
				String nvPrice = String.valueOf(inPrix);
				prix1.setText(nvPrice);
			}
			else{
				int qte = 1;
				//on remet dans un string
				String nvlqLivre = String.valueOf(qte);
				// on edite la TextArea
				txt1_l.setText(nvlqLivre);
				
			}
			
		}*/
		if(e.getClickCount()==2){
			System.out.println("Supposons qu'on clique 2 fois sur le 2eme element");
			if(qteCd!=null && !fen.getQuantCdTA().getText().equals("")){
				int cdInt = Integer.parseInt(qteCd);
				cdInt ++;
				String nvlQteCd = String.valueOf(cdInt);
				txt2_cd.setText(nvlQteCd);
			}
			else{
				int qtInit = 1;
				String qtStrCd = String.valueOf(qtInit);
				
				txt2_cd.setText(qtStrCd);
			}
			
		}
		
		//Ajout du Mouse Listener pour le Premier element de la JList
		if(fen.getIntoJlist().equals(fen.getMouse().equals("The Livre 15.0"))){
			System.out.println("PREMIER BOUTON CLIQUE");
		}
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
