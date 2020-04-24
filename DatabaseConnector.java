package bitti;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class DatabaseConnector {
	
	 static String password = "123";
	 static String user = "postgres";
	 static String url = "jdbc:postgresql://";
    Connection connec;
    

    public static void main(String[] args) {
    	
      connect();
    }

     String getPswd() {
    	
        return password;
    }
    
    public String getUser() {
    	
        return user;
    }
 
    public String getUrl() {
    	
        return url;
    }

   
    
    boolean checkEmail(String s) {
    	
    	
    	 boolean inuse = false;
        String SQL="SELECT COUNT(*) FROM \"USER\" WHERE \"email\"='"+s+"'";
       
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            
            if (rset.getInt("COUNT") == 0) {
                inuse = false;
                
            } else {
                inuse = true;
            }
            return inuse;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
            inuse = true;
            return inuse;
        }
    }
    
    
    
    

   
    boolean checkNickname(String s) {
    	
    	 boolean inuse = false;
        String SQL="SELECT COUNT(*) FROM \"USER\" WHERE \"nickname\"='"+s+"'";
       
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            
            if (rset.getInt("COUNT") == 0) {
                inuse = false;
            } else {
                inuse = true;
            }
            return inuse;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
            inuse = true;
            return inuse;
        }
    }

   
    synchronized void registerUser(int id, String name, String surn, String email, String psw, String nick, String acti, long hour) {
    	
    	String SQL="INSERT INTO \"USER\" (\"idUser\", name, surname, email, password, nickname, activationcode, \"hourRegistration\") VALUES ("+id+", '"+name+"','"+surn+"','"+email+"','"+psw+"','"+nick+"','"+acti+"','"+hour+"')";
    	
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    synchronized void AdminRegistration(int id) {
    	
        String SQL="INSERT INTO \"MANAGE\" (\"idUser\") VALUES ("+id+")";
        
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  
    synchronized void PlayerRegistration(int id) {
    	
        String SQL = "INSERT INTO \"PLAY\" (\"idUser\") VALUES (" + id + ")";
        
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    boolean checkPsw(String p, String e) {
    	
    	boolean inuse = false;
        String SQL="SELECT COUNT(*) FROM \"USER\" WHERE \"email\"='"+e+"' AND \"password\"='"+p+"'";
       
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            if (rset.getInt("COUNT") == 1) {
                inuse = true;
            }
            return inuse;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            inuse = true;
            return inuse;
        }
    }

    
    
    
    
    
    
 public DatabaseConnector(String ur, String us, String ps) {
        
        url = url + ur + "/" + "Dbprogetto2";
        
        user = us;
        password = ps;
        
        
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connec = connect();
        System.out.println("connessione" );
    }

 
 
    
    static Connection connect() {
    	
        Connection connec = null;
        try {
            connec = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connec;
    }

    
    
    
    int adminEx() {
    	
    	int b = 0;
        String SQL = "SELECT COUNT(*) FROM \"MANAGE\"";
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            if (rset.getInt("COUNT") > 0) {
                b = 1;
            }
            return b;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
            b = -1;
            return b;
        }
        
        catch (NullPointerException e){
        	
            b=-1;
            return b;
        }
    }

    
    
    
    int getMaxIdUser() {
    	
        String SQL="SELECT MAX(\"idUser\") FROM \"USER\"";
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            return rset.getInt("MAX");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
            return -1;
        }
    }
    
    
    
    
    
    boolean checkAccountState(String email) {
    	
    	boolean active = false;
        String SQL="SELECT * FROM \"USER\" WHERE \"email\"='"+email+"'";
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            
            if (rset.getBoolean("accountstate")) {
                active = true;
            }
            return active;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
            return active;
        }
    }

    
    void deleteUserAccount(String email) {
    	
        String SQL = "DELETE FROM \"USER\" WHERE \"email\"='" + email + "'";
        
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
 boolean isPlayerByNick(String n) {
    	
    	boolean b = false;
        String SQL = "SELECT COUNT(*) FROM \"PLAY\" WHERE \"idUser\"=" + getIdUserByNickname(n);
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            
            if (rset.getInt("COUNT") == 1) {
                b = true;
            }
            return b;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            b = false;
            return b;
        }
    }

    boolean isAdmin(int aid){
    	
    	boolean b = false;
        String SQL = "SELECT COUNT(*) FROM \"MANAGE\"  WHERE \"idUser\"="+ aid;
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            
            if (rset.getInt("COUNT") == 1) {
                b = true;
            }
            return b;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            b = false;
            return b;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    boolean controlActivationCode(String e, String a) {
    	
    	boolean inuse = false;
        String SQL = "SELECT COUNT(*) FROM \"USER\" WHERE \"email\"='" + e + "' AND \"activationcode\"='" + a + "'";
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            
            if (rset.getInt("COUNT") == 1) {
                inuse = true;
            }
            return inuse;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            inuse = true;
            return inuse;
        }
    }

   
    long getHourRegistration(String email) {
    	
        String SQL = "SELECT * FROM \"USER\" WHERE \"email\"='" + email + "'";
        long active = 0;
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            active = Long.parseLong(rset.getString("hourRegistration"));
            return active;
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
            return active;
        }
    }

   
    ArrayList<Integer> getUsedSentence(int idMatch) {
    	
        String SQL = "SELECT * FROM \"DEMAND\" WHERE \"idMatch\"=" + idMatch;
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                arrl.add(rset.getInt("idSentence"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }

   
    
    
    
    ArrayList<Integer> getAllLiveMatch() {
    	
        String SQL = "SELECT * FROM \"MATCH\" WHERE \"winner\" is null order by \"idMatch\" asc";
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                arrl.add(rset.getInt("idMatch"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }

    
    
    
    
    synchronized void demandedSentence(int idSentence, int nManche, int idMatch) {//registra la sentenza come richiesta nella manche tot
        String SQL = "insert into \"DEMAND\" (\"idManche\", \"idMatch\", \"idSentence\") values(" + getManche(idMatch, nManche) + "," + idMatch + "," + idSentence + ")";
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    String getMailUser(int id) {
        String SQL = "SELECT * FROM \"USER\" WHERE \"idUser\"=" + id;
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            return rset.getString("email");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
            return "";
        }
    }

    
    int getIdUser(String email) {
        String SQL = "SELECT \"idUser\" FROM \"USER\" WHERE \"email\"=\'" + email + "\'";
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            return rset.getInt("idUser");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
            return -1;
        }
    }

    
    
    
    
    ArrayList<Integer> getNotFullMatch() {
    	
        String SQL = "select * from \"MATCH\" where \"preparation\"=true and (\"idP1\" is null or \"idP2\" is null or \"idP3\" is null)";
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            while (rset.next()) {
                arrl.add(rset.getInt("idMatch"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }

    
    
    
    
    int getManche(int idMatch, int nManche) {
    	
        String SQL = "SELECT * FROM \"MANCHE\" WHERE \"idMatch\"=" + idMatch + " AND \"nManche\"=" + nManche;
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            return rset.getInt("idManche");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
            return -1;
        }
    }

int getIdUserByNickname(String n) {
    	
        String SQL = "SELECT \"idUser\" FROM \"USER\" WHERE \"nickname\"=\'" + n + "\'";
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            return rset.getInt("idUser");
            
        } catch (SQLException e) {
            System.out.println("*************************19");
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + SQL);
            return -1;
        }
    }




    
    synchronized void executeMove(int idUser, int idManche, int idMatch, String move, int score) {
        int id = getMaxIdExecution() + 1;
        
        String SQL = "insert into \"EXECUTE\" (\"idExecution\", \"idUser\", \"idManche\", \"idMatch\", \"move\", \"score\") values (" + id + ", " + idUser + ", " + idManche + ", " + idMatch + ", '" + move + "', " + score + ")";
        
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
        } catch (SQLException e) {
            
        	
            e.printStackTrace();
        }
    }

   
    int getMaxIdExecution() {
    	
        String SQL = "SELECT MAX(\"idExecution\") FROM \"EXECUTE\"";
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            return rset.getInt("MAX");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
            return -1;
        }
    }

    
    synchronized void insertManche(int idMatch, int nManche) {
        
    	int id = getMaxIdManche() + 1;
        String SQL = "insert into \"MANCHE\" (\"idManche\", \"idMatch\", \"nManche\") values(" + id + "," + idMatch + ", " + nManche + ")";
        
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    int getMaxIdManche() {
    	
        String SQL = "SELECT MAX(\"idManche\") FROM \"MANCHE\"";
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            return rset.getInt("MAX");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
            return -1;
        }
    }
 
    
    
    
    
   
   
    synchronized void endPreparation(int idMatch) {//mette preparation a false aka il match � iniziato
        String SQL = "UPDATE \"MATCH\" SET \"preparation\"=false WHERE \"idMatch\"=" + idMatch;
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    int getIdSentence(String sent) {
    	
        String SQL = "SELECT * FROM \"SENTENCE\" WHERE \"sentence\"= '" + sent + "'";
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            int id = -1;
            
            while (rset.next()) {
                id = rset.getInt("idSentence");
            }
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
            
        }
    }

    
    
    /*
    synchronized void modifySentence(Sentence n, Sentence o) {
    	
        deletePhrase(getIdSentence(o.getPhrase()));
        insertPhrase(n);
    }
*/
    
    ArrayList<String> getMatchHistory(int idMatch) {
    	
        String SQL="SELECT \"idUser\", \"move\", \"score\" FROM \"EXECUTE\" WHERE \"idMatch\"="+idMatch+" ORDER BY   \"idExecution\"";
        ArrayList<String> arrl = new ArrayList<String>();
        String s;
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            while (rset.next()) {
                s = "";
                s = getUserNickname(rset.getInt("idUser")) + " ha eseguito " + rset.getString("move") + " e ha ottenuto un punteggio di: " + rset.getInt("score");
                arrl.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }

    
  
    
    String getUserNickname(int idUser) {
    	
        String SQL="SELECT * FROM \"USER\" WHERE \"idUser\"= "+idUser;
        String nick="";
        
        try (   Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            if(rset.next()) {
                nick=rset.getString("nickname");
            }
            return nick;
        } catch (SQLException e) {
            e.printStackTrace();
            return "ERRORE OTTENIMENTO NICKNAME";
        }
    }

    
    
    
    
    int login(String email, String password) {
    	
        String SQL="SELECT \"idUser\" FROM \"USER\" WHERE \"email\"= '"+email+"' AND \"password\"='"+password+"'";
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            return rset.getInt("idUser");

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    
    
    
    
    boolean isPlayer(String email) {
    	
    	boolean b = false;
        String SQL="SELECT COUNT(*) FROM \"PLAY\" WHERE \"idUser\"="+getIdUser(email);
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            
            if (rset.getInt("COUNT") == 1) {
                b = true;
            }
            return b;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            b = false;
            return b;
        }
    }
    
    
    

  
    String getUserName(int id) {
    	
        String SQL="SELECT \"name\" FROM \"USER\" WHERE \"idUser\"="+id;
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            return rset.getString("name");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
            return "";
        }
    }
    
    
    

    
    String getUserSurname(int id) {
    	
        String SQL = "SELECT * FROM \"USER\" WHERE \"idUser\"=" + id;
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            return rset.getString("surname");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
            return "";
        }
    }

   
    String getUserPassword(int id) {
    	
        String SQL = "SELECT * FROM \"USER\" WHERE \"idUser\"=" + id;
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            return rset.getString("password");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
            return "";
        }
    }

    
    synchronized void updateUser(int id, String n, String s, String e,String ni) {
        
    	String SQL = "update \"USER\" set \"name\"='" + n + "',\"surname\"='" + s + "', \"email\"='" + e +"',\"nickname\"='" + ni + "' where \"idUser\"=" + id;
    	
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }

    
    synchronized void updatePassword(String p, String e) {
    	
        String SQL = "update \"USER\" set \"password\"='" + p + "' where \"email\"='" + e + "'";
        
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }

    
synchronized void updateEnrolMoney(int idUser, int money) {
    	
        int current = getEnrolData(idUser, "moneywon");
        int moneyTot = current + money;
        
        String SQL = "UPDATE \"ENROL\" SET \"moneywon\"=" + moneyTot + " WHERE \"idUser\"=" + idUser;
        
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    synchronized void updateEnrolSkip(int idUser) {
    	
        int current = getEnrolData(idUser, "nskip");
        int tot = current++;
        
        String SQL = "UPDATE \"ENROL\" SET \"nskip\"=" + tot + " WHERE \"idUser\"=" + idUser;
        
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    synchronized void updateEnrolCrack(int idUser) {
    	
        int current = getEnrolData(idUser, "ncrack");
        int tot = current++;
        String SQL = "UPDATE \"ENROL\" SET \"ncrack\"=" + tot + " WHERE \"idUser\"=" + idUser;
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    synchronized void updateEnrolMancheWon(int idUser) {
    	
        int current = getEnrolData(idUser, "nmanchewon");
        int tot = current++;
        String SQL = "UPDATE \"ENROL\" SET \"nmanchewon\"=" + tot + " WHERE \"idUser\"=" + idUser;
        
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  
  
   
    ArrayList<Integer> totalMostPoints() {
    	
    	int i;
    	ArrayList<Integer> arrl = new ArrayList<Integer>();
        String SQL = "select \"idUser\", max(\"moneywon\") from \"ENROL\" group by \"idUser\" order by max desc limit 1";
       
        
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            while (rset.next()) {
                i = rset.getInt("idUser");
                arrl.add(i);
            }
            
            if(arrl.isEmpty()) {
                arrl.add(-1);
            }
            
        } catch (SQLException e) {
            System.out.println("*************************1");
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }

    
    ArrayList<Integer> totalMostManchePlayed() {
    	
    	int i;
    	ArrayList<Integer> arrl = new ArrayList<Integer>();
        String SQL = "select \"idUser\", count(distinct(\"idManche\")) from \"EXECUTE\" group by \"idUser\" order by count desc";
        
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            
        	while (rset.next()) {
                i = rset.getInt("idUser");
                arrl.add(i);
            }
        	
            if(arrl.isEmpty()) {
                arrl.add(-1);
            }
            
        } catch (SQLException e) {
            System.out.println("*************************2");
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }

    
    ArrayList<Integer> totalHighAvgManche() {
    	
    	int i;
    	ArrayList<Integer> arrl = new ArrayList<Integer>();
        String SQL = "select \"idUser\", \"idManche\", avg(\"score\") from \"EXECUTE\" group by \"idManche\", \"idUser\" order by avg desc limit 1";
        
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            
        	while (rset.next()) {
                i = rset.getInt("idUser");
                arrl.add(i);
            }
            
        	if(arrl.isEmpty()) {
                arrl.add(-1);
            }
        	
        } catch (SQLException e) {
            System.out.println("*************************3");
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }

    
    
    
    ArrayList<Integer> totalHighSkip() {
    	
    	int i;
    	ArrayList<Integer> arrl = new ArrayList<Integer>();
        String SQL = "select \"idUser\", count(*) from \"EXECUTE\" where \"move\"='skip' group by \"idUser\" order by count desc limit 1";
       
       
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                i = rset.getInt("idUser");
                arrl.add(i);
            }
            
            if(arrl.isEmpty()) {
                arrl.add(-1);
            }
            
        } catch (SQLException e) {
            System.out.println("*************************4");
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }

   
    ArrayList<Integer> totalHighCrack() {
    	
    	int i;
    	ArrayList<Integer> arrl = new ArrayList<Integer>();
        String SQL = "select \"idUser\", count(*) from \"EXECUTE\" where \"move\"='crack' group by \"idUser\" order by count desc limit 1";
        
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                i = rset.getInt("idUser");
                arrl.add(i);
            }
            
            if(arrl.isEmpty()) {
                arrl.add(-1);
            }
            
        } catch (SQLException e) {
            System.out.println("*************************5");
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }

    
    ArrayList<String> totalConsSentUser() {
    	
    	String s;
    	ArrayList<String> arrl = new ArrayList<String>();
        String SQL = "select * from \"EXECUTE\" where \"move\" like 'consonante%' order by \"score\" desc limit 1";
        
        
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                s = String.valueOf(rset.getInt("idU"));
                arrl.add(s);
                s = String.valueOf(rset.getInt("idManche"));
                arrl.add(s);
                s = rset.getString("move");
                arrl.add(s);
            }
            
            if(arrl.isEmpty()) {
                arrl.add("-1");
                arrl.add("-1");
                arrl.add("---");
            }
            
        } catch (SQLException e) {
            System.out.println("*************************6");
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }


    synchronized void activateAccount(String email) {
    	
        String SQL = "UPDATE \"USER\" SET \"accountstate\"=true WHERE \"email\"='" + email + "'";
        
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
   
    
    
    
    ArrayList<Integer> getPlayers(int idMatch) {
    	
        String SQL = "SELECT * FROM \"MATCH\" WHERE \"idMatch\"=" + idMatch;
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            arrl.add(rset.getInt("idP1"));
            arrl.add(rset.getInt("idP2"));
            arrl.add(rset.getInt("idP3"));
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }

    
    ArrayList<Integer> getPlayedMatchId(int idPlayer) {
    	
        String SQL = "SELECT * FROM \"MATCH\" WHERE \"idP1\"=" + idPlayer + " OR \"idP2\"=" + idPlayer + " OR \"idP3\"=" + idPlayer;
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                arrl.add(rset.getInt("idMatch"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }

    
    
    
    
    
    
    
    int getIdDemandedSentence(int idManche) {
    	
        String SQL = "SELECT * FROM \"DEMAND\" WHERE \"idManche\"=" + idManche;
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            return rset.getInt("idSentence");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
            return -1;
        }
    }

    
    
    
    ArrayList<Integer> totalAvgGuessSentence() {
    	
        String SQL = "select count(\"idManche\") from \"EXECUTE\" group by \"idManche\" order by count desc";
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        
        int i;
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                i = rset.getInt("count");
                arrl.add(i);
            }
            
            if(arrl.isEmpty()) {
                arrl.add(-1);
            }
            
        } catch (SQLException e) {
            System.out.println("*************************7");
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }
    
    
    

    
    ArrayList<Integer> personalPlayedManche(int idUser) {
    	
        String SQL = "select distinct \"idManche\" from \"EXECUTE\" where \"idUser\"=" + idUser;
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                arrl.add(rset.getInt("idManche"));

            }
            
            if(arrl.isEmpty()) {
                arrl.add(-1);
            }
        } catch (SQLException e) {
            System.out.println("*************************8");
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }
    
    
    

   
    int personalPlayedMatch(int idUser) {
    	
        String SQL = "select count (*) from \"ENROL\" where \"idUser\"=" + idUser;
        int i = 0;
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                i = rset.getInt("count");

            }
            
        } catch (SQLException e) {
            System.out.println("*************************9");
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + SQL);
        }
        return i;
    }
    
    
    

    
    int personalObservedManche(int idUser) {
    	
        String SQL = "select count(\"idMatch\") from \"OBSERVE\" where \"idUser\"=" + idUser;
        int i = 0;
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                i = rset.getInt("count");

            }
            
        } catch (SQLException e) {
            System.out.println("*************************10");
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + SQL);
        }
        return i;
    }

    
    
    
   
    ArrayList<Integer> getObservedManche(int idUser) {
    	
        String SQL = "select \"idMatch\" from \"OBSERVE\" where \"idUser\"=" + idUser;
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                arrl.add(rset.getInt("idManche"));

            }
            
        } catch (SQLException e) {

            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }

    
    
    
    
    ArrayList<Integer> getObservedMatchId(int idUser) {
    	
        String SQL = "select distinct \"idMatch\" from \"OBSERVE\" where \"idUser\"=" + idUser;
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                arrl.add(rset.getInt("idMatch"));

            }
            
        } catch (SQLException e) {

            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }

    
    
    
    
    int personalObservedMatch(int idManche) {
    	
        String SQL = "select \"idMatch\" from \"MANCHE\" where \"idManche\"=" + idManche;
        int i = 0;
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                i = rset.getInt("idMatch");
            }
            
        } catch (SQLException e) {
            System.out.println("*************************11");
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + SQL);
        }
        return i;
    }

    
    
    
    
    int personallMancheWon(int idUser) {
        String SQL = "select sum(\"nmanchewon\") from \"ENROL\" where \"idUser\"=" + idUser;
        int i = 0;
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                i = rset.getInt("sum");
            }
            
        } catch (SQLException e) {
            System.out.println("*************************12");
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + SQL);
        }
        return i;
    }

    
    
    
    
    
    int personalMatchWon(int idUser) {
    	
    	int i = 0;
        String SQL = "select count(\"winner\") from \"MATCH\" where \"winner\"=" + idUser;
        
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                i = rset.getInt("count");
            }
            
        } catch (SQLException e) {
            System.out.println("*************************13");
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + SQL);
        }
        
        return i;
    }

    
    int personalAvgMoney(int idUser) {
    	
    	int i = 0;
        String SQL = "select avg(\"moneywon\") from \"ENROL\" where \"idUser\"=" + idUser;
        
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                i = rset.getInt("avg");
            }
            
        } catch (SQLException e) {
            System.out.println("*************************14");
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + SQL);
        }
        
        return i;
    }
