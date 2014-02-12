/**
 * @name: Yeap Hooi Tong
 * @matric: A0111736M
 * @date: 2/12/14
 * @time: 6:16 PM
 */

import java.util.PriorityQueue;

/**
 * Class Name: TestMaxMin
 * Description: It is used to test whether the Java PriorityQueue<E> class is a min-heap or max-heap
 */

public class TestMaxMin {
    public static void main(String[] args) {
        /* max-heap is defined to have the biggest number at the top of the heap
         * while min-heap is defined to have the smallest number at the top */

        /* we know that PriorityQueue uses heap implementation, thus first we create the PriorityQueue object */
        PriorityQueue<Integer> testQueue = new PriorityQueue<Integer>();

        /* add in simple test data */
        testQueue.add(4);
        testQueue.add(8);
        testQueue.add(16);
        testQueue.add(1);
        testQueue.add(2);

        /* if its a max-heap, 16 would be returned else 1 for min-heap (root of the heap) */
        int root = testQueue.poll();

        if (root == 1) System.out.println("PriorityQueue is a min-heap implementation.");
        else if (root == 16) System.out.println("PriorityQueue is a max-heap implementation");
    }
}
