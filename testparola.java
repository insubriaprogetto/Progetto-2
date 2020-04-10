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
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class testparola extends JFrame {

	private JPanel contentPane;
	ArrayList<String> elencoVerifica = new ArrayList<>();
	
	JTextArea textArea = new JTextArea();
	
	

	public testparola(ArrayList<String> cs) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textArea.setEditable(false);
		
		
		textArea.setBounds(10, 11, 414, 239);
		contentPane.add(textArea);
		textArea.append("---PLAYER1---");
		textArea.append("\n");
		textArea.append("");
		
		int size = cs.size();
		String testo;
		
		for (int i = 0; i < size; i++) {
			testo = cs.get(i);
			try {
				checkparola(testo);
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
			//textArea.append("\n " + cs.get(i));
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
	    String giusta = null;
        String temp;
        int cont = 0;
        

	    /*  
        while( (temp= in.readLine()) != null) {
        	String[] result;
		   		result = temp.split("\\|");
	*/
			if (cp.ControlloFinale(termine)) {
				//result[0];
				/*
				Term t = new Term(termine);
				
				String s = t.toString();
		
				textArea.append(s);
			*/
				System.out.println( d.getTerm(termine));
				
				
			
		
       
       
    }
			else {
				
				System.out.println(termine + "  parola non trovata");
			}
       
       
    }
		
	}
	
	
	
	
	
	





