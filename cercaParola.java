package it.uninsubria.dista.dictionary;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class cercaParola  {
	
	 static LinkedList<String> paroletrovate = new LinkedList<>();
	
	
	
	
	public  boolean ControlloFinale( String parola) throws ZipException, IOException {
		System.out.println("--------------");
      
        String file_dizionario= "dict-it.oxt";
		File dizionario=new File(file_dizionario);
		 ZipFile zf = new ZipFile(dizionario);
        Enumeration<? extends ZipEntry> entries = zf.entries();
        
        BufferedReader  in = new BufferedReader(new InputStreamReader(zf.getInputStream(zf.getEntry("dictionaries/th_it_IT_v2.dat")),"ISO8859-15"));
        
         
	
		String termine = parola;
		
	    String giusta = null;
        String temp;
        int cont = 0;
     
        
        while( (temp= in.readLine()) != null) {
                
			    String[] result;
		   		result = temp.split("\\|");
	
			if (termine.equals(result[0])) {
				//System.out.println(termine + " E' stato trovato");
				return true;
				}
			
		
       
       
    } 
       
        zf.close();
		in.close();
		return false;
	}
	

	
	
	
}
