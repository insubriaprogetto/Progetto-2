package bitti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;





//import RdF.DatabaseConnector;

public class ServerIP {
	HashMap<String,Socket> LoginStat;
    private DatabaseConnector Gdbconnection;
    

   public static void main (String[] args) throws IOException, NullPointerException {
        Login login = new Login();
        String hostDb;
       java.awt.EventQueue.invokeLater(() -> new InsertDb(new ServerIP()));
    }
   
   public void avvia() {
   	
		ConnectProp games = new ConnectProp(Gdbconnection);
		
		ServerSocket Serverr = null;
		
		LoginStat=new HashMap<String,Socket>();
		
		try {
			Serverr = new ServerSocket(ServerRdFInterface.PORT);
			
			while (true) {
				Socket socket = Serverr.accept();
				new Thread(new SkeletonIP(socket, games,LoginStat)).start();
			}
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
   
   private int Registration(String name, String surn, String email, String psw, String nick, String acti) {
       long data = System.currentTimeMillis();
       int id = Gdbconnection.getMaxIdUser() + 1;//dummy.
       Gdbconnection.registerUser(id, name, surn, email, psw, nick, acti, data);
       return id;
   }
   
   
   
   
   public void Register(String name, String surn, String email, String psw, String nick) {
       String state = Mail_Helper.code();
       int id = Registration(name, surn, email, psw, nick, state);
       Gdbconnection.AdminRegistration(id);
       Gdbconnection.activateAccount(email);
   }
   
   
   

   public DatabaseConnector getDbcon() {
       return Gdbconnection;
   }
   
   public void setDbcon(DatabaseConnector dbcon) {
       Gdbconnection = dbcon;
   }
   
   public int Admincontrol() {
       return Gdbconnection.adminEx();
   }
   
   public int Login(String email, String psw) {
       return Gdbconnection.login(email, psw);
   }
   
   
   
}
