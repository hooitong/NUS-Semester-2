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
        readInput(sc);

    }

    /**
     * This method reads the grid size and number of the tree(s) (N)
     * Afterwards, it reads N number of lines which are the coordinates of the tree
     *
     * @param sc The scanner object
     */
    private static void readInput(Scanner sc) {
        // get the 2 necessary input from the user
        int size = sc.nextInt();
        int noOfTrees = sc.nextInt();

        // create grid object (size x size) based on the user's input
        Grid grid = new Grid(size, noOfTrees);

        // set all default values to 1 (where 1 means it is a empty grid)
        Arrays.fill(grid.matrix, 1);

        // user inputs noOfTrees lines of coordinate, set the tree in the matrix
        for (int i = 0; i < noOfTrees; i++) {
            grid.matrix[sc.nextInt()][sc.nextInt()] = 0;
        }
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
     * checkNoTree   : to check whether the (size x size) square with upper-left coordinate
     * (x, y) contains a tree
     * Pre-condition :
     * Post-condition:
     */
    public boolean checkNoTree(int x, int y, int size) {
        // implementation
        return false;
    }

    /**
     * checkValidSize: to check whether it is possible to find a (size x size) square that contains
     * no tree
     * Pre-condition :
     * Post-condition:
     */
    public boolean checkValidSize(int size) {
        return false;
    }


    /**
     * solve         : use this method to find the largest size of a square with no trees
     * Pre-condition :
     * Post-condition:
     */
    public int solve() {
        // implementation
        return 0;
    }

}