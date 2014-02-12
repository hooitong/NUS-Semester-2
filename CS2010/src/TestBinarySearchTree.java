/**
 * User: Yeap Hooi Tong
 * Matric: A0111736M
 * Date: 11/2/14
 */

import java.util.List;
import java.util.Random;

public class TestBinarySearchTree {

    /**
     * Traverses ordered list and displays each element.
     * Displays an error message if an element is out of order.
     *
     * @param testList An ordered list of integers
     * @author Koffman & Wolfgang
     */
    public static void traverseAndShow(BinarySearchTree<Integer> testTree) {
        List<Integer> testList = testTree.toList();
        int prevItem = testList.get(0);

        // Traverse ordered list and display any value that
        // is out of order.
        for (int thisItem : testList) {
            System.out.print(thisItem + " ");
            if (prevItem > thisItem) {
                System.out.println("*** FAILED, value is "
                        + thisItem);
            }
            prevItem = thisItem;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> testTree = new BinarySearchTree<Integer>();
        final int MAX_INT = 500;
        final int START_SIZE = 20;

        // Create a random number generator.
        Random random = new Random();
        for (int i = 0; i < START_SIZE; i++) {
            int anInteger = random.nextInt(MAX_INT);
            testTree.add(anInteger);
        }

        // Add to beginning and end of list.
        testTree.add(-1);
        testTree.add(MAX_INT + 1);
        System.out.println("Add to beginning and end of list.");
        traverseAndShow(testTree); // Traverse and display.
        List<Integer> testList = testTree.toList();
        // Remove first, last, and middle elements.
        Integer first = testList.get(0);
        Integer last = testList.get(testList.size() - 1);
        Integer middle = testList.get(testList.size() / 2);
        testTree.remove(first);
        testTree.remove(last);
        testTree.remove(middle);
        System.out.println(" Remove first, last, and middle elements.");
        traverseAndShow(testTree); // Traverse and display.
        // Test of deletePrime
        // Build balanced tree with 1 - 7
        testTree = new BinarySearchTree<Integer>();
        testTree.add(4);
        testTree.add(2);
        testTree.add(6);
        testTree.add(1);
        testTree.add(3);
        testTree.add(5);
        testTree.add(7);
        String expected = "4 2 1 3 6 5 7";
        if (!expected.equals(testTree.preorderToString())) {
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + testTree.preorderToString());
        } else {
            System.out.println("Initial shape as expected");
        }
        testTree.deletePrime(3);
        expected = "4 2 1 6 5 7";
        if (!expected.equals(testTree.preorderToString())) {
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + testTree.preorderToString());
        } else {
            System.out.println("After deletePrime(3) shape as expected");
        }
        expected = "4 1 6 5 7";
        testTree.deletePrime(2);
        if (!expected.equals(testTree.preorderToString())) {
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + testTree.preorderToString());
        } else {
            System.out.println("After deletePrime(2) shape as expected");
        }
    }
}
