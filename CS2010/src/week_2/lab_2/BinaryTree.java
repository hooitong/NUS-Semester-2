package week_2.lab_2; /**
 * User: Yeap Hooi Tong
 * Matric: A0111736M
 * Date: 28/1/14
 * Time: 12:44 PM
 */

/**
 * Class for a binary tree that stores type E objects.
 *
 * @author Koffman and Wolfgang
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;

public class BinaryTree<E> implements Serializable {

    // Data Field
    /**
     * The root of the binary tree
     */
    private Node<E> root;

    /**
     * Construct an empty week_2.lab_2.week_2.tutorial_2.week_3.week_4.BinaryTree
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Construct a week_2.lab_2.week_2.tutorial_2.week_3.week_4.BinaryTree with a specified root.
     * Should only be used by subclasses.
     *
     * @param root The node that is the root of the tree.
     */
    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    /**
     * Constructs a new binary tree with data in its root,leftTree
     * as its left subtree and rightTree as its right subtree.
     */
    public BinaryTree(E data, BinaryTree<E> leftTree,
                      BinaryTree<E> rightTree) {
        root = new Node<E>(data);
        if (leftTree != null) {
            root.setLeft(leftTree.root);
        } else {
            root.setLeft(null);
        }
        if (rightTree != null) {
            root.setRight(rightTree.root);
        } else {
            root.setRight(null);
        }
    }

    /**
     * Method to read a binary tree.
     *
     * @param bR The input file
     * @return The binary tree
     * @throws IOException If there is an input error
     * @pre The input consists of a preorder traversal
     * of the binary tree. The line "null" indicates a null tree.
     */
    public static BinaryTree<String> readBinaryTree(BufferedReader bR)
            throws IOException {
        // Read a line and trim leading and trailing spaces.
        String data = bR.readLine().trim();
        if (data.equals("null")) {
            return null;
        } else {
            BinaryTree<String> leftTree = readBinaryTree(bR);
            BinaryTree<String> rightTree = readBinaryTree(bR);
            return new BinaryTree<String>(data, leftTree, rightTree);
        }
    }

    public Node<E> getRoot() {
        return root;
    }

    /**
     * Return the left subtree.
     *
     * @return The left subtree or null if either the root or
     * the left subtree is null
     */
    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.getLeft() != null) {
            return new BinaryTree<E>(root.getLeft());
        } else {
            return null;
        }
    }

    /**
     * Return the right sub-tree
     *
     * @return the right sub-tree or
     * null if either the root or the
     * right subtree is null.
     */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.getRight() != null) {
            return new BinaryTree<E>(root.getRight());
        } else {
            return null;
        }
    }

    /**
     * Return the data field of the root
     *
     * @return the data field of the root
     * or null if the root is null
     */
    public E getData() {
        if (root != null) {
            return root.getData();
        } else {
            return null;
        }
    }

    /**
     * Determine whether this tree is a leaf.
     *
     * @return true if the root has no children
     */
    public boolean isLeaf() {
        return (root == null || (root.getLeft() == null && root.getRight() == null));
    }

    /**
     * Method to return the preorder traversal of the binary tree
     * as a sequence of tokens each separated by a space.
     *
     * @return A preorder traversal as a string
     */
    public String preorderToString() {
        StringBuilder stb = new StringBuilder();
        preorderToString(stb, root);
        return stb.toString();
    }

    private void preorderToString(StringBuilder stb, Node<E> root) {
        if (root == null) return;
        stb.append(root);
        if (root.getLeft() != null) {
            stb.append(" ");
            preorderToString(stb, root.getLeft());
        }
        if (root.getRight() != null) {
            stb.append(" ");
            preorderToString(stb, root.getRight());
        }
    }
}