package it.uninsubria.dista.dictionary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

public class testparola extends JFrame {

	private JPanel contentPane;
	ArrayList<String> elencoVerifica = new ArrayList<>();
	List<Definition> definitionLista;
	DefaultListModel<Term> model = new DefaultListModel<>();

	public testparola(ArrayList<String> cs) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 32, 267, 218);
		contentPane.add(panel);
		
		JList<Term> list = new JList<>( model );
		list.setBackground(SystemColor.menu);
		panel.add(list);
		
		JLabel lblNewLabel = new JLabel("PLAYER 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(82, 0, 107, 29);
		contentPane.add(lblNewLabel);
		
		int cont = 1;
		int size = cs.size();
		String testo;
		
		for (int i = 0; i < size; i++) {
			testo = cs.get(i);
			try {
				String contS = String.valueOf(cont);
				
				checkparola(testo);
				cont ++;
			} catch (ZipException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKey e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    }
		
		
		
		
		
     
		
		}

	public void checkparola(String parola) throws ZipException, IOException, InvalidKey {
		cercaParola cp = new cercaParola();
		Loader load=new Loader();
		String file_dizionario= "dict-it.oxt";
		File dizionario=new File(file_dizionario);
        Dictionary d=load.loadDictionaryFromFile(dizionario);
        ZipFile zf = new ZipFile(dizionario);
      
        
        Enumeration<? extends ZipEntry> entries = zf.entries();
        
        BufferedReader  in = new BufferedReader(new InputStreamReader(zf.getInputStream(zf.getEntry("dictionaries/th_it_IT_v2.dat")),"ISO8859-15"));
       
     
        String termine = parola;
             
			if (cp.ControlloFinale(termine)) {
			   
				model.addElement(d.getTerm(termine));
                 
                  }
    
			else {
				Term nt = new Term ("Parola non trovata");
				model.addElement(nt);
				
			}
			
	}
	}
	
	
	
	
	





