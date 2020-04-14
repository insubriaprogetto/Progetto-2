package it.uninsubria.dista.dictionary;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.GridLayout;
import java.awt.Color;

public class testparola extends JFrame {

	private JPanel contentPane;
	ArrayList<String> elencoVerifica = new ArrayList<>();
	ArrayList<String> giuste = new ArrayList<>();
	ArrayList<String> sbagliate = new ArrayList<>();
	List<Definition> definitionLista;
	DefaultListModel<Term> model = new DefaultListModel<>();
	JLabel daticorretti = new JLabel();
	JLabel datiscorretti = new JLabel();
	
	
	
	JPanel panel = new JPanel();
	int cont = 1;
	int intg = 0;
	int ints = 0;
	
	public testparola(ArrayList<String> cs) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 664, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel.setBounds(10, 29, 628, 218);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("PLAYER 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(223, 0, 107, 29);
		contentPane.add(lblNewLabel);
	
		
		JList<Term> list = new JList<>( model );
		list.setBackground(SystemColor.menu);
		panel.add(list);
		
				JScrollPane sc = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				panel.add(sc);
				JLabel titolocorrette = new JLabel("PAROLE CORRETTE");
				titolocorrette.setForeground(Color.GREEN);
				titolocorrette.setBounds(10, 258, 126, 14);
				contentPane.add(titolocorrette);
				
				
				daticorretti.setBounds(146, 258, 46, 14);
				contentPane.add(daticorretti);
				
				JLabel titolosbagliate = new JLabel("PAROLE SBAGLIATE");
				titolosbagliate.setForeground(Color.RED);
				titolosbagliate.setBounds(251, 258, 131, 14);
				contentPane.add(titolosbagliate);
				
				
				datiscorretti.setBounds(392, 258, 46, 14);
				contentPane.add(datiscorretti);
	
		
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
      
	
        String s;
			if (cp.ControlloFinale(termine)) {
				// termine.toUpperCase()
				s = String.valueOf(cont);
				giuste.add(termine);
				Term nt1 = new Term(s + " - " + termine.toUpperCase() + "\n");
				model.addElement(nt1);
				model.addElement(d.getTerm(termine));
                 cont++;
                 intg ++;
                  }
    
			else {
				s = String.valueOf(cont);
				sbagliate.add(termine);
				Term nt = new Term (s + " - " + termine.toUpperCase() + "\n");
				Term nt1 = new Term ("Parola non trovata");
				model.addElement(nt);
				model.addElement(nt1);
				cont++;
				ints++;
			}
		    
			String stringg = String.valueOf(intg);
			daticorretti.setText(": " + stringg);
			String strings = String.valueOf(ints);
			datiscorretti.setText(": " + strings);
			
			
	}
   }
	

		 
	   
	
	
	
	
	
	





