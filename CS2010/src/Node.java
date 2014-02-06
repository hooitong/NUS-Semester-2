/**
 * @author Yeap Hooi Tong
 * @matric A0111736
 * @date 03/02/14
 * @desc Class for a Node<E>  that stores type E objects.
 * Easier to use as compare to when Node is an inner class of BinaryTree
 */

import java.io.Serializable;

public class Node<E> implements Serializable {

    // Data Fields

    /**
     * The information stored in this node.
     */
    private E data;
    /**
     * Reference to the left child.
     */
    private Node<E> left;
    /**
     * Reference to the right child.
     */
    private Node<E> right;

    // Constructors

    /**
     * Construct a node with given data and no children.
     *
     * @param data The data to store in this node
     */
    public Node(E data) {
        this.data = data;
        left = null;
        right = null;
    }

    /**
     * Construct a node with given data and two child nodes
     *
     * @param data  The data to store in this node
     * @param left  Left child node
     * @param right Right child node
     */
    public Node(E data, Node<E> left, Node<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // Methods

    /**
     * Returns a string representation of the node.
     *
     * @return A string representation of the data fields
     */
    @Override
    public String toString() {
        String s = data.toString();
        return s;
    }

    /* getter and setter methods */

    public E getData() {
        return data;
    }

    public void setData(E newData) {
        data = newData;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

}

