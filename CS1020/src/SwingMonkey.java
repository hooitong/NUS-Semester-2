/**
 * Class Name: SwingMonkey
 * Description: Calculate the total number of pairs of tree
 * that the monkeys' can swing from one to another
 *
 * @name: Yeap Hooi Tong
 * @matric: A0111736M
 * @date: 10/17/13
 * @time: 7:28 PM
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SwingMonkey {
    /* declare stack data structure to store all the integers */
    private Queue<Integer> intQueue;
    private Stack<Integer> chainStack;

    /* replace default constructor */
    public SwingMonkey() {
        intQueue = new LinkedList<Integer>();
        chainStack = new Stack<Integer>();
    }

    public static void main(String[] args) {
        /* read input from user */
        Scanner sc = new Scanner(System.in);
        SwingMonkey sm = new SwingMonkey();

        int N = sc.nextInt(); /* number of integers */
        for (int i = 0; i < N; i++) {
            sm.insert(sc.nextInt());
        }

        /* call the method to calculate and print the result */
        System.out.println(sm.calculate());
    }

    /* method to insert item into queue */
    public void insert(int i) {
        intQueue.add(i);
    }

    /* This method is used to calculate the total number of pairs of trees
     * that they can swing directly from one to another.
     * Pre-condition: the queue must be initialised with the user's input
     * Post-condition: a long number up to 64 bit is returned that contains the number of pairs
     */
    public long calculate() {
        /* used to store the number of pairs */
        long noOfTrees = 0;

        /* process all the integer in the stack */
        while (!intQueue.isEmpty()) {

            /* take out the head */
            int temp = intQueue.poll();

            /* create a temp stack so that we can iterate through the current stack */
            if(!chainStack.isEmpty()){
                Stack<Integer> tempStack = new Stack<Integer>();
                while(!chainStack.isEmpty()){
                    noOfTrees++; /* iterate the number of pairs */
                    if(chainStack.peek() >= temp) break; /* this signify that any tree behind the peeked tree cannot jump to this tree */
                    else{ tempStack.push(chainStack.pop()); } /* store in tempStack */
                }

                /* put back the values into the original stack */
                while(!tempStack.isEmpty()){
                    chainStack.push(tempStack.pop());
                }
            }

            /* this block will not run if the newly acquired int is the last one in the queue */
            if (!intQueue.isEmpty()) {
                  /* compare to the next one in the queue (using peek) */
                  /* pop out those in the stack there are smaller then temp */
                    while (!chainStack.isEmpty()) {
                        if (chainStack.peek() <= temp) {
                            chainStack.pop();
                        } else {
                            break;
                        }
                    }
            }

            /* push temp into stack */
            chainStack.push(temp);
        }

        /* return the result */
        return noOfTrees;
    }
}
