package it.uninsubria.dista.dictionary;

public class Contapunti {

	
	
	public int AssegnaPunti(String s) {
	
		int punti = 0;
		
		int lung = s.length();
		
		if(lung < 3) {
			
			punti = 0;
			//return punti;
	
		} else if(lung == 3 || lung == 4) {
			
			punti = 1;
			//return punti;
			
		}else if (lung == 5) {
			
			punti = 2;
			//return punti;
			
		} else if (lung == 6) {
			
			punti = 3;
			//return punti;
		
		} else if (lung == 7) {
			
			punti = 5;
			//return punti;
		
		} else if (lung >= 8) {
			punti = 11;
			//return punti;
		}
			
			
		return punti;
		
		
	}
	
	
	
	
	
}
