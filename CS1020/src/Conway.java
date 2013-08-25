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
        // Your code here...
    }


    // Count the number of living neighbors at index (i,j)
    // - Index starts from (0,0) to (length-1, length-1)
    public int countNeighbor(int i, int j) {
        return 0;
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