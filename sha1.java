package provecodice;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class sha1 {

	
	
	public static String SHA1(String input ) throws NoSuchAlgorithmException {
		//try {
		MessageDigest mDigest = MessageDigest.getInstance("SHA1");
	    byte[] result = mDigest.digest(input.getBytes());
	    StringBuffer sb = new StringBuffer();
	    for(int i = 0; i < result.length; i++) {
	    	sb.append(Integer.toString((result[i] & 0xff)+ 0x100, 16).substring(1));
	    }
	    return sb.toString();
		//}catch(Exception e) {
			//throw new RunTimeException(e);
		//}
	}
	
	public static void main(String [] args ) throws NoSuchAlgorithmException {
      System.out.println("INSERISCI PASSWORD");
  
      System.err.println("Criptaggio tramite SHA1");
      System.out.println("");
      Scanner sc = new Scanner(System.in);
      String psw = sc.next();
      System.out.println(SHA1(psw));
	//c00d5696513395d25d45a1c8d3ac15935bb1a05c	
}
}