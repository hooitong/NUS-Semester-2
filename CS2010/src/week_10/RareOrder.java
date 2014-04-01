package week_10; /**
 * Class Name: week_10.RareOrder
 * Description: The class reads in strings of uppercase letters and determine the collating sequence
 * based on the given input.
 *
 * @name: Yeap Hooi Tong
 * @matric: A0111736M
 * @date: 01/04/14
 * @time: 9:43 AM
 */

import java.util.Scanner;
import java.util.TreeSet;

public class RareOrder {
    public static void main(String[] args) {
        processSort(); /* call submethod to solve the problem */
    }

    /**
     * This method reads in from the user and determine the collating sequence
     * via topological sort and the graph data structure.
     */
    public static void processSort() {
        /* create a graph with 26 vertices where each vertice represent a uppercase alphabet */
        Graph g = new MatrixGraph(26, true);

        /* create a set to stored the used vertices */
        TreeSet<Integer> usedV = new TreeSet<Integer>();

        /* create a scanner to read in user's input */
        Scanner sc = new Scanner(System.in);

        /* create infinite loop as loop only exits when # is provided */
        while (true) {
            String sequence = sc.next();
            /* if input is "#", denotes end of file */
            if (sequence.equals("#")) break;

            /* insert directed edge of each adjacent characters (left to right) in the given string into the graph */
            for (int i = 0; i < sequence.length() - 1; i++) {
                usedV.add(sequence.charAt(i) - 'A');
                usedV.add(sequence.charAt(i+1) - 'A');
                g.insert(new Edge(sequence.charAt(i) - 'A', sequence.charAt(i + 1) - 'A'));
            }
        }

        /* perform depth-first search to acquire the collating sequence in reverse */
        DepthFirstSearch dfs = new DepthFirstSearch(g);
        int[] finishOrder = dfs.getFinishOrder();

        /* print out the collating sequence from the DFS result */
        for (int i = finishOrder.length - 1; i >= 0; i--){
            if(usedV.contains(finishOrder[i])){
                System.out.print(Character.toString((char)(finishOrder[i] + 'A')));
            }
        }
    }
}
