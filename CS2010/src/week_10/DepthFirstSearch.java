package week_10; /**
 * @name: Yeap Hooi Tong
 * @matric: A0111736M
 * @date: 01/04/14
 * @time: 9:43 AM
*/

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Class to implement the depth-first search algorithm.
 *
 * @author Koffman and Wolfgang
 */
public class DepthFirstSearch {

    // Data Fields
    /**
     * A reference to the graph being searched.
     */
    private Graph graph;
    /**
     * Array of parents in the depth-first search tree.
     */
    private int[] parent;
    /**
     * Flag to indicate whether this vertex has been visited.
     */
    private boolean[] visited;
    /**
     * The array that contains each vertex in discovery order.
     */
    private int[] discoveryOrder;
    /**
     * The array that contains each vertex in finish order.
     */
    private int[] finishOrder;
    /**
     * The index that indicates the discovery order.
     */
    private int discoverIndex = 0;
    /**
     * The index that indicates the finish order.
     */
    private int finishIndex = 0;

    // Constructors

    /**
     * Construct the depth-first search of a week_10.Graph
     * starting at vertex 0 and visiting the start vertices in
     * ascending order.
     *
     * @param graph The graph
     */
    public DepthFirstSearch(Graph graph) {
        this.graph = graph;
        int n = graph.getNumV();
        parent = new int[n];
        visited = new boolean[n];
        discoveryOrder = new int[n];
        finishOrder = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                depthFirstSearch(i);
            }
        }
    }

    /**
     * Construct the depth-first search of a week_10.Graph
     * selecting the start vertices in the specified order.
     * The first vertex visited is order[0].
     *
     * @param graph The graph
     * @param order The array giving the order
     *              in which the start vertices should be selected
     */
    public DepthFirstSearch(Graph graph, int[] order) {
        this.graph = graph;
        int n = graph.getNumV();
        parent = new int[n];
        visited = new boolean[n];
        discoveryOrder = new int[n];
        finishOrder = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[order[i]]) {
                depthFirstSearch(i);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = null;
        int n = 0;
        try {
            Scanner scan = new Scanner(new File(args[0]));
            g = AbstractGraph.createGraph(scan, true, "List");
            n = g.getNumV();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        DepthFirstSearch dfs = new DepthFirstSearch(g);
        int[] dOrder = dfs.getDiscoveryOrder();
        int[] fOrder = dfs.getFinishOrder();
        System.out.println("Discovery and finish order");
        for (int i = 0; i < n; i++) {
            System.out.println(dOrder[i] + " " + fOrder[i]);
        }
    }

    /**
     * Recursively depth-first search the graph
     * starting at vertex current.
     *
     * @param current The start vertex
     */
    public void depthFirstSearch(int current) {
        // Mark the current vertex visited.
        visited[current] = true;
        discoveryOrder[discoverIndex++] = current;
        // Examine each vertex adjacent to the current vertex
        Iterator<Edge> itr = graph.edgeIterator(current);
        while (itr.hasNext()) {
            int neighbor = itr.next().getDest();
            // Process a neighbor that has not been visited
            if (!visited[neighbor]) {
                // Insert (current, neighbor) into the depth-
                // first search tree.
                parent[neighbor] = current;
                // Recursively apply the algorithm
                // starting at neighbor.
                depthFirstSearch(neighbor);
            }
        }
        // Mark current finished.
        finishOrder[finishIndex++] = current;
    }

    /**
     * Get the finish order
     *
     * @return finish order
     */
    public int[] getFinishOrder() {
        return finishOrder;
    }

    /**
     * Get the discovery  order
     *
     * @return discovery order
     */
    public int[] getDiscoveryOrder() {
        return discoveryOrder;
    }

    /**
     * Get the parent
     *
     * @return the parent
     */
    public int[] getParent() {
        return parent;
    }
}
/* input file fig10p25.txt
9
0 1
0 3
1 2
1 4
1 5
2 5
3 6
4 6
4 7
5 7
6 8
7 8

 * 
 * 
 * 
 * Ouput:
 * Discovery and finish order 
0 8 
1 7 
2 5 
5 2 
7 6 
8 4 
4 1 
6 3 
3 0 
*/