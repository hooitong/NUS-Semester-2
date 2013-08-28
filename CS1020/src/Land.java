/**
 * This class a
 * @author Yeap Hooi Tong
 * @matric A0111736M
 * @date 21/8/13
 * @version 1.0
 */

import java.util.*;

public class Land {

    public static void main(String[] args) {

        // declare the necessary variables
        Scanner sc = new Scanner(System.in);

        // read user input
        Grid grid = readInput(sc);

        // solve the equation
        grid.calculate();
    }

    /**
     * This method reads the grid size and number of the tree(s) (N)
     * Afterwards, it reads N number of lines which are the coordinates of the tree
     *
     * @param sc
     * The scanner object
     * @return Grid
     * The filled grid object
     */
    private static Grid readInput(Scanner sc) {
        // get the 2 necessary input from the user
        int size = sc.nextInt();
        int noOfTrees = sc.nextInt();

        // create grid object (size x size) based on the user's input
        Grid grid = new Grid(size, noOfTrees);

        // set all default values to 1 (where 1 means it is a empty grid)
        for(int[] row : grid.matrix)
            Arrays.fill(row, 1);

        // user inputs noOfTrees lines of coordinate, set the tree in the matrix
        for (int i = 0; i < noOfTrees; i++) {
            grid.matrix[sc.nextInt()-1][sc.nextInt()-1] = 0;
        }

        return grid;
    }
}

class Grid {

    int size; // width or length of the grid (W=L)
    int noOfTrees; // number of trees in the grid (save the need to loop through)
    int[][] matrix; // the 2d array that contains the grid. each integer represents the max empty space it can go

    // overload constructor to create the 2d grid
    public Grid(int size, int noOfTrees) {
        matrix = new int[size][size];
        this.size = size;
        this.noOfTrees = noOfTrees;
    }

    /**
     * This method finds the the largest possible square with no trees in it [n(size*size)]
     */
    public void calculate(){
        int largestSize = 0; // counter to keep track on the largest possible size

        // iterate from the bottom right up (ignoring bottom and right edges)
        for(int row = matrix.length-2; row >= 0; row--){
            for(int column =  matrix[row].length-2; column >= 0; column--){
                if(matrix[row][column] == 0) continue; // if its a tree, ignore
                matrix[row][column] = 1 + Math.min(matrix[row][column+1], Math.min(matrix[row+1][column], matrix[row+1][column+1]));
                if(matrix[row][column] > largestSize) largestSize = matrix[row][column]; // keep track of the largest square
            }
        }

        // print out the output
        System.out.println(largestSize);
    }

}