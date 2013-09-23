/**
 * User: Yeap Hooi Tong
 * Matric No: A0111736
 * Date: 9/21/13
 * Time: 8:33 PM
 */
import java.util.*;

// use ListNode to represent the balls.
class ListNode {
    private int element; // the number representing the node
    private ListNode prev, next; // pointers to the back and front of the node

    /**
     * This constructor instantiate the object with the element passed in
     * Pre-condition: element must not be 0
     * Post-condition: a ListNode object is instantiated with the given value and return to parent
     */

    public ListNode(int element, ListNode prev, ListNode next){
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    /* set mutators and accessors of variables */
    public int getElement(){
        return element;
    }

    public ListNode getPrev(){
        return prev;
    }

    public ListNode getNext(){
        return next;
    }

    public void setPrev(ListNode prev){
        this.prev = prev;
    }

    public void setNext(ListNode next){
        this.next = next;
    }
}

class MyLinkedList {

    // declare the member field
    private ListNode head, tail; // the pointers to the head and tail of the list
    private int num_nodes;

    // declare the constructor which instantiate the object
    public MyLinkedList(){
        num_nodes = 0;
        head = null;
        tail = null;
    }

    /**
     *		doA				: implement the operation for A
     * 		Pre-condition  	: x and y must exist the in the ListNode
     * 		Post-condition 	: if x is to the right of y, move to left of y
     */
    public void doA(int x, int y) {
        ListNode lnY = null;
        ListNode lnX = null;

        // traverse the node until it reaches x, if it hits y along the way, continue
        for(ListNode n = head; n!=null; n = n.getNext()){

            if(n.getElement() == y) {
                lnY = n;
            }

            if(n.getElement() == x){
                lnX = n;

                // settle the chains for x
                if(lnX == head && lnX == tail) { // only one node in the list
                    head = null;
                    tail = null;
                }
            }

            if(lnX != null && lnY != null) {
                // check whether x is on the left of Y
                if(lnY.getPrev() == lnX) break;

                // fix prev pointer
                if(lnX != tail){
                    lnX.getNext().setPrev(lnX.getPrev());
                } else {
                    tail = lnX.getPrev();
                    tail.setNext(null);
                }

                // fix next pointer
                if(lnX != head){
                    lnX.getPrev().setNext(lnX.getNext());
                } else {
                    head = lnX.getNext();
                    head.setPrev(null);
                }

                // insert it before y
                if(lnY != head){
                    lnX.setPrev(lnY.getPrev());
                    lnY.getPrev().setNext(lnX);
                } else {
                    head = lnX;
                    head.setPrev(null);
                }

                lnY.setPrev(lnX);
                lnX.setNext(lnY);
            }
        }
    }


    /**
     *		doB				: implement the operation for B
     * 		Pre-condition  	: x and y must exist the in the ListNode
     * 		Post-condition 	: if x is to the left of y, move to right of y
     */
    public void doB(int x, int y) {
        ListNode lnX = null;
        ListNode lnY = null;

        // traverse the node until it reaches x, if it hits y along the way, break
        for(ListNode n = head; n!=null; n = n.getNext()){

            if(n.getElement() == y) {
                lnY = n;
            }

            if(n.getElement() == x){
                lnX = n;
                // settle the chains for x
                if(lnX == head && lnX == tail) { // only one node in the list
                    head = null;
                    tail = null;
                }
            }

            if(lnX != null && lnY != null) {
                // check whether x is on the right of Y
                if(lnY.getNext() == lnX) break;

                // fix prev pointer
                if(lnX != tail){
                    lnX.getNext().setPrev(lnX.getPrev());
                } else {
                    tail = lnX.getPrev();
                    tail.setNext(null);
                }

                // fix next pointer
                if(lnX != head){
                    lnX.getPrev().setNext(lnX.getNext());
                } else {
                    head = lnX.getNext();
                    head.setPrev(null);
                }

                // insert it before y
                if(lnY != tail){
                    lnX.setNext(lnY.getNext());
                    lnY.getNext().setPrev(lnX);
                } else {
                    tail = lnX;
                    tail.setNext(null);
                }

                lnY.setNext(lnX);
                lnX.setPrev(lnY);
            }
        }
    }


    /**
     *		doR				: implement the operation for R
     * 		Pre-condition  	: valid x and there must be a ball labelled x in the list
     * 		Post-condition 	: remove the ball labelled x
     */
    public void doR(int x) {
        for(ListNode n = head; n!=null; n = n.getNext()){
            if(n.getElement() == x){
                // when found, remove that node
                if(n == head && n == tail) { // only one node in the list
                    head = null;
                    tail = null;
                }

                // fix prev pointer
                if(n != tail){
                    n.getNext().setPrev(n.getPrev());
                } else {
                    tail = n.getPrev();
                    tail.setNext(null);
                }

                // fix next pointer
                if(n != head){
                    n.getPrev().setNext(n.getNext());
                } else {
                    head = n.getNext();
                    head.setPrev(null);
                }
            }
            num_nodes--;
        }
    }

    /**
     * Method to add a item into the back of the list
     * pre: item must not be 0
     * post: new ListNode object created and added to the back of the List
     * @param item the element to be store in the node
     */
    public void addLast(int item){
        if(isEmpty()){ // we can say that there's no item in the node
            head = new ListNode(item, head, tail);
            tail = head;
        } else {
            ListNode temp = tail;
            tail = new ListNode(item, tail, null);
            temp.setNext(tail);
        }

        num_nodes++; // increment the counter
    }

    public boolean isEmpty() { return (num_nodes == 0); }
    public int size() { return num_nodes; }
    public void print(){
        for(ListNode n = head; n!=null; n = n.getNext()){
            System.out.print(n.getElement() + " ");
        }
    }
}

class Balls {
    public static void main(String[] args) {
        // declare the necessary variables
        MyLinkedList balls = new MyLinkedList();

        // declare a Scanner object to read input
        Scanner sc = new Scanner(System.in);

        // read input and process them accordingly
        int noOfBalls = sc.nextInt();

        // create nodes from 1 .... N and store into list
        for(int i = 1;  i <= noOfBalls; i++){
            balls.addLast(i);
        }

        // get the number of operations the user have and iterate
        int operations = sc.nextInt();

        for(int i = 0; i < operations; i++){
            String mode = sc.next(); // get the mode of operation
            if(mode.equals("A")){
                balls.doA(sc.nextInt(), sc.nextInt());
            } else if(mode.equals("B")){
                balls.doB(sc.nextInt(), sc.nextInt());
            } else if(mode.equals("R")){
                balls.doR(sc.nextInt());
            }
        }

        // print output
        balls.print();
    }
}