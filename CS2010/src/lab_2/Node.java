package lab_2; /**
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

    /**
     * Construct a node with given data and 2 given children.
     *
     * @param data  The data to store in this node
     * @param left  Reference to the left child
     * @param right Reference to the right child
     */
    public Node(E data, Node<E> left, Node<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // Methods

    /**
     * Returns the information stored in the node
     *
     * @return info stored in node
     */
    public E getData() {
        return data;
    }

    /**
     * Replace the node's data with the given data
     *
     * @param newData the new data given
     */
    public void setData(E newData) {
        data = newData;
    }

    /**
     * Returns the left child node reference
     *
     * @return reference to the left child
     */
    public Node<E> getLeft() {
        return left;
    }

    /**
     * Replace the left child node reference with the given one
     *
     * @param left new reference for the left child
     */
    public void setLeft(Node<E> left) {
        this.left = left;
    }

    /**
     * Returns the right child node reference
     *
     * @return reference to the right child
     */
    public Node<E> getRight() {
        return right;
    }

    /**
     * Replace the right child node reference with the given one
     *
     * @param right new reference for the right child
     */
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
