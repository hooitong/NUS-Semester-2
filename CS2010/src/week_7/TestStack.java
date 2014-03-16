package week_7; /**
 * @author Yeap Hooi Tong
 * @matric A0111736M
 * @date 10/03/14
 * @desc The program implements a Stack via PriorityQueue implementation and
 * tests the output between the implemented stack and the API implementation.
 */

import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class TestStack {
    /* Default Test Driver */
    public static void main(String[] args) {
        MyStack<Integer> st = new MyStack<Integer>();
        Stack<Integer> st1 = new Stack<Integer>();
        System.out.println("Fill a Java stack and week_7.MyStack with some random numbers ");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < 50; ++i) { /* Sample size of 50 Items */
            int j = (int) (Math.random() * 1000);
            st.push(j);
            st1.push(j);
        }

        /* Print both stacks to verify correctness */
        System.out.println("Print the 2 stacks for comparison");
        System.out.println("PQ Implementation : " + st.toString());
        System.out.println("API Stack         : " + st1.toString());
        System.out.println("------------------------------------------------------");

        /* Pop 5 items and Push in another 10 items */
        System.out.println("Remove 5 Item from both Stacks in [Implementation, Original] pair");
        for (int i = 0; i < 5; ++i) {
            System.out.println("[" + st.pop() + "," + st1.pop() + "]");
        }

        System.out.println("------------------------------------------------------");
        System.out.println("Fill a Java stack and week_7.MyStack with 10 random numbers ");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < 10; ++i) { /* Sample size of 10 Items */
            int j = (int) (Math.random() * 1000);
            st.push(j);
            st1.push(j);
        }

        /* Print both stacks to verify correctness */
        System.out.println("Print the 2 stacks for comparison");
        System.out.println("PQ Implementation : " + st.toString());
        System.out.println("API Stack         : " + st1.toString());
        System.out.println("------------------------------------------------------");
    }
}

/* Node class that contains the item to be stored and its priority */
class MyNode<E> {
    /* Preferably immutable variables as they should not be edited when inserted */
    private BigInteger priority;
    private E data;

    /* Constructor that accepts 2 inputs and return the instantiated object */
    public MyNode(E d, BigInteger p) {
        priority = p;
        data = d;
    }

    /* Getters Methods for data and priority */
    public E getData() {
        return data;
    }

    public BigInteger getPriority() {
        return priority;
    }

    @Override
    /* Override the toString method to return the data string representation to the parent call */
    public String toString() {
        return data.toString();
    }
}

/* Comparator class to compare the node priority in the PriorityQueue */
class ComparatorMyNode<E> implements Comparator<MyNode<E>> {
    public int compare(MyNode<E> e1, MyNode<E> e2) {
        return e2.getPriority().compareTo(e1.getPriority());
    }
}

/* Stack class that is implemented via a PriorityQueue data structure */
class MyStack<E> {
    private PriorityQueue<MyNode<E>> pq; /* the PriorityQueue data structure */
    private int MIN_SIZE = 10; /* initial size of the stack */
    private BigInteger pID; /* priority ID of the next free node */

    /* Default constructor that initialise the stack and return the stack object */
    public MyStack() {
        pq = new PriorityQueue<MyNode<E>>(MIN_SIZE, new ComparatorMyNode<E>());
        pID = new BigInteger("0");
    }

    /**
     * Returns a boolean to determine whether the stack is empty.
     *
     * @return boolean variable
     */
    public boolean isEmpty() {
        return pq.isEmpty();
    }

    /**
     * Returns the object reference of the front of the stack
     *
     * @return the object reference at the top of the stack
     */
    public E peek() {
        return pq.peek().getData();
    }

    /**
     * Remove the object from the top of the stack and return
     *
     * @return the object reference at the top of the stack
     */
    public E pop() {
        return pq.poll().getData();
    }

    /**
     * Push an item into the stack passed in by the parent
     *
     * @param item The data to be stored into the Stack
     * @return the item argument
     */
    public E push(E item) {
        pq.offer(new MyNode<E>(item, pID));
        pID = pID.add(BigInteger.ONE); /* increment the next ID */
        return item;
    }

    @Override
    /* Override default toString method and return the PriorityQueue nodes in the correct order */
    public String toString() {
        /* inefficient method but doable way to get the ordered stack as PQ returns a unordered Iterator */
        /* create a temp stack and transfer from original stack to temp */
        MyStack<E> temp = new MyStack<E>();
        String retString = "[";
        while (!isEmpty()) {
            temp.push(pop());
        }

        /* recover the original stack while printing each element */
        while (!temp.isEmpty()) {
            E item = temp.pop();
            retString = retString + item + ", ";
            push(item);
        }

        /* reformat the string to the standard java collection toString format */
        retString = retString.endsWith(", ") ? retString.substring(0, retString.length() - 2) + "]" : retString + "]";

        return retString;
    }
}