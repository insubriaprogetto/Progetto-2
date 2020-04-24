package bitti;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class IPGSkele implements Runnable{
	
	
	//RdfGamePOC pocrif;
	ServerSocket Serverr;
	

	
	
	
	@Override
	public void run() {
		
		
		Socket socket;
		
		while(true){
			socket=null;
			
			try {
				socket=Serverr.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			//new Thread(new Rdfconnand(socket,pocrif)).start();
			
		}
	}}