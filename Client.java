package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import bitti.TabellaGioco;

public class Client extends TabellaGioco {
	
	//String c = new String("prova");
	String c;
	
	ClientConnection cc;
	
	public static void main(String[] args) {
		new Client();
		
	}
	
public Client(){

//al posto di questo ci saraà la registrazione/login clinet	
	Scanner nome = new Scanner(System.in);
	System.out.println("inserisci il tuo nome:");
	c = nome.nextLine();
	System.out.println("il nome "+c+" è stato inserito" );
//---------------------------------------------------------
	
	
	
	
	
	try {
		Socket s = new Socket("localhost", 3333);
		 cc = new ClientConnection(s,this);
		 cc.start();
		 
		 
		 TabellaGioco p = new TabellaGioco();
		 p.setVisible(true);
			
		 
		 
		 
		 
		 
		listenForInput();	
	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}


 public void listenForInput(){
	 Scanner console = new Scanner(System.in);
	while(true) { 
		 while(!console.hasNextLine()) {	
			 try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
		 }
		 String f = new String(": ");
		 
		 String input = console.nextLine();
		 String conc1 = c.concat(f);
		 String conc = conc1.concat(input);
		 
		 if(input.toLowerCase().equals("quit")) {
			 break;
			 
		 }
		//cc.sendStringToServer(input);
		cc.sendStringToServer(conc);
		}
	 cc.close();
	}
 
}
