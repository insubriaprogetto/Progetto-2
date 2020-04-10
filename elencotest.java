package it.uninsubria.dista.dictionary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class elencotest extends JFrame {

	private JPanel contentPane;
    ArrayList<String> brungi = new ArrayList<>();
    
    
    
		public elencotest() {
	   
		String parola = null;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 11, 414, 239);
		contentPane.add(textArea);
	   /* int size = el.GetElenco().size();	
		brungi = el.GetElenco();
	    for ( int i = 0; i < size; i++) {
	    	
	    	
	    	textArea.append(brungi.get(i));
	    }	
	    */	
	    textArea.append("---PLAYER---");
		TabellaGioco el = new TabellaGioco(brungi);
	    int size = brungi.size();
	    for(int i = 0; i < size; i++) {
	    	textArea.append("\n" + brungi.get(i));
	    	
	    }
	}
}
