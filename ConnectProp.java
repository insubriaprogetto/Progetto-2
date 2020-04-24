package bitti;

import java.io.*;
import java.math.BigInteger;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

public class ConnectProp implements ServerRdFInterface {
    
	HashMap<String, Lobby> lobbylist;
    HashMap<String, Lobby> Osslist;
    int portcount = 49152;
    int id2 = 0;
    DatabaseConnector dbcon;

    
    
   // @Override
    
    public synchronized int NewGame(String name) {
    	/*
        Lobby tempp = new Lobby(portcount);
        
        if (!lobbylist.containsKey(name) || Osslist.containsKey(name)) {
            try {
                new Thread(new RdFGame(portcount, tempp, this, name)).start();
                lobbylist.putIfAbsent(name, tempp);

            } catch (IOException e) {
                e.printStackTrace();
            }
            
            return portcount;
        } else
        */
            return -1;
        
    }
    

    @Override
    public void EnterGame(String name) {
    	
        lobbylist.get(name);
        
    }

    public String personalAvgMoney(String tempp) {
    	
        int idUser = dbcon.getIdUserByNickname(tempp);
        return String.valueOf(dbcon.personalAvgMoney(idUser));
        
    }

    
    String personallAvgSkipP(int idUser) {
    	
        return String.valueOf(dbcon.personallAvgSkipP(idUser));
        
    }


    public boolean Login(String email, String pass) {
    	
        System.out.println(dbcon.checkPsw(pass, email));
        return dbcon.checkPsw(pass, email);
        
    }

    
    public boolean Ping(ObjectOutputStream ou) {
    	
        boolean tempp=true;
        
        try {
            ou.writeObject(Comands.PING);
            //ou.writeObject(true);
        } catch (IOException e) {
            e.printStackTrace();
            tempp=false;
        }
        return tempp;
        
    }

    
    public int Registration(String name, String surn, String email, String psw, String nick, String acti) {
    	
        long data = System.currentTimeMillis();
        int id = dbcon.getMaxIdUser() + 1;//dummy.
        dbcon.registerUser(id, name, surn, email, psw, nick, acti, data);
        return id;
        
    }
    
    
    public void AdminRegistration(String name, String surn, String email, String psw, String nick, String acti){
    	
        int id = Registration(name, surn, email, psw, nick, acti);
        dbcon.AdminRegistration(id);
        
    }
    
    public String totalMostPoints() {
        
    	ArrayList<Integer> arrl = new ArrayList<Integer>();
        String s;
        arrl = dbcon.totalMostPoints();
        if (arrl.isEmpty()) {
            s = "nessuno";
        } else {
            s = dbcon.getUserNickname(arrl.remove(0));
        }
        return s;
        
    }
    
    public String totalHighAvgManche() {
    	
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        String s;
        arrl = dbcon.totalHighAvgManche();
        if (arrl.isEmpty()) {
            s = "nessuno";
        } else {
            s = dbcon.getUserNickname(arrl.remove(0));
        }
        return s;
        
    }
   
    public String totalHighSkip() {
    	
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        String s;
        arrl = dbcon.totalHighSkip();
        if (arrl.isEmpty()) {
            s = "nessuno";
        } else {
            s = dbcon.getUserNickname(arrl.remove(0));
        }
        return s;
        
    }

    
    public String totalMostManchePlayed() {
    	
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        String s;
        arrl = dbcon.totalMostManchePlayed();
        if (arrl.isEmpty()) {
            s = "nessuno";
        } else {
            s = dbcon.getUserNickname(arrl.remove(0));
        }
        return s;
        
    }
    
    
   
    public int totalAvgGuessSentence() {
    	
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        arrl = dbcon.totalAvgGuessSentence();
        int div = arrl.size();
        int avg = 0;
        while (!arrl.isEmpty()) {
            avg += arrl.remove(0);
        }
        avg = avg / div;
        return avg;
        
    }
    
   
    
