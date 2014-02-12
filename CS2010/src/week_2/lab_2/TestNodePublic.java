package week_2.lab_2; /**
 * User: Yeap Hooi Tong
 * Matric: A0111736M
 * Date: 28/1/14
 * Time: 12:44 PM
 * Desc: Test driver to test the functionality of the node class
 */

import java.io.IOException;

/* Create a binary tree from scratch using the methods in the week_2.lab_2.week_3.Node class
 * */
public class TestNodePublic {
    public static void main(String[] args) throws IOException {
        /* create 3 nodes that each contains its test data */
        Node<String> operator = new Node<String>("+", null, null);
        Node<String> operand_1 = new Node<String>("1");
        Node<String> operand_2 = new Node<String>("2");

        /* create binary tree and store the root (operator) */
        BinaryTree<String> bt = new BinaryTree<String>(operator);

        /* test getLeft(), getRight(), setLeft(), setRight() of the node class by adding the operands to the operator */
        System.out.println("Binary Tree #1");
        bt.getRoot().setLeft(operand_1);
        System.out.println(bt.getRoot().getLeft() + " has been inserted into the left node of the root");

        bt.getRoot().setRight(operand_2);
        System.out.println(bt.getRoot().getRight() + " has been inserted into the right node of the root");

        /* test the preorderToString() method */
        System.out.println(bt.preorderToString() + " (pre-order traversal)");

        /* change the root data for demonstration purpose as well as test getData() & set setData() of the week_2.lab_2.week_3.Node class */
        System.out.println("Current root before change: " + bt.getRoot().getData());
        bt.getRoot().setData("/");
        System.out.println("Current root after change: " + bt.getRoot().getData());
        /* test the preorderToString() method */
        System.out.println(bt.preorderToString() + " (pre-order traversal)");

        /* create a binary tree that contains an simple expression*/
        BinaryTree<String> bt2 = new BinaryTree<String>(new Node<String>("*", new Node<String>("3"), new Node<String>("4")));
        System.out.println("\nBinary Tree #2\nTree created with the expression 3 * 4");
        /* use preorderToString() method to test whether the tree has been constructed properly */
        System.out.println(bt2.preorderToString() + " (pre-order traversal)");
    }
}

