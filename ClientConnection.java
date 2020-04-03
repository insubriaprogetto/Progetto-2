package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientConnection extends Thread {
	Socket s;
	DataInputStream din;
	DataOutputStream dout;
	boolean shouldRun = true;
	
public ClientConnection(Socket socket, Client client){
	 s = socket;	
}

public void sendStringToServer(String text){
	try {
		dout.writeUTF(text);
		dout.flush();
	} catch (IOException e) {
		e.printStackTrace();
		System.out.println("problema attivo close()");
		close();
	}
	
}




public void run(){
 try {
		din = new DataInputStream(s.getInputStream());
		dout = new DataOutputStream(s.getOutputStream());
		while(shouldRun){
				try {
					while(din.available()==0){
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {	
							e.printStackTrace();
						}
					}
					String reply = din.readUTF();
					System.out.println(reply);					
				} catch (IOException e) {				
					e.printStackTrace();
					System.out.println("problema attivo close()");
					close();
				}		
		}
	} catch (IOException e) {
		e.printStackTrace();
	}				
}

public void close(){
	try {
		din.close();
		dout.close();
		s.close();
	} catch (IOException e) {
		e.printStackTrace();
	}		
}


}
