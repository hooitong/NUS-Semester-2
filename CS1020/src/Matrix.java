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
        Scanner sc = new Scanner(System.in);
        readInput(sc);

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
     * This method reads the input and creates the 2D array
     */
    private static void evaluateOperation() {
        int sum = 0;

        if (operation.equals("ROW")) {
            for (int column = 0; column < grid[index - 1].length; column++) {
                sum += grid[index - 1][column];
            }
        } else if (operation.equals("COLUMN")) {
            for (int row = 0; row < grid.length; row++) {
                sum += grid[row][index - 1];
            }
        }

        System.out.println(sum);
    }
}
