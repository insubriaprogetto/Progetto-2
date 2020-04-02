package vario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class finestra extends JFrame {

	//creazione variabili
	
	private JPanel contentPane;
	private JTextField textField;
	 LinkedList<Integer> listint = new LinkedList<Integer>();
	 ArrayList<String[]> listadado = new ArrayList<>();
	 ArrayList<String> elenco = new ArrayList<>();
	 ArrayList<String> stringabottoni = new ArrayList<>();
	 LinkedList<JButton> elencobottone = new LinkedList<>();
	 
	  String random = null;
	  int numero;
	  int numerodado;
	  int slot;
	  Random rand = new Random();
	  String[] Dado1 = {"B","A","O","O","Q","M"};
	  String[] Dado2 = {"U","T","E","S","L","P"};
	  String[] Dado3 = {"I","G","E","N","V","T"};
	  String[] Dado4 = {"O","U","L","I","E","R"};
	  String[] Dado5 = {"A","C","E","S","L","R"};
	  String[] Dado6 = {"R","A","T","I","B","L"};
	  String[] Dado7 = {"S","M","I","R","O","A"};
	  String[] Dado8 = {"I","S","E","E","F","H"};
	  String[] Dado9 = {"S","O","T","E","N","D"};
	  String[] Dado10= {"A","I","C","O","F","R"};
	  String[] Dado11= {"V","N","Z","D","A","E"};
	  String[] Dado12= {"I","E","A","T","A","O"};
	  String[] Dado13= {"O","T","U","C","E","N"};
	  String[] Dado14= {"N","O","L","G","U","E"};
	  String[] Dado15= {"D","C","M","P","A","E"};
	  String[] Dado16= {"E","R","I","N","S","H"};
	  JButton test = new JButton();
	  
	JButton btn2  = new  JButton();
	JButton btn1  = new  JButton();
	JButton btn3  = new  JButton();
    JButton btn4  = new  JButton();
    JButton btn5  = new  JButton();
    JButton btn6  = new  JButton();
    JButton btn7  = new  JButton();
    JButton btn8  = new  JButton();
    JButton btn9  = new  JButton();
    JButton btn10 = new  JButton();
    JButton btn11 = new  JButton();
  	JButton btn12 = new  JButton();
  	JButton btn13 = new  JButton();
  	JButton btn14 = new  JButton();
  	JButton btn15 = new  JButton();
  	JButton btn16 = new  JButton();
	  String a, b, c, d, e, f, g, h, i, l, m, n, o, p, q, r; 
	  int cont = 1;  
	  private JTextField textField_1;

	  // Metodo per un un numero casuale 
	  
	  public int lancia() {  
	    int random = rand.nextInt(6);
	    return random;
	}

	  // metodo per estrarre una lettera casuale da una dado casuale
	public  void estrazione() {
		
		listadado.add(Dado1);  
		listadado.add(Dado2);
		listadado.add(Dado3);
		listadado.add(Dado4);
		listadado.add(Dado5);
	    listadado.add(Dado6);
	    listadado.add(Dado7);
	    listadado.add(Dado8);
	    listadado.add(Dado9);
	    listadado.add(Dado10);
	    listadado.add(Dado11);  
		listadado.add(Dado12);
		listadado.add(Dado13);
		listadado.add(Dado14);
		listadado.add(Dado15);
	    listadado.add(Dado16);
	   
	    
	    System.err.println("ESTRAZIONE LETTERE");
	
	    // metto 16 numeri casuali in una lista 
	    
	    for (int i = 0; i < 16 ; i++) {
			int numero = lancia();
			listint.add(numero);
			}
		// cicla finche le liste non sono vuote e mette le lettere casuali in una lista
		while(!listint.isEmpty() && !listadado.isEmpty()) {
			int slot = listadado.size();
			int numerodado = rand.nextInt(slot); 
			int numero2 = listint.getFirst();
			String[] dadostandar =  listadado.get(numerodado);
		    String random = dadostandar[numero2];
		    elenco.add(random);
		    cont++;
		    listint.removeFirst();
		    listadado.remove(numerodado);
		    
		    
		}
		
		// prendo le lettere casuali create prima dalla lista e 
		//le associo ad uan stringa e le aggiungo ad un altra lista
	     a = elenco.get(0);
	     stringabottoni.add(a);
	     b = elenco.get(1);
	     stringabottoni.add(b);
	     c = elenco.get(2);
	     stringabottoni.add(c);
		 d = elenco.get(3);
		 stringabottoni.add(d);
		 e = elenco.get(4);
		 stringabottoni.add(e);
		 f = elenco.get(5);
		 stringabottoni.add(f);
		 g = elenco.get(6);
		 stringabottoni.add(g);
		 h = elenco.get(7);
		 stringabottoni.add(h);
		 i = elenco.get(8);
		 stringabottoni.add(i);
		 l = elenco.get(9);
		 stringabottoni.add(l);
		 m = elenco.get(10);
		 stringabottoni.add(m);
		 n = elenco.get(11);
		 stringabottoni.add(n);
		 o = elenco.get(12);
		 stringabottoni.add(o);
		 p = elenco.get(13);
		 stringabottoni.add(p);
		 q = elenco.get(14);
		 stringabottoni.add(q);
		 r = elenco.get(15);
		 stringabottoni.add(r);
		
	    
		}
	
// creazione JFrame
	
	public finestra() {
		estrazione();
		matrice(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Francesco\\Desktop\\unnamed.png"));
		lblNewLabel.setBounds(-16, 0, 488, 132);
		contentPane.add(lblNewLabel);
		
		
    	
    	
    	
    	
        
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(e.getSource()== btn1) {
					test.setBackground(Color.lightGray);
				          
					   
					
					if(valido(btn5)) {
					    
						 btn5.setEnabled(false);
					 	
					} else {btn5.setEnabled(true);}
					
					if (valido(btn6)) {
						
						btn6.setEnabled(false);
						
				    } else {btn6.setEnabled(true);}
					
	       			   if(valido(btn2)) {
	       				   
	       				   btn2.setEnabled(false);
	       				   
	       			   } else {btn2.setEnabled(true);}
					    
					    btn1.setEnabled(false);
					    btn4.setEnabled(false);           
						btn7.setEnabled(false);         
						btn8.setEnabled(false);        
						btn9.setEnabled(false);           
						btn10.setEnabled(false);         
						btn11.setEnabled(false);         
						btn12.setEnabled(false);           
						btn13.setEnabled(false);           
						btn14.setEnabled(false);        
						btn15.setEnabled(false);           
						btn16.setEnabled(false);         
						btn3.setEnabled(false);
					
					   
				btn1.setBackground(Color.lightGray);
					   textField_1.setText(textField_1.getText() + btn1.getText());
					 
					}
				
			}
		});
		btn1.setBounds(134, 173, 51, 45);
		contentPane.add(btn1);
		
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(e.getSource()== btn2) {
                        
					 if(valido(btn1)) {
						    
						 btn1.setEnabled(true);
					 	
					} else {btn1.setEnabled(false);}
					
					if (btn5.getColorModel()== test.getColorModel()) {
						
						btn5.setEnabled(false);
						
				    } else {btn5.setEnabled(true);}
					
	       			   if(btn6.getColorModel()== test.getColorModel()) {
	       				   
	       				   btn6.setEnabled(false);
	       				   
	       			   } else {btn6.setEnabled(true);}
	       			   
	       			 if(btn3.getColorModel()== test.getColorModel()) {
	       				   
	       				   btn3.setEnabled(false);
	       				   
	       			   } else {btn3.setEnabled(true);}
	       			
	       			 if(btn7.getColorModel()== test.getColorModel()) {
	       				   
	       				   btn7.setEnabled(false);
	       				   
	       			   } else {btn7.setEnabled(true);}
	       			   
	       			   
	       			   
					    btn3.setEnabled(true);
					    btn2.setEnabled(false);
					    btn4.setEnabled(false);           
						btn7.setEnabled(true);         
						btn8.setEnabled(false);        
						btn9.setEnabled(false);           
						btn10.setEnabled(false);         
						btn11.setEnabled(false);         
						btn12.setEnabled(false);           
						btn13.setEnabled(false);           
						btn14.setEnabled(false);        
						btn15.setEnabled(false);           
						btn16.setEnabled(false);         
						       
				      
					  textField_1.setText(textField_1.getText() + btn2.getText());
					  btn2.setBackground(Color.lightGray); 
				  }
				
			}
		});
		btn2.setBounds(189, 173, 51, 45);
		contentPane.add(btn2);
	
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(e.getSource()== btn3) {
					    btn1.setEnabled(false);
					    btn5.setEnabled(false);
					    btn3.setEnabled(false);
					    btn2.setEnabled(true);
					    btn4.setEnabled(true);           
						btn7.setEnabled(true);         
						btn8.setEnabled(false);        
						btn9.setEnabled(false);           
						btn10.setEnabled(false);         
						btn11.setEnabled(false);         
						btn12.setEnabled(false);           
						btn13.setEnabled(false);           
						btn14.setEnabled(false);        
						btn15.setEnabled(false);           
						btn16.setEnabled(false);    
					 
					 textField_1.setText(textField_1.getText() + btn3.getText());
					  btn3.setBackground(Color.lightGray); 
				  }
				  
				
			}
		});
		btn3.setBounds(244, 173, 51, 45);
		contentPane.add(btn3);
		
	
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(textField_1.getText() + btn4.getText());
				if(e.getSource()== btn4) {
					
					  btn4.setBackground(Color.lightGray); 
				  }
			}
		});
		btn4.setBounds(299, 173, 51, 45);
		contentPane.add(btn4);
		
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btn5) {
					textField_1.setText(textField_1.getText() + btn5.getText());
					  btn5.setBackground(Color.lightGray); 
				  }
			}
		});
		btn5.setBounds(134, 219, 51, 45);
		contentPane.add(btn5);
		
		
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btn6) {
					textField_1.setText(textField_1.getText() + btn6.getText());
					  btn6.setBackground(Color.lightGray); 
				  }
			}
		});
		btn6.setBounds(189, 219, 51, 45);
		contentPane.add(btn6);
		
		
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btn7) {
					textField_1.setText(textField_1.getText() + btn7.getText());
					  btn7.setBackground(Color.lightGray); 
				  }
			}
		});
		btn7.setBounds(244, 219, 51, 45);
		contentPane.add(btn7);
		
		
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btn8) {
					textField_1.setText(textField_1.getText() + btn8.getText());
					  btn8.setBackground(Color.lightGray); 
				  }
			}
		});
		btn8.setBounds(299, 219, 51, 45);
		contentPane.add(btn8);
		
		
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btn9) {
					textField_1.setText(textField_1.getText() + btn9.getText());
					  btn9.setBackground(Color.lightGray); 
				  }
			}
		});
		btn9.setBounds(134, 265, 51, 45);
		contentPane.add(btn9);
		
		
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btn10) {
					textField_1.setText(textField_1.getText() + btn10.getText());
					  btn10.setBackground(Color.lightGray); 
				  }
			}
		});
		btn10.setBounds(189, 265, 51, 45);
		contentPane.add(btn10);
		
		
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btn11) {
					textField_1.setText(textField_1.getText() + btn11.getText());
					  btn11.setBackground(Color.lightGray); 
				  }
			}
		});
		btn11.setBounds(244, 265, 51, 45);
		contentPane.add(btn11);
		
	
		btn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btn12) {
					textField_1.setText(textField_1.getText() + btn12.getText());
					  btn12.setBackground(Color.lightGray); 
				  }
			}
		});
		btn12.setBounds(299, 265, 51, 45);
		contentPane.add(btn12);
		
	
		btn13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btn13) {
					textField_1.setText(textField_1.getText() + btn13.getText());
					  btn13.setBackground(Color.lightGray); 
				  }
				
			}
		});
		btn13.setBounds(134, 311, 51, 45);
		contentPane.add(btn13);
		
		
		btn14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btn14) {
					textField_1.setText(textField_1.getText() + btn14.getText());
					  btn14.setBackground(Color.lightGray); 
				  }
			}
		});
		btn14.setBounds(189, 311, 51, 45);
		contentPane.add(btn14);
		
		
		btn15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btn15) {
					textField_1.setText(textField_1.getText() + btn15.getText());
					  btn15.setBackground(Color.lightGray); 
				  }
			}
		});
		btn15.setBounds(244, 311, 51, 45);
		contentPane.add(btn15);
		
		
		btn16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btn16) {
					textField_1.setText(textField_1.getText() + btn16.getText());
					  btn16.setBackground(Color.lightGray); 
				  }
			}
		});
		btn16.setBounds(299, 311, 51, 45);
		contentPane.add(btn16);
		
		JButton btnNewButton = new JButton("CONFERMA");
		btnNewButton.setBounds(360, 219, 105, 91);
		contentPane.add(btnNewButton);
		
		JLabel lblParoleTrovate = new JLabel("PAROLE TROVATE");
		lblParoleTrovate.setBounds(10, 155, 121, 14);
		contentPane.add(lblParoleTrovate);
		
		//btnN           4
		//btnR           5
		//btnE           6 
		//btnB_1         7
		//btnG_1         8
		//btnB           9
		//btnT_1         10
		//btnI_1         11
		//btnI           12
		//btnO           13
		//btnD_2         14
		//btnA           15
		//btnD_1         16
		//btnD           3
		//btnT           2
		//btnG           1
		
		// Associo ogni stringa presente nella lista ad un bottone della matrice
		
		btn4.setText(stringabottoni.get(0));                     
		btn5.setText(stringabottoni.get(1));
		btn6.setText(stringabottoni.get(2));
		btn7.setText(stringabottoni.get(3));
		btn8.setText(stringabottoni.get(4));
		btn9.setText(stringabottoni.get(5));
		btn10.setText(stringabottoni.get(6));
		btn11.setText(stringabottoni.get(7));
		btn12.setText(stringabottoni.get(8));
		btn13.setText(stringabottoni.get(9));
		btn14.setText(stringabottoni.get(10));
		btn15.setText(stringabottoni.get(11));
		btn16.setText(stringabottoni.get(12));
		btn3.setText(stringabottoni.get(13));
		btn2.setText(stringabottoni.get(14));
		btn1.setText(stringabottoni.get(15));
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 173, 102, 183);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(161, 142, 165, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);


		
	}
	
	// mette tutti i bottoni enabled(true)
  public void attiva() {
	  JButton j;
	  while(!(elencobottone.isEmpty())) {
		   
		 
		  j = elencobottone.getFirst();
		  j.setEnabled(true);
		  elencobottone.removeFirst();
	  }
	  
  }
  // metodo errato o da migliorare - verifica se i colori di due caselle sono uguali
  public  boolean  valido(JButton j) {
	  JButton k = new JButton();
	  k.setBackground(Color.lightGray);
	  ColorModel km = k.getColorModel();
	  ColorModel jm = j.getColorModel();
	  if (km == jm) {
		  return false;
	  }
	 return true;
  }
	  
  // metodo simile a quello di sopra
	  public void controlloColore() {
		  
		  JButton j = new JButton();
		  JButton s;
		  
		  j.setBackground(Color.lightGray);
		  while (!(elencobottone.isEmpty())) {
			  s = elencobottone.getFirst();
		  if(s.getColorModel() == j.getColorModel()) {
			  s.setEnabled(false);
			  elencobottone.removeFirst();
			 
			  
		  } else 
			  s.setEnabled(true);
			  elencobottone.removeFirst();
	  
		  }
	  } 
  // carica tutti i bottoni in una lista - 	
  // questo metodo serve perchè quando analizziamo i vari bottoni la lista
  //viene anche svuotata
  public void carica() {
	elencobottone.add(btn1);
  	elencobottone.add(btn2);
  	elencobottone.add(btn3);
  	elencobottone.add(btn4);
  	elencobottone.add(btn5);
  	elencobottone.add(btn6);
  	elencobottone.add(btn7);
  	elencobottone.add(btn8);
  	elencobottone.add(btn9);
  	elencobottone.add(btn10);
  	elencobottone.add(btn11);
  	elencobottone.add(btn12);
  	elencobottone.add(btn13);
  	elencobottone.add(btn14);
  	elencobottone.add(btn15);
  	elencobottone.add(btn16);
  	
	  
  }
  
  // Metodo per ripulire la lista da eventuali resisdui di bottoni
  //per evitare che si sommino quando si ricaricano
  public void svuota() {
	  
	  while(!(elencobottone.isEmpty())) {
		  elencobottone.getFirst();
		  elencobottone.removeFirst();
		  
	  }
	  
  }
  
  // creazione di una matrice virtuale
  
  public void matrice(JButton a, JButton b, JButton c, JButton d,
		  JButton e, JButton f, JButton g, JButton h,
		  JButton i, JButton l, JButton m, JButton n,
		  JButton o, JButton p, JButton q, JButton r) 
{

	  JButton  [][] tabella = {{a,b,c,d},
	                {e,f,g,h},
	                {i,l,m,n},
	                {o,p,q,r}};
for(int i1=0;i1 <4;i1++){
for(int j=0;j < 4 ;j++)
	 System.out.print(tabella[i1][j]+" ");
System.out.println();
}


}
  
  // tentativo di creare un metodo che resittuisce il nome di un bottone
  
  public getButton() {
	  
	  
	  
  }

  
	
		
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					finestra frame = new finestra();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


