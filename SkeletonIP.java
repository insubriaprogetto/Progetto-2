package bitti;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;


public class SkeletonIP implements Runnable {
	
	private HashMap<String, Socket> LoginStat;
	private String email;
	private String username;
    private boolean adm = false;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;  
    private int iduser;
    private ConnectProp CP;
    private String unifrase = "15975385624"; 
	private Socket socket;
    
	
	
	
	public static String[] merge(String[] t1, String[] t2){
		
        ArrayList<String> t3=new ArrayList<String>();
        
        for(String s:t1)
            t3.add(s);
        
        for(String s:t2)
            t3.add(s);
            return t3.toArray(new String[t3.size()]);
    }
	
	

    public SkeletonIP(Socket sock, ConnectProp game, HashMap<String, Socket> logins) {
		
		socket = sock;
        CP = game;
        LoginStat = logins;
		
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            oos.writeObject(unifrase);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
	private boolean setLogstat(int z){
		
		
        try {
            oos.writeObject(z);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
	
	


    @Override
    public void run() {
		
        try {
           
            Comands myOperation = null;
			
            while (!socket.isClosed()) {
                try {
                    myOperation = (Comands) ois.readObject();
                } catch (SocketException e) {
                    e.printStackTrace();
                    if (LoginStat.containsKey(email))
                        LoginStat.remove(email);
                }
                System.out.println(myOperation);

                if (myOperation.equals(Comands.LOGIN)) {
					
                    	
               }
                
                
            }  
            }catch (EOFException e) {
                System.out.println("Client scollegato");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

                
                
            
       

        }
    }
