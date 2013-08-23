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
     * This method reads the number of iterations that the user wants and accepts
     * user's operation and appropriate sub-digit and process it and return to parent
     *
     * @param sc     The scanner object
     * @param matrix The matrix object
     * @return int[][] the 2d array that contains the matrix after processing
     */
    private static int[][] readOperation(Scanner sc, int[][] matrix) {
        // get the number of iterations that the user request for
        for (int iteration = sc.nextInt(); iteration > 0; iteration--) {
            String operation = sc.next();

            if (operation.equals("Rotate")) // if user decide to rotate
                matrix = rotate(sc.nextInt(), matrix); // specify angle by user
            else if (operation.equals("Reflect")) { // if user decides to reflect
                if (sc.next().equals("x")) matrix = reflectX(matrix); // on x axis
                else matrix = reflectY(matrix); // on y axis
            }
        }

        // return the matrix back to parent
        return matrix;
    }

    /**
     * This method prints out the matrix object into table form
     *
     * @param matrix The matrix object
     */
    private static void printMatrix(int[][] matrix) {
        // read matrix given by user and print it out in table form
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.print("\n");
        }
    }

    /**
     * This method is used to rotate the matrix by the specified degree by the user
     *
     * @param matrix The matrix object
     */
    private static int[][] rotate(int degree, int[][] matrix) {
        // declare and initialise return matrix
        int[][] processedMatrix = new int[matrix.length][matrix[0].length];

        // based on the user's degree, determine the number of operation
        for (int iteration = (degree / 90); iteration > 0; iteration--) {
            for (int row = 0; row < matrix.length; row++) {
                for (int column = 0; column < matrix[row].length; column++) {
                    processedMatrix[row][column] = matrix[matrix.length - 1 - column][row];
                }
            }
        }

        // return new matrix
        return processedMatrix;
    }

    /**
     * This method is used to reflect the matrix on the X axis
     *
     * @param matrix The matrix object
     */
    private static int[][] reflectX(int[][] matrix) {
        // declare and initialise return matrix
        int[][] processedMatrix = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                processedMatrix[row][column] = matrix[matrix.length - 1 - row][column];
            }
        }

        // return new matrix
        return processedMatrix;
    }

    /**
     * This method is used to reflect the matrix on the Y axis
     *
     * @param matrix The matrix object
     */
    private static int[][] reflectY(int[][] matrix) {
        // declare and initialise return matrix
        int[][] processedMatrix = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                processedMatrix[row][column] = matrix[row][matrix.length - 1 - column];
            }
        }

        // return new matrix
        return processedMatrix;
    }

}