package bitti;


public class Login {
	
	private char[] pass;
	private String Name;
	private String Email;
	
	public void setEmail(String email) {
		
		Email = email;
		
	}
	
	
	public void setPass(char[] pass) {
		
		this.pass = pass;
		
	}
	
	
	public String getName() {
		
		return Name;
		
	}
	
	
	
	public String getEmail() {
		
		return Email;
		
	}
	
	
	
	public char[] getPass() {
		
		return pass;
		
	}
	
	
	public void setName(String name) {
		
		Name = name;
		
	}
	
	
}