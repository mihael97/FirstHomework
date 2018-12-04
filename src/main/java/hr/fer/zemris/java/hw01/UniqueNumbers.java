package hr.fer.zemris.java.hw01;

import java.util.Scanner;

/**
 * Binary tree
 *
 * @author Mihael
 */
public class UniqueNumbers {

    /**
     * Main method
     *
     * @param args not in use
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner( System.in )) {
            String line;
            TreeNode head = null;
            int value;

            while (true) {
                System.out.println( "Unesite broj>" );
                if ((line = sc.nextLine()).equals( "kraj" )) {
                    break;
                }

                try {
                    value = Integer.parseInt( line );

                    head = addNode( head, value );

                } catch (NumberFormatException e) {
                    System.out.println( "\'" + line + "\' nije cijeli broj!" );
                }
            }

            System.out.println( " Ispis od najmanjeg:" );
            least( head );

            System.out.println( "\n Ispis od najveceg:" );
            largest( head );
        } catch (Exception e) {
            System.err.println( "Problemi sa scannerom!" );
        }
    }

    /**
     * Method adds value inside tree
     *
     * @param head  reference to tree head
     * @param value value for add
     * @return modified tree head
     */
    public static TreeNode addNode(TreeNode head, int value) {
        if (head == null) {
            System.out.println( "Dodan!" );
            return new TreeNode( null, null, value );
        } else if (head.value == value) {
            System.out.println( "Broj " + value + " vec postoji!" );
            return head;
        } else if (head.value > value) {
            head.left = addNode( head.left, value );
        } else {
            head.right = addNode( head.right, value );
        }

        return head;
    }

    /**
     * Prints tree recursively from lowest to largest element
     *
     * @param head head reference
     */
    private static void least(TreeNode head) {
        if (head == null) {
            return;
        }

        least( head.left );
        System.out.printf( " %d ", head.value );
        least( head.right );
    }

    /**
     * Prints tree recursively from largest to lowest element
     *
     * @param head head reference
     */
    private static void largest(TreeNode head) {
        if (head == null) {
            return;
        }

        largest( head.right );
        System.out.printf( " %d ", head.value );
        largest( head.left );
    }

    /**
     * Calculates tree size recursively
     *
     * @param head head reference
     * @return tree size
     */
    public static int treeSize(TreeNode head) {
        if (head == null) {
            return 0;
        } else {
            return treeSize( head.left ) + treeSize( head.right ) + 1;
        }
    }

    /**
     * Tree node
     *
     * @author Mihael
     */
    public static class TreeNode {
        /**
         * Left neighbour
         */
        private TreeNode left;
        /**
         * Right neighbour
         */
        private TreeNode right;
        /**
         * Value
         */
        private int value;

        /**
         * Constructor
         *
         * @param left  left neighbour
         * @param right right neighbour
         * @param value value
         */
        public TreeNode(TreeNode left, TreeNode right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
}