    public String personalObservedMatch(String tempp) {
    	
        ArrayList<Integer> manObs = new ArrayList<Integer>();
        int idUser = dbcon.getIdUserByNickname(tempp);
        manObs = dbcon.getObservedManche(idUser);
        ArrayList<Integer> matObs = new ArrayList<Integer>();
        int idm, idp;
        while (!manObs.isEmpty()) {
            idm = manObs.remove(0);
            idp = dbcon.personalObservedMatch(idm);
            if (!matObs.contains(idp)) {
                matObs.add(idp);
            }
        }
        return String.valueOf(matObs.size());
        
    }
    
    
    public String personalPlayedManche(String tempp) {
    	
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        int idUser = dbcon.getIdUserByNickname(tempp);
        arrl = dbcon.personalPlayedManche(idUser);
        return String.valueOf(arrl.size());
        
    }

    
    
    public String personalPlayedMatch(String tempp) {
    	
        int idUser = dbcon.getIdUserByNickname(tempp);
        return String.valueOf(dbcon.personalPlayedMatch(idUser));
        
    }

    public String personalAvgSkip(String tempp) {
    	
        String s = "", m, p;
        int idUser = dbcon.getIdUserByNickname(tempp);
        m = String.valueOf(personalAvgSkipM(idUser)) + "m";
        p = personallAvgSkipP(idUser) + "p";
        s = m + ", " + p;
        return s;
        
    }

    
    String personalAvgSkipM(int idUser) {
    	
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        arrl = dbcon.personalAvgSkipM(idUser);
        int avg = 0;
        int div = arrl.size();
        while (!arrl.isEmpty()) {
            avg += arrl.remove(0);
        }
        if (div != 0) {
            avg /= div;
        }
        return String.valueOf(avg);
        
    }
    
    
    public String personallMancheWon(String tempp) {
    	
        int idUser = dbcon.getIdUserByNickname(tempp);
        return String.valueOf(dbcon.personallMancheWon(idUser));
        
    }

    
    public String personalMatchWon(String tempp) {
    	
        int idUser = dbcon.getIdUserByNickname(tempp);
        return String.valueOf(dbcon.personalMatchWon(idUser));
        
    }

    
    public String personalAvgCrack(String tempp) {
    	
        String s = "", m, p;
        int idUser = dbcon.getIdUserByNickname(tempp);
        m = String.valueOf(personalAvgCrackM(idUser)) + "m";
        p = personalAvgCrackP(idUser) + "p";
        s = m + ", " + p;
        return s;
        
    }

    public ConnectProp(DatabaseConnector data) {
    	
        dbcon = data;
        lobbylist = new HashMap<String, Lobby>();
        Osslist = new HashMap<String, Lobby>();
        id2 = dbcon.getMaxIdUser();
        
    }
    
    String personalAvgCrackM(int idUser) {
    	
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        arrl = dbcon.personalAvgCrackM(idUser);
        int avg = 0;
        int div = arrl.size();
        while (!arrl.isEmpty()) {
            avg += arrl.remove(0);
        }
        if (div != 0) {
            avg /= div;
        }
        return String.valueOf(avg);
        
    }

    public String totalHighCrack() {
    	
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        String s;
        arrl = dbcon.totalHighCrack();
        if (arrl.isEmpty()) {
            s = "nessuno";
        } else {
            s = dbcon.getUserNickname(arrl.remove(0));
        }
        return s;
        
    }


    public String personalObservedManche(String tempp) {
    	
        int idUser = dbcon.getIdUserByNickname(tempp);
        return String.valueOf(dbcon.personalObservedManche(idUser));
        
    }

    
    /*
    public ArrayList<String> totalConsSentUser() {
    	//2 modificare la sez select con quello che mi serve per gamare tuttos
        ArrayList<String> arrl = new ArrayList<String>();
        ArrayList<String> all = new ArrayList<String>();
        arrl = dbcon.totalConsSentUser();
        if (arrl.isEmpty()) {
            all.add("...");//utente
            all.add("...");//phrase
            all.add("...");//consonante
        } else {
            all.add(dbcon.getUserNickname(Integer.parseInt(arrl.remove(0))));//utente
            Sentence s = new Sentence();
            s = dbcon.getPhrase(dbcon.getIdDemandedSentence(Integer.parseInt(arrl.remove(0))));
            all.add(s.getPhrase());//frese
            all.add(arrl.remove(0));//consonante
        }
        return all;
        
    }
*/
    
    String personalAvgCrackP(int idUser) {
    	
        return String.valueOf(dbcon.personalAvgCrackP(idUser));
        
        
    }
    
    
    
}