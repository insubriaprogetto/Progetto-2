package vario;

import java.util.Scanner;
 
/**
 * Semplice classe che implementa una matrice con
 * un solo omino presente su di essa che si muove
 * nelle direzioni
 * nord : tasto 2
 * sud : tasto 3
 * est : tasto 4
 * ovest : tasto 1
 * uscita : tasto 0
 */
 
/**
 * @author Alessandro Musacchio
 *
 */
public class Matrice {
 
	private int[][] matrice;
	private int posX;
	private int posY;
	private int dim;
 
	public Matrice(int dim) {
		this.matrice = new int[dim][dim];
		this.dim = dim;
		this.posX = 0;
		this.posY = 0;
		// Setto la posizione iniziale da cui parte l'omino
		this.matrice[posY][posX] = 1;
	}
 
	public int[][] getMatrice() {
		return matrice;
	}
 
	public boolean muoviDestra() {
		// Controllo se sono al bordo
		if (posX+1 == dim) return false;
		// Mi muovo
		this.matrice[posY][posX] = 0; // Lascio il posto attuale
		this.posX++; // Modifico le coordinate
		this.matrice[posY][posX] = 1; // Occupo il nuovo posto
		return true;
	}
 
	public boolean muoviSinistra() {
		// Controllo se sono al bordo
		if (posX-1 == -1) return false;
		// Mi muovo
		this.matrice[posY][posX] = 0; // Lascio il posto attuale
		this.posX--; // Modifico le coordinate
		this.matrice[posY][posX] = 1; // Occupo il nuovo posto
		return true;
	}
 
	public boolean muoviSu() {
		// Controllo se sono al bordo
		if (posY-1 == -1) return false;
		// Mi muovo
		this.matrice[posY][posX] = 0; // Lascio il posto attuale
		this.posY--; // Modifico le coordinate
		this.matrice[posY][posX] = 1; // Occupo il nuovo posto
		return true;
	}
 
	public boolean muoviGiu() {
		// Controllo se sono al bordo
		if (posY+1 == dim) return false;
		// Mi muovo
		this.matrice[posY][posX] = 0; // Lascio il posto attuale
		this.posY++; // Modifico le coordinate
		this.matrice[posY][posX] = 1; // Occupo il nuovo posto
		return true;
	}
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Matrice mappa = new Matrice(10);
		Scanner sc = new Scanner(System.in);
		int val = 0;
		do {
			val = sc.nextInt();
			if (val == 1) {
				if (mappa.muoviSinistra()) {
					System.out.println("Mosso Sinistra");
				} else {
					System.out.println("Sei al bordo");
				}
			}
			if (val == 2) {
				if (mappa.muoviSu()) {
					System.out.println("Mosso Su");
				} else {
					System.out.println("Sei al bordo");
				}
			}
			if (val == 3) {
				if (mappa.muoviGiu()) {
					System.out.println("Mosso Giù");
				} else {
					System.out.println("Sei al bordo");
				}
			}
			if (val == 4) {
				if (mappa.muoviDestra()) {
					System.out.println("Mosso Destra");
				} else {
					System.out.println("Sei al bordo");
				}
			}
		} while (val != 0);
	}
}