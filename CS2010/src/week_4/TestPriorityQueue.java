package week_4; /**
 * @name: Yeap Hooi Tong
 * @matric: A0111736M
 * @date: 2/12/14
 * @time: 6:16 PM
 */

import java.util.Stack;

/**
 * Class Name: week_4.TestPriorityQueue
 * Description: Test Driver to ensure correct implementation of the PriorityQueue
 */

public class TestPriorityQueue {
    // The given test driver
    public static void main(String[] args) {
        MyPriorityQueue q = new MyPriorityQueue();
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(2);
        q.add(1);
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
/* The output should be
1
2
3
4
5
*/


/**
 * Class Name: week_4.MyPriorityQueue
 * Description: Stack-based implementation of the PriorityQueue
 */
class MyPriorityQueue {
    private Stack<Integer> st; /* used to implement which stores the data in the PriorityQueue */

    /**
     * Default Constructor
     */
    public MyPriorityQueue() {
        /* initialise the stack */
        st = new Stack<Integer>();
    }

    /**
     * Insert an positive integer into the PriorityQueue
     *
     * @param e the integer to be added
     */
    public void add(int e) {
        /* create a temp stack to hold integers that are popped momentarily */
        Stack<Integer> tempStack = new Stack<Integer>();

        /* while the stack is not empty */
        while (!st.isEmpty()) {
            /* check if the new integer is bigger than the top of the queue */
            if (e > st.peek()) tempStack.push(st.pop()); /* if bigger, pop top of stack and insert into temp stack */
            else break; /* the new integer is equal or less than top of the queue */
        }

        st.push(e); /* push the new integer into the correct position into the stack */

        /* return any integers that were popped momentarily into the main stack */
        while (!tempStack.isEmpty()) {
            st.push(tempStack.pop());
        }
    }

    /**
     * Used to remove all the integers that are the smallest in the PriorityQueue
     *
     * @return the smallest integer that was removed from the PriorityQueue else -1 if empty
     */
    public int poll() {
        /* if queue is empty, return -1 */
        if (isEmpty()) return -1;

        /* get the smallest integer in the PriorityQueue */
        int min = st.peek();

        /* if stack is not empty, remove all items that matches the smallest integer */
        while (!st.isEmpty()) {
            if (st.peek() == min) st.pop();
            else break;
        }

        /* return the smallest integer */
        return min;
    }

    /**
     * To check whether the priority queue is empty.  Don't modify this method
     *
     * @return boolean representing whether the priority queue is empty
     */
    public boolean isEmpty() {
        return st.isEmpty();
    }
}

  
  