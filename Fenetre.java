import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Fenetre extends JFrame {
	private JPanel container = new JPanel();
	private JTextField jtf = new JTextField("");
	private JTextField jtf2 = new JTextField("");
	private JTextField jtf3 = new JTextField("");
	private JLabel label = new JLabel("+");
	private JButton label2 = new JButton("=");
	
public Fenetre(){
  this.setTitle("Calculatrice");
  this.setSize(400, 100);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setLocationRelativeTo(null);
  
  container.setLayout(new BorderLayout());
  JPanel top = new JPanel();
  Font police = new Font("Arial", Font.BOLD, 14);
  jtf.setFont(police);
  jtf.setPreferredSize(new Dimension(70, 30));
  jtf.setForeground(Color.DARK_GRAY);
  jtf2.setFont(police);
  jtf2.setPreferredSize(new Dimension(70, 30));
  jtf2.setForeground(Color.DARK_GRAY);
  jtf3.setFont(police);
  jtf3.setPreferredSize(new Dimension(70, 30));
  jtf3.setForeground(Color.DARK_GRAY);
  label2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
          jButton1MouseClicked(evt);
      }
  });
  
  top.add(jtf);
  top.add(label);
  top.add(jtf2);
  top.add(label2);
  top.add(jtf3);

  container.add(top, BorderLayout.NORTH);
  this.setContentPane(container);
  this.setVisible(true);            
}

private void jButton1MouseClicked(MouseEvent evt) {
	String s1 = jtf.getText();
	String s2 = jtf2.getText();
	try{
	int i1 = Integer.parseInt(s1);
	int i2 = Integer.parseInt(s2);
	jtf3.setText(Integer.toString(i1+i2));
	}
	catch(Exception e){
		jtf3.setText("Error");		
	}
}


}
