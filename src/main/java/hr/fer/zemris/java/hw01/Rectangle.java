package hr.fer.zemris.java.hw01;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Locale.Category;
import java.util.Scanner;

/**
 * Javna klasa koja sluzi kao implementacija racunanja opseg i povrsine iz danih
 * argumenata
 * 
 * @author Mihael
 *
 */
public class Rectangle {

	/**
	 * Glavna metoda iz koje se pokrece program
	 * 
	 * @param args
	 *            argumenti-ako je broj argumenata 0,korisnik upisuje dimenzije,ako
	 *            je 2 ispisuju se podaci pozivanjem metode, inace kraj programa
	 */
	public static void main(String[] args) {
		int length = args.length;

		if (length == 2) {
			print(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
			return;
		} else if (length != 0) {
			System.err.println("Zadan je krivi broj argumenata!");
			return;
		}

		try (Scanner sc = new Scanner(System.in)) {
			double width = 0, height = 0;

			do {
				System.out.println("Unesite sirinu>");
			} while ((width = check(sc.nextLine())) == 0);

			do {
				System.out.println("Unesite visinu>");
			} while ((height = check(sc.nextLine())) == 0);

			print(width, height);
		}
	}

	/**
	 * Javna metoda koja provjerava nalazi li se argument u odredenom okviru(da li
	 * je strogo veci od nule). U kodu je stavljeno da se parsiranje u double izvodi
	 * sukladno trenutnim loklizacijskim postavkama. Lokalizacijske postavke za
	 * Hrvatsku su takve da se za decimnalni znak koristi decimalni zarez,te ce
	 * jedino to biti prihvaceno
	 * 
	 * @param param
	 *            - broj u obliku Stringa ciju validnost zelimo provjeriti
	 * @return 0 ako je strogo manji od jedan,inace duljinu
	 */
	private static double check(String param) {
		try {
			Locale local = Locale.getDefault(Category.FORMAT);
			NumberFormat format = NumberFormat.getInstance(local);
			double number = format.parse(param).doubleValue();

			if (number < 0) {
				System.out.println("Unijeli ste negativnu vrijednost!");
			} else if (number == 0) {
				System.out.println("Unijeli ste nulu!");
			} else {
				return number;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("\'" + param + "\' se ne moze protumaciti kao broj!");
		}

		return 0;
	}

	/**
	 * Javna metoda koja ispisuje rezultat programa,povrsinu i opseg
	 * 
	 * @param width
	 *            sirina
	 * @param height
	 *            visina
	 */
	private static void print(double width, double height) {
		// TODO Auto-generated method stub
		System.out.println("Pravokutnik sirine " + width + " i visine " + height + " ima povrsinu "
				+ surface(width, height) + " i opseg " + perimeter(width, height) + ".");
	}

	/**
	 * Javna metoda koja racuna opseg iz danih argumenata
	 * 
	 * @param width
	 *            sirina
	 * @param height
	 *            visina
	 * @return opseg u obliku Doublea
	 */
	private static Double perimeter(double width, double height) {
		// TODO Auto-generated method stub
		return 2 * (height + width);
	}

	/**
	 * Javna metoda koja racuna povrsinu iz danih argumenata
	 * 
	 * @param width
	 *            sirina
	 * @param height
	 *            visina
	 * @return povrsinu u obliku Doublea
	 */
	private static Double surface(double width, double height) {
		// TODO Auto-generated method stub
		return width * height;
	}

}
