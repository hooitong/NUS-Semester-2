/**
 * This class accepts a matrix of size N x M and its values, and based on operation, will return the sum
 * @author Yeap Hooi Tong
 * @matric A0111736M
 * @date 21/8/13
 * @version 1.0
 */

import java.util.Scanner;

public class Matrix {
    // declare and initialise variables
    static int[][] grid;
    static String operation;
    static int index;

    public static void main(String[] args) {
        // declare and create scanner object
        Scanner sc = new Scanner(System.in);

        // read the user's input and create the 2d array
        readInput(sc);

        // based on user's given operation and input, calculate the sum
        evaluateOperation();
    }

    /**
     * This method reads the input and creates the 2D array
     *
     * @param sc The scanner object
     */
    private static void readInput(Scanner sc) {
        int sizeN = sc.nextInt();
        int sizeM = sc.nextInt();

        grid = new int[sizeN][sizeM];

        // based on the array, fill in with user's input
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                grid[row][column] = sc.nextInt();
            }
        }

        // get mode of operation as well as the column/row
        operation = sc.next();
        index = sc.nextInt();
    }

    /**
     * This method evaluates the operation provided by the user
     */
    private static void evaluateOperation() {
        int sum = 0;

        if (operation.equals("ROW")) { // if the operation is a "ROW"
            for (int column = 0; column < grid[index - 1].length; column++) {
                sum += grid[index - 1][column];
            }
        } else if (operation.equals("COLUMN")) {  // if the operation is a "COLUMN'
            for (int row = 0; row < grid.length; row++) {
                sum += grid[row][index - 1];
            }
        }

        // print out the total sum as output
        System.out.println(sum);
    }
}
