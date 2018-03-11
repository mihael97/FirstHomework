package hr.fer.zemris.java.hw01;

import java.util.Scanner;

/**
 * Javna klasa koja implementira računanje faktorijela od brojeva dobivenih
 * preko standardnog ulaza
 * 
 * @author Mihael
 *
 */
public class Factorial {

	/**
	 * Glavna metoda iz koje krece racunanje faktorijela
	 * 
	 * @param args
	 *            - ne koristi se
	 */
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			String line = new String();

			while (true) {
				System.out.println("Unesite broj>");
				if ((line = sc.nextLine()).equals("kraj")) {
					System.out.println("Dovidenja!");
					break;
				} else {
					try {
						int number = Integer.parseInt(line);
						if (number >= 0 && number <= 20) {

							System.out.println(Integer.parseInt(line) + "! = " + calculate(number));
						} else {
							throw new IllegalArgumentException();
						}

					} catch (NumberFormatException e) {
						// TODO: handle exception
						System.out.println("\'" + line + "\' nije cijeli broj!");
					} catch (IllegalArgumentException e) {
						// TODO: handle exception
						System.out.println("\'" + line + "\' nije u rasponu!");
					}
				}
			}
		}

	}

	/**
	 * Javna metoda koja racuna iznos faktorijela danog argumenta
	 * 
	 * @param number
	 *            - broj od kojeg se racuna fakorijel
	 * 
	 * @return 0 ako se vrijednost ne moze izracunati,inace iznos faktorijela
	 */
	public static long calculate(int number) {
		if (number < 0) {
			return 0;
		}

		long sum = 1; // 0!=1

		for (int i = 1; i <= number; i++) {
			sum *= i;
		}

		return sum;

	}
}
