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
    ArrayList<String> sbagliate = new ArrayList<>();
	ArrayList<String> doppie = new ArrayList<>();
	ArrayList<String> confrontaL = new ArrayList<>();
	ArrayList<Integer> listanumero = new ArrayList<>(); 
	List<Definition> definitionLista;
	List<Definition> listaSbagliate;
	List<Definition> listaDoppie;
	DefaultListModel<Term> model = new DefaultListModel<>();
	DefaultListModel<Term> modelD = new DefaultListModel<>();
	DefaultListModel<Term> modelS = new DefaultListModel<>();
	JLabel daticorretti = new JLabel();
	JLabel datiscorretti = new JLabel();
	JLabel doppieL = new JLabel();
	JLabel totpunti = new JLabel();
	Contapunti AP = new Contapunti();
	
	JPanel panel = new JPanel();
	int cont = 1;
	int contS = 1;
	int intg = 0;
	int ints = 0;
	int Pdoppie = 0;
	
	public testparola(ArrayList<String> cs) throws ZipException, IOException, InvalidKey {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 604, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setForeground(SystemColor.menu);
		
		
		panel.setBounds(10, 60, 379, 243);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("PLAYER 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(223, 0, 107, 29);
		contentPane.add(lblNewLabel);
	
		
		JList<Term> list = new JList<>( model );
		list.setForeground(SystemColor.desktop);
		list.setBackground(SystemColor.menu);
		panel.add(list);
		
				JScrollPane sc = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				panel.add(sc);
				JLabel titolocorrette = new JLabel("PAROLE CORRETTE");
				titolocorrette.setForeground(Color.GREEN);
				titolocorrette.setBounds(10, 34, 126, 14);
				contentPane.add(titolocorrette);
				
				
				daticorretti.setBounds(107, 324, 46, 14);
				contentPane.add(daticorretti);
				
				JLabel titolosbagliate = new JLabel("PAROLE SBAGLIATE");
				titolosbagliate.setForeground(Color.RED);
				titolosbagliate.setBounds(399, 172, 179, 14);
				contentPane.add(titolosbagliate);
				
				
				datiscorretti.setBounds(233, 324, 46, 14);
				contentPane.add(datiscorretti);
				
				JLabel titolodoppie = new JLabel("PAROLE DOPPIE");
				titolodoppie.setForeground(Color.RED);
				titolodoppie.setBounds(399, 34, 179, 14);
				contentPane.add(titolodoppie);
				
				
				doppieL.setBounds(397, 324, 46, 14);
				contentPane.add(doppieL);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(399, 60, 179, 106);
				contentPane.add(panel_1);
				panel_1.setLayout(new GridLayout(1, 0, 0, 0));
				
				JList<Term> list_1 = new JList<>( modelD );
				list_1.setBackground(SystemColor.menu);
				list_1.setForeground(SystemColor.desktop);
				panel_1.add(list_1);
				JScrollPane sc1 = new JScrollPane(list_1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				panel_1.add(sc1);
				
				JPanel panel_2 = new JPanel();
				panel_2.setBounds(399, 197, 179, 106);
				contentPane.add(panel_2);
				panel_2.setLayout(new GridLayout(1, 0, 0, 0));
				
				JList<Term> list_2 = new JList<>( modelS );
				list_2.setBackground(SystemColor.menu);
				list_2.setForeground(SystemColor.desktop);
				panel_2.add(list_2);
				JScrollPane sc2 = new JScrollPane(list_2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				panel_2.add(sc2);
				
				JLabel lblNewLabel_1 = new JLabel("CORRETTE TOT");
				lblNewLabel_1.setBounds(10, 324, 102, 14);
				contentPane.add(lblNewLabel_1);
				
				JLabel lblSbagliateTot = new JLabel("SBAGLIATE TOT:");
				lblSbagliateTot.setBounds(144, 324, 93, 14);
				contentPane.add(lblSbagliateTot);
				
				JLabel lblDoppieTot = new JLabel("DOPPIE TOT:");
				lblDoppieTot.setBounds(315, 324, 80, 14);
				contentPane.add(lblDoppieTot);
				
				JLabel lblNewLabel_2 = new JLabel("TOT PUNTI");
				lblNewLabel_2.setBounds(453, 324, 69, 14);
				contentPane.add(lblNewLabel_2);
				
				
				totpunti.setBounds(532, 324, 46, 14);
				contentPane.add(totpunti);
				
				int size = cs.size();
				String parola;
				String testP;
				String seconda;
				for (int i = 0; i < size; i++) {
				
					testP =cs.get(i);
					confrontaL.add(testP);	
			      
				}
				
				
				for (int i = 0; i < size; i++) {
					parola = cs.get(i);
					
					for(int k = i + 1; k < size; k++) { 
					  seconda = confrontaL.get(k);
						if (parola.equals(seconda)) {
				 // cc.add(c + " ---> PAROLA DOPPIA");
				       confrontaL.remove(i);
				       confrontaL.add(i, "-");
				       doppie.add(parola);
				    	
					}
				
				}
				}
				
				int sizeG = confrontaL.size();
				String parolaG;
				for (int g = 0; g < sizeG; g++) {
					
					parolaG = confrontaL.get(g);
					checkparola(parolaG);
					
				}
	
				Term nD;
				String PDoppie;
				int sizeD = doppie.size();
				for (int m = 0; m < sizeD; m++) {
					Pdoppie++;
                    PDoppie = doppie.get(m);
                   if (PDoppie.equals("")) {} else {
                    nD = new Term(Pdoppie + " - " + PDoppie.toUpperCase() + "\n");
                    modelD.addElement(nD);
                   }
				}
				
				String stringss = String.valueOf(Pdoppie);
				doppieL.setText(stringss);
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
        int totale = 0; 
        int Punt = 0;
	
        String s;
			if (cp.ControlloFinale(termine)) {
				
				s = String.valueOf(cont);
			    Punt = AP.AssegnaPunti(termine);
			    listanumero.add(Punt);
			    Term nt1 = new Term(s + " - " + termine.toUpperCase()+ "  (" + "PUNTI: " + Punt + ")" + "\n");
				model.addElement(nt1);
				model.addElement(d.getTerm(termine));
                cont++;
                intg ++;
               
			   
                  }
    
			else {
				s = String.valueOf(contS);
				//sbagliate.add(termine);
				if(termine.equals("-") || termine.equals("")) {}else {
				Term nt = new Term (s + " - " + termine.toUpperCase() + "\n");
				//Term nt1 = new Term ("Parola non trovata");
				modelS.addElement(nt);
				//modelS.addElement(nt1);
				contS++;
				ints++;
				}
			}
			 int sizeT = listanumero.size();
			 for(int i = 0; i < sizeT; i++) {
				 
				 int numero = listanumero.get(i);
				 totale += numero;
			 }
			String stringg = String.valueOf(intg);
			daticorretti.setText(": " + stringg);
			String strings = String.valueOf(ints);
			datiscorretti.setText(": " + strings);
			String totS = String.valueOf(totale);
			totpunti.setText(totS);
			
	}
   }
	

		 
	   
	
	
	
	
	
	





