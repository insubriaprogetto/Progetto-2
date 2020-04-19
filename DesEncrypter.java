package it.uninsubria.dista.dictionary;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.util.Scanner;

public class DesEncrypter {
Cipher ecipher;
Cipher dcipher;

// 8-byte Salt
byte[] salt = {(byte)0xA9, (byte)0x9B, (byte)0xC8, (byte)0x32,
(byte)0x56, (byte)0x35, (byte)0xE3, (byte)0x03
};

// Iteration count
int iterationCount = 19;

public DesEncrypter(String passPhrase) {
try {
// Create the key
PBEKeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
ecipher = Cipher.getInstance(key.getAlgorithm());
dcipher = Cipher.getInstance(key.getAlgorithm());

// Prepare the parameter to the ciphers
PBEParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

// Create the ciphers
ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
} catch (Exception e) { e.printStackTrace(); }
}

public String encrypt(String str) {
String ret = null;
try {
// Encode the string into bytes using utf-8
byte[] utf8 = str.getBytes("UTF8");

// Encrypt
byte[] enc = ecipher.doFinal(utf8);

// Encode bytes to base64 to get a string
ret = new sun.misc.BASE64Encoder().encode(enc);
} catch (Exception e) { e.printStackTrace(); }
return ret;
}

public String decrypt(String str) {
String ret = null;
try {
// Decode base64 to get bytes
byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);

// Decrypt
byte[] utf8 = dcipher.doFinal(dec);

// Decode using utf-8
ret = new String(utf8, "UTF8");
} catch (Exception e) { e.printStackTrace(); }
return ret;
}

public static void main(String[] args) throws Exception {
Scanner sc = new Scanner(System.in);
System.out.println("INSERISCI UNA PASSWORD");
String psw = sc.next();
System.out.println("");
System.out.println("-----------------------------------------------");
System.out.println("");
DesEncrypter enc = new DesEncrypter("tua chiave");
String criptata = enc.encrypt(psw);
System.out.println("Password criptata: " + criptata);
//System.out.println("Password decriptata: " + enc.decrypt(criptata));
System.out.println("");

System.out.println("************************************");
System.out.println("********* BITTI HACKERMAN **********");
System.out.println("************************************");

}

}