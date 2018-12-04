package hr.fer.zemris.java.hw01;

import java.util.Scanner;

/**
 * Factorial calculator
 *
 * @author Mihael
 */
public class Factorial {

    /**
     * Main method
     *
     * @param args not in use
     */
    public static void main(String[] args) {

        try (Scanner sc = new Scanner( System.in )) {
            String line = new String();

            while (true) {
                System.out.println( "Unesite broj>" );
                if ((line = sc.nextLine()).equals( "kraj" )) {
                    System.out.println( "Dovidenja!" );
                    break;
                } else {
                    try {
                        int number = Integer.parseInt( line );
                        if (number >= 0 && number <= 20) {

                            System.out.println( Integer.parseInt( line ) + "! = " + calculate( number ) );
                        } else {
                            throw new IllegalArgumentException();
                        }

                    } catch (NumberFormatException e) {
                        System.out.println( "\'" + line + "\' nije cijeli broj!" );
                    } catch (IllegalArgumentException e) {
                        System.out.println( "\'" + line + "\' nije u rasponu!" );
                    }
                }
            }
        }

    }

    /**
     * Calculates factorial of given argument
     *
     * @param number number
     * @return 0 is factorial value cannot be calculated, otherwise factorial value
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
