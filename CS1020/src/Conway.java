import java.util.*;

public class Conway {
    // Data Member
    boolean[][] board;
    int length;

    public Conway(int[][] init, int l) {
        length = l;
        board = new boolean[length][length];

        // Convert from int to boolean
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (init[i][j] == 1) {
                    board[i][j] = true;  // ALIVE
                } else {
                    board[i][j] = false; // DEAD
                }
            }
        }
    }

    // Compute the next step from board
    // - Save the result in board
    public void next() {
        // create a fresh new board for outputting the result
        boolean[][] computedBoard = new boolean[length][length];

        // check every cell in the board and evaluate accordingly based on scenarios
        for(int row = 0; row < length; row++){
            for(int column = 0; column < length; column++){
                // since all 3 evaluations need to get the number of neighbours (living)
                int living = countNeighbor(row, column);

                // check whether is it alive or dead
                if(board[row][column]){
                    if(living < 2) computedBoard[row][column] = false; // if fewer than 2, dies
                    else if(living <= 3) computedBoard[row][column] = true; // if with 2 or 3, lives
                    else computedBoard[row][column] = false; // if more than 3, dies
                }else{
                    if(living == 3) computedBoard[row][column] = true; // if 3 exact, lives
                    else computedBoard[row][column] = false; // else remains dead
                }
            }
        }

        // update the object variable to the new computed board
        board = computedBoard;
    }


    // Count the number of living neighbors at index (i,j)
    // - Index starts from (0,0) to (length-1, length-1)
    public int countNeighbor(int i, int j) {
        // the number of living neighbours
        int livingNeighbours = 0;

        // check its neighbours at all direction
        for(int row = i-1; row <= i+1; row++){
            // check whether its before index 0 or exceed boundaries(ArrayOutOfBound)
            if(row < 0 || row >= length) continue;
            for(int column = j-1; column <= j+1; column++){
                // check whether its before index 0 or exceed boundaries(ArrayOutOfBound)
                if(column < 0 || column >= length) continue;
                // check whether is it living
                if(board[row][column]) livingNeighbours++;
            }
        }

        // return the number of living neighbours excluding itself
        return --livingNeighbours;
    }

    // Simulation
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[][] in = new int[length][length];

        // Read input
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                in[i][j] = sc.nextInt();
            }
        }
        Conway gameOfLife = new Conway(in, length);

        // Simulate
        int steps = sc.nextInt();
        for (int i = 0; i < steps; i++) {
            gameOfLife.next();
        }

        // Print
        boolean[][] out = gameOfLife.board;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (out[i][j]) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}