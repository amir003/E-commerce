import java.util.ArrayList;

import javax.swing.JPanel;


public class Tab {
	private JPanel panel;
	private ArrayList<Product> list;
	
	public Tab(){
		panel = new JPanel();
		list = new ArrayList<Product>();
	}
	
	
	public void addtolist(Product p){
		list.add(p);
	}
	
	public JPanel getPannel(){
		return this.panel;
	}
	
	public Boolean hasProduct(Product p){
		return list.contains(p);
	}
}
