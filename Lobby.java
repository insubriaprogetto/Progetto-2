package bitti;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Lobby implements Runnable, Serializable{
	
	LocalDateTime date;
	private int port;
	private ArrayList<String> player = new ArrayList<String>();
	private ArrayList<String> osserv;
	
	
	public void run() 
	{}
	
	
	
	public Lobby(int portnumber){
		
		date=LocalDateTime.now();
		player.add(null);
		port=portnumber;
		
	}
	
	
public int getPort() {
		
		return port;
		
	}
	
	
	
	public void Discc(String plaleave){
		
		if(player.contains(plaleave))
		player.remove(plaleave);
		else
			osserv.remove(plaleave);
	}
	
	
	
	public void Obbs(String plajoin){
		
		osserv.add(plajoin);
		
	}
	
	
public void Join(String plajoin){
		
		if(player.size()<=3)
		player.add(plajoin);
		

}}	