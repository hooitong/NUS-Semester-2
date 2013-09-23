/**
 * Name	     : Yeap Hooi Tong
 * Matric no.: A0111736M
 * Date      : 22/09/13
 */

import java.util.Scanner;

/* use Alternate to represent the integers. */
class AlternateNode {
    private int _element; // representation of the integer
    private AlternateNode _next; // points to the next node

    /**
     * Declare constructor that instantiate the object
     *
     * @param element the integer that the node represents
     * @param next    the next node this object is linked to
     *                Pre-condition: element must not <= 0
     *                Post-condition: node must be instantiated and returned
     */
    public AlternateNode(int element, AlternateNode next) {
        _element = element;
        _next = next;
    }

    /* declare mutators and accessors */
    public int getElement() {
        return _element;
    }

    public void setElement(int element) {
        _element = element;
    }

    public AlternateNode getNext() {
        return _next;
    }

    public void setNext(AlternateNode next) {
        _next = next;
    }
}

class LinkedList {
    /* declare the member field */
    private AlternateNode _head;
    private int _num_nodes;

    /* declare the constructor */
    public LinkedList() {
        _head = null;
    }

    /**
     * add			   : add a listNode to the linked list
     * Pre-condition  : The node should not be already in the list
     * Post-condition : The node will be added into the back of the list
     */
    public void add(AlternateNode altNode) {
        if (_head == null) { // the list is empty
            _head = altNode;
        } else {
            /* traverse to the end and add */
            for (AlternateNode n = _head; n != null; n = n.getNext()) {
                if (n.getNext() == null) { // hit the last node
                    n.setNext(altNode);
                    break;
                }
            }
        }
    }

    /**
     * doMove			: move <size> elements at index <index> to the end of the linked list
     * Pre-condition  	: size does not cause the index to go beyond the size of linked list, size must be positive
     * Post-condition 	: <size> elements at index <index> will be moved to the end of the linked list
     */
    public void doMove(int index, int size) {
        /* call method to remove the block and add to the back of the list */
        add(doRemove(index, size));
    }


    /**
     * doRemove		    : remove <size> elements at index <index>
     * Pre-condition  	: size does not cause the index to go beyond the size of linked list, size must be positive
     * Post-condition 	: <size> elements at index <index> will be moved to the end of the linked list
     */
    public AlternateNode doRemove(int index, int size) {
        AlternateNode beforeNode = null;
        AlternateNode indexNode = _head;

        /* navigate until we reach the node before the index */
        for (int i = 0; i < index - 1; i++) {
            if (beforeNode == null) {
                beforeNode = _head;
            } else {
                beforeNode = beforeNode.getNext();
            }

            indexNode = indexNode.getNext();
        }

        AlternateNode sizeNode = indexNode;
        /* traverse to node after the block */
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                AlternateNode temp = sizeNode.getNext();
                sizeNode.setNext(null); // this is the last node of the block
                sizeNode = temp;
            } else {
                sizeNode = sizeNode.getNext();
            }
        }

        /* set the beforeNode.next to the sizeNode */
        if (indexNode == _head) {
            _head = sizeNode;
        } else {
            beforeNode.setNext(sizeNode);
        }
        /* return the first node of the block */
        return indexNode;
    }


    /**
     * doAdd			: add the value of some elements
     * Pre-condition  	: index, size must be valid and a positive integer
     * Post-condition 	: the elements within the given block are updated with the new value
     */
    public void doAdd(int index, int size, int value) {
        AlternateNode indexNode = _head;
        /* increment the numbers in the block */
        for (int i = 0; i < index - 1 + size; i++) {
            if (i >= index - 1) {
                indexNode.setElement(indexNode.getElement() + value);
            }
            indexNode = indexNode.getNext();
        }
    }


    /**
     * isAlternating	: to check whether this linked list is alternating or not
     * Post-condition 	: A string returned which represents whether the list is alternating
     */
    public String isAlternating() {
        boolean isNegative = false;
        if (_head == null || _head.getNext() == null) { // if there is only 1 element or no element in the list
            return "YES";
        }

        isNegative = _head.getElement() < 0;

        for (AlternateNode n = _head.getNext(); n != null; n = n.getNext()) {
            if (isNegative && n.getElement() < 0) return "NO";
            else if (!isNegative && n.getElement() > 0) return "NO";
            else {
                isNegative = !isNegative;
            }
        }

        return "YES";
    }
}

public class Alternate {
    public static void main(String[] args) {

        /* declare the necessary variables */
        LinkedList ls = new LinkedList();

        /* declare a Scanner object to read input */
        Scanner sc = new Scanner(System.in);

        /* read input and process them accordingly */
        int noOfNodes = sc.nextInt(); // the number of nodes in the linked list
        int updates = sc.nextInt(); // the number of updates done for this run
        for (int i = 0; i < noOfNodes; i++) {
            ls.add(new AlternateNode(sc.nextInt(), null));
        }

        /* read and process each update from the user */
        for (int i = 0; i < updates; i++) {
            String mode = sc.next();
            if (mode.equals("M")) {
                ls.doMove(sc.nextInt(), sc.nextInt());
            } else if (mode.equals("A")) {
                ls.doAdd(sc.nextInt(), sc.nextInt(), sc.nextInt());
            } else if (mode.equals("R")) {
                ls.doRemove(sc.nextInt(), sc.nextInt());
            }

            // print the output for each update
            System.out.println(ls.isAlternating());
        }
    }
}