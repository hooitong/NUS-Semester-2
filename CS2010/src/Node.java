/**
 * User: Yeap Hooi Tong
 * Matric: A0111736M
 * Date: 28/1/14
 * Time: 12:44 PM
 * Desc: Class to encapsulate a tree node.
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

    public Node(E data, Node<E> left, Node<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // Methods

    /**
     *
     * @return
     */
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

    /**
     * Returns a string representation of the node.
     *
     * @return A string representation of the data fields
     */
    @Override
    public String toString() {
        return data.toString();
    }
}
