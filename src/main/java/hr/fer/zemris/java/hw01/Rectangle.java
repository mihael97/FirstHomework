package hr.fer.zemris.java.hw01;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Locale.Category;
import java.util.Scanner;

/**
 * Calculator perimeter and surface of rectangle
 *
 * @author Mihael
 */
public class Rectangle {

    /**
     * Main method
     *
     * @param args if number of arguments is 0, user needs to input dimensions, if size of arguments is 2 perimeter and surface will be calculated, otherwise program finishes
     */
    public static void main(String[] args) {
        int length = args.length;

        if (length == 2) {
            print( Double.parseDouble( args[0] ), Double.parseDouble( args[1] ) );
            return;
        } else if (length != 0) {
            System.err.println( "Zadan je krivi broj argumenata!" );
            return;
        }

        try (Scanner sc = new Scanner( System.in )) {
            double width = 0, height = 0;

            do {
                System.out.println( "Unesite sirinu>" );
            } while ((width = check( sc.nextLine() )) == 0);

            do {
                System.out.println( "Unesite visinu>" );
            } while ((height = check( sc.nextLine() )) == 0);

            print( width, height );
        }
    }

    /**
     * Checks if arguments is greater that zero<br>
     * Method converts number from input depending on current localization settings. For Croatia, <code>decimal comma</code> is in use
     *
     * @param param number in String representation
     * @return 0 if input number is lower or equal to zero or input String cannot be converted to number,otherwise  duljinu
     */
    private static double check(String param) {
        try {
            Locale local = Locale.getDefault( Category.FORMAT );
            NumberFormat format = NumberFormat.getInstance( local );
            double number = format.parse( param ).doubleValue();

            if (number < 0) {
                System.out.println( "Unijeli ste negativnu vrijednost!" );
            } else if (number == 0) {
                System.out.println( "Unijeli ste nulu!" );
            } else {
                return number;
            }
        } catch (Exception e) {
            System.out.println( "'" + param + "' se ne moze protumaciti kao broj!" );
        }

        return 0;
    }

    /**
     * Prints rectangles's perimeter and surface
     *
     * @param width  width
     * @param height height
     */
    private static void print(double width, double height) {
        System.out.println( "Pravokutnik sirine " + width + " i visine " + height + " ima povrsinu "
                + surface( width, height ) + " i opseg " + perimeter( width, height ) + "." );
    }

    /**
     * Calculates perimeter from given arguments
     *
     * @param width  width
     * @param height height
     * @return perimeter in Double format
     */
    private static Double perimeter(double width, double height) {
        return 2 * (height + width);
    }

    /**
     * Calculates surface from given arguments
     *
     * @param width  width
     * @param height height
     * @return surface in Double format
     */
    private static Double surface(double width, double height) {
        return width * height;
    }

}
