package week_5; /**
 * @author Yeap Hooi Tong
 * @matric A0111736M
 * @date 22/02/14
 */

import java.io.Serializable;

/**
 * Class for a week_5.week_6.Node<E>  that stores type E objects.
 * Easier to use as compare to when week_5.week_6.Node is an inner class of week_5.week_6.BinaryTree
 */
public class Node<E> implements Serializable {

    // Data Fields

    /**
     * The information stored in this node.
     */
    public E data;
    /**
     * Reference to the left child.
     */
    public Node<E> left;
    /**
     * Reference to the right child.
     */
    public Node<E> right;

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
//    if (left == null ) s += " left is null";
//    if (right == null ) s += " right is null";
        return s;
    }

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