/*
 synchronized void insertPhrase(Sentence s) {
    	
        int id = getMaxIdSentence() + 1;
        String SQL = "INSERT INTO \"SENTENCE\" (\"idSentence\", \"sentence\", \"theme\") VALUES (" + id + ", '" + s.getPhrase() + "', '" + s.getTheme() + "')";
        
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/
    
    int getMaxIdSentence() {
    	
        String SQL = "SELECT MAX(\"idSentence\") FROM \"SENTENCE\"";
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            return rset.getInt("MAX");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
            return -1;
        }
    }

   
    void deletePhrase(int idSentence) {
    	
        String SQL = "DELETE FROM \"SENTENCE\" WHERE \"idSentence\"=" + idSentence;
        
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    void deleteAllPhrase() {
    	
        String SQL = "DELETE FROM \"SENTENCE\"";
        
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   /*
    ArrayList<Sentence> getAllPhrase() {
    	
        String SQL = "SELECT * FROM \"SENTENCE\" order by theme asc";
        ArrayList<Sentence> arrl = new ArrayList<Sentence>();
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                Sentence s = new Sentence(rset.getString("sentence"), rset.getString("theme"));
                arrl.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }
    */

  /*  
    Sentence getPhrase(int id) {
    	
        Sentence s = null;
        String SQL = "SELECT * FROM \"SENTENCE\" WHERE \"idSentence\"=" + id;
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            s = new Sentence(rset.getString("sentence"), rset.getString("theme"));
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
        }
        return s;

    }
*/
    
    ArrayList<Integer> getAllPhraseId() {
    	
        String SQL = "SELECT * FROM \"SENTENCE\" order by \"idSentence\" asc";
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                arrl.add(rset.getInt("idSentence"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }

    
    
    
    
    
    ArrayList<Integer> personalAvgSkipM(int idUser) {
    	
        String SQL = "select count(\"idManche\") from \"EXECUTE\" where \"idUser\"=" + idUser + " and \"move\"='skip' group by \"idManche\"";
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                arrl.add(rset.getInt("count"));
            }
            
            if(arrl.isEmpty()) {
                arrl.add(0);
            }
            
        } catch (SQLException e) {
            System.out.println("*************************15");
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }

    
    
    
    
    int personallAvgSkipP(int idUser) {
    	
    	int i = 0;
        String SQL = "select avg(\"nskip\") from \"ENROL\" where \"idUser\"=" + idUser;
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                i = rset.getInt("avg");
            }
            
        } catch (SQLException e) {
            System.out.println("*************************16");
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + SQL);
        }
        return i;
    }

    
    
    
    
    ArrayList<Integer> personalAvgCrackM(int idUser) {
    	
        String SQL = "select count(\"idManche\") from \"EXECUTE\" where \"idUser\"=" + idUser + " and \"move\"='crack' group by \"idManche\"";
        ArrayList<Integer> arrl = new ArrayList<Integer>();
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                arrl.add(rset.getInt("count"));
            }
            
            if(arrl.isEmpty()) {
                arrl.add(0);
            }
            
        } catch (SQLException e) {
            System.out.println("*************************17");
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + SQL);
        }
        return arrl;
    }

    
    
    
    
    int personalAvgCrackP(int idUser) {
    	
    	int i = 0;
        String SQL = "select avg(\"ncrack\") from \"ENROL\" where \"idUser\"=" + idUser;
        
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
        	
            while (rset.next()) {
                i = rset.getInt("avg");
            }
            
        } catch (SQLException e) {
            System.out.println("*************************18");
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + SQL);
        }
        return i;
    }

    
    
    
    synchronized void userObserve(int idUser, int idMatch) {
        
    	String SQL = "insert into \"OBSERVE\" (\"idUser\", \"idMatch\") values(" + idUser + "," + idMatch + ")";
    	
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    synchronized void enrolPlayer(int idUser, int idMatch) {
       
    	String SQL = "insert into \"ENROL\" (\"idUser\", \"idMatch\") values (" + idUser + ", " + idMatch + ")";
    	
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

   
    
    
    int getEnrolData(int idUser, String data) {
    	
        String SQL = "SELECT " + data + " FROM \"ENROL\" WHERE \"idUser\"=" + idUser;
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            return rset.getInt(data);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
            return -1;
        }
    }

    
    synchronized int createMatch(int idP1, int idP2, int idP3, String name) {
    	
        int id = getMaxIdMatch() + 1;
        String SQL = "insert into \"MATCH\" (\"idMatch\", \"idP1\", \"idP2\", \"idP3\", \"preparation\", \"time\", \"name\") values(" + id + ", " + idP1 + "," + idP2 + "," + idP3 + ", false, '" + System.currentTimeMillis() + "', '" + name + "' )";
        
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return id;
    }

    
    int getMaxIdMatch() {
    	
        String SQL = "SELECT MAX(\"idMatch\") FROM \"MATCH\"";
        
        try (
                Statement stmnt = connec.createStatement();
                ResultSet rset = stmnt.executeQuery(SQL);) {
            rset.next();
            return rset.getInt("MAX");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + SQL);
            return -1;
        }
    }

    
    synchronized void updateMatchWinner(int idMatch, int idWinner) {
    	
        String SQL = "UPDATE \"MATCH\" SET \"winner\"=" + idWinner + " WHERE \"idMatch\"=" + idMatch;
        
        try (
                PreparedStatement stmnt = connec.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            stmnt.executeUpdate();
            stmnt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}