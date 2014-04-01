package week_9; /**
 * @author Yeap Hooi Tong
 * @matric A0111736M
 * @date 22/03/14
 * @desc The program creates a undirected graph (Adj List implementation)
 * based on user's input and applies its optimal color.
 */

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class GraphColoring {
    /* declare class variables to keep track of the colors in the graph */
    public static int minWhite; /* track the smallest amount of white vertices */
    public static int[] vColor; /* 0 - uncolored , 1 - white, 2 - black */
    public static int[] chosenPath; /* track the chosen path which contains a max solution */

    /**
     * Ensure that each vertice is either black or white and print
     * the maximum number of black vertices and the chosen vertices that are black
     *
     * @param g the instantiated graph object
     * @pre assume that the graph is not empty and only 1 graph is given.
     */
    public static void colorIt(Graph g) {
        /* instantiate the variables */
        minWhite = g.getNumV();
        vColor = new int[g.getNumV()];

        /* call recursive method to perform backtracking */
        colorIt(g, 0, 0);

        /* print the desired output */
        System.out.println(g.getNumV() - minWhite);
        for (int i = 0; i < chosenPath.length; i++) {
            if (chosenPath[i] == 2) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * Perform recursive backtracking method to acquire the
     * maximum path of the graph.
     *
     * @param g the instantiated graph object
     * @param i the vertice index
     * @param w the number of white vertices in the current path
     */
    private static void colorIt(Graph g, int i, int w) {
        /* base case when index exceeds length */
        if (i >= g.getNumV()) {
            /* if this path contains lesser white vertices, save to class variable */
            if (w < minWhite) {
                minWhite = w;
                chosenPath = vColor.clone();
            }
        } else {
            /* iterate through every neighbour vertices */
            Iterator<Edge> itr = g.edgeIterator(i);

            /* check whether the eligibility of the current vertice to turn black */
            boolean isBlack = true;
            while (itr.hasNext()) {
                int n = itr.next().getDest();
                isBlack = isBlack && vColor[n] != 2;
            }

            /* if eligible, try the black path */
            if (isBlack) {
                vColor[i] = 2;
                colorIt(g, i + 1, w);
            }

            /* nevertheless, try the white path as part of backtracking */
            vColor[i] = 1;
            colorIt(g, i + 1, w + 1);

            /* reset to 0 for backtracking purposes */
            vColor[i] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Graph g = AbstractGraph.createGraph(scan, false, "List");
        colorIt(g);
    }
}