/**
 * Class Name: Monotone
 * Description: It is a double ended queue and it is a monotonically increasing queue
 * whereby the numbers in the queue must be in increasing order.
 *
 * @name: Yeap Hooi Tong
 * @matric: A0111736M
 * @date: 10/18/13
 * @time: 7:40 AM
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Monotone {
    /* declare data structure to store all the integers */
    private Deque<Node> intQueue;
    private int k;

    /* replace default constructor */
    public Monotone(int k) {
        intQueue = new LinkedList<Node>();
        this.k = k;
    }

    public static void main(String[] args) {
        /* read user input */
        Scanner sc = new Scanner(System.in);

        /* get the number of operations */
        int operations = sc.nextInt();

        /* pass in k to the constructor */
        Monotone mt = new Monotone(sc.nextInt());

        /* accept user's input and perform the specific operation */
        for (int i = 0; i < operations; i++) {
            String type = sc.next();
            if (type.equals("Insert")) {
                mt.insert(sc.nextInt());
            } else if (type.equals("Query")) {
                System.out.println(mt.query()); /* output the query */
            }
        }
    }

    /* This method is used to insert the value into the queue
     * Post-condition: If the queue contains numbers that are more than the given value, they will be removed.
     */
    public void insert(int value) {
        /* create the node */
        Node n = new Node(value);

        /* if the queue is empty, add into the queue*/
        if (intQueue.isEmpty()) {
            intQueue.add(n);
        } else { /* check through from the back */
            while (!intQueue.isEmpty()) {
                /* if the back value is bigger than the current value */
                if (intQueue.peekLast().getValue() > n.getValue()) {
                    intQueue.pollLast(); /* take it out */
                } else {
                    break;
                }
            }

            /* add the node to the back of the queue */
            intQueue.addLast(n);
        }
    }

    /*
     * This method is used to get the minimum value among the K most recently inserted elements
     * Pre-condition: The queue must not be empty and K must be a valid number and within range.
     * Post-condition: The minimum value among K most recently inserted elements is returned.
     */
    public int query() {
        /* get the last index */
        int d = intQueue.getLast().getIndex();
        /* if the first element is not within the Kth most recently inserted */
        while (intQueue.peekFirst().getIndex() <= (d - k)) {
            intQueue.pop();
        }

        /* return the first value which is the minimum of latest K inserted values */
        return intQueue.peekFirst().getValue();
    }
}

/* This class represents each MIQ element */
class Node {
    private static int CURR_INDEX = 1;
    private int value;
    private int index;

    public Node(int value) {
        this.value = value;
        this.index = CURR_INDEX;
        CURR_INDEX++;
    }

    public int getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }
}
