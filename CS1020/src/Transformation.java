/**
 * This class accepts a matrix and output the final state of the matrix after performing the given operation.
 * @author Yeap Hooi Tong
 * @matric A0111736M
 * @date 23/8/13
 * @version 1.0
 */

import java.util.Scanner;

public class Transformation {
    public static void main(String[] args) {
        // declare and initialise variables
        Scanner sc = new Scanner(System.in);

        // call method to read user's input
        int[][] matrix = readMatrixInput(sc);

        // call method to read and process operation by user
        matrix = readOperation(sc, matrix);

        // print the final matrix state
        printMatrix(matrix);
    }

    /**
     * This method reads the input and creates the 2D array based on user's size N
     * It then populates the array with the given matrix provided by the user.
     *
     * @param sc The scanner object
     * @return int[][] the 2d array that contains the matrix by user
     */
    private static int[][] readMatrixInput(Scanner sc) {
        // get matrix size from user
        int size = sc.nextInt();

        // declare and initialise 2d array of integer type
        int[][] matrix = new int[size][size];

        // read matrix given by user
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = sc.nextInt();
            }
        }

        // return matrix back to parent
        return matrix;
    }

    /**
     * This method reads the number
     *
     * @param sc     The scanner object
     * @param matrix The matrix object
     * @return int[][] the 2d array that contains the matrix after processing
     */
    private static int[][] readOperation(Scanner sc, int[][] matrix) {
        // get the number of iterations that the user request for
        for (int iteration = sc.nextInt(); iteration > 0; iteration--) {
            String operation = sc.next();
            if (operation.equals("Rotate"))
                rotate(sc.nextInt());
            else if (operation.equals("Reflect")) {
                if (sc.next().equals("x")) reflectX();
                else reflectY();
            }
        }

        return matrix;
    }

    /**
     * This method reads the input and creates the 2D array based on user's size N
     * It then populates the array with the given matrix provided by the user.
     *
     * @param matrix The matrix object
     */
    private static void printMatrix(int[][] matrix) {

    }

    private static void rotate(int degree) {

    }

    private static void reflectX() {

    }

    private static void reflectY() {

    }

}
