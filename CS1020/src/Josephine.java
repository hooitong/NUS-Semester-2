/**
 * Name	     : Yeap Hooi Tong
 * Matric No.: A0111736M
 * Date: 22/09/13
 */

import java.util.*;

// use PrinceNode to represent a person in the circle
class PrinceNode {
    private int element;
    private PrinceNode next;

    public PrinceNode(int element, PrinceNode next){
        this.element = element;
        this.next = next;
    }

    public int getElement(){
        return element;
    }

    public void setElement(int element){
        this.element = element;
    }

    public PrinceNode getNext(){
        return next;
    }

    public void setNext(PrinceNode next){
        this.next = next;
    }
}

class Result {

    // declare the member field
    private PrinceNode head;
    private PrinceNode tail;
    private int num_nodes;

    // declare the constructor
    public Result(int n){
        head = null;
        tail = null;
        num_nodes = 0;

        // create n number of nodes and add into linked list
        for(int i = 1; i <= n; i++){
            if(head == null){
                head = new PrinceNode(i, null);
                tail = head;
                head.setNext(tail);
            } else {
                PrinceNode oldTail = tail;
                tail = new PrinceNode(i, head);
                oldTail.setNext(tail);
            }

            num_nodes++; // increment the number of nodes
        }
    }

    /**
     *		remove			: removing K-th person and update the state
     * 		Pre-condition  	: the list must not be empty, head != null
     * 		Post-condition 	: the prince that is passed in is removed
     */
    private void removeAfter(PrinceNode prince) {
        int removedPrince = 0;
        if(prince != null){
            // check whether its the only node in the list
            if(prince.getNext() == prince){
                head = null;
                tail = null;
                num_nodes = 0;
                removedPrince = prince.getElement();
            } else{
                if(head == prince.getNext()){ // the guy after is the head of the list
                    head = prince.getNext().getNext(); // set the head node to point to the next node
                } else if(tail == prince.getNext()){ // the prince after is the tail of the list
                    tail = prince; // set the tail node to this node
                }
                removedPrince = prince.getNext().getElement();
                prince.setNext(prince.getNext().getNext()); // set the tail node pointer to the next node
                num_nodes--; // decrement the number of nodes in the list
            }
        } else{ // remove the head of the node
            removedPrince = head.getElement();
            tail.setNext(head.getNext());
            head = head.getNext();
            num_nodes--;
        }

        System.out.print(removedPrince + " "); // print out the removed prince
    }

    /**
     *		solve			: keep removing K-th person from the circle to find the Chosen One
     * 		Pre-condition  	: there should not be no prince in the list when this is called
     * 		Post-condition	: based on kth prince, the kth prince number will be printed as well as removed from the list
     */
    public void solve(int k) {
        // declare pointer to refer to the prince after him to be removed
        PrinceNode prince = null;

        // when there's still a prince in the list
        while(num_nodes != 0){
            if(prince == null && k == 1) { removeAfter(null); continue; }
            // for each integer increment in k, point the pointer appropriately
            for(int i = 0; i < k-1; i++){
                if(prince == null){ prince = head; }
                else prince = prince.getNext();
            }

            // remove the prince after him
            removeAfter(prince);
        }
        System.out.println();
    }
}

public class Josephine {

    public static void main(String[] args) {

        // declare the necessary variables
        Result r;

        // declare a Scanner object to read input
        Scanner sc = new Scanner(System.in);

        // read input and process them accordingly
        int testCases = sc.nextInt(); // the number of test cases
        for(int i = 0; i < testCases; i++){
            r = new Result(sc.nextInt()); // number of princes
            r.solve(sc.nextInt()); // solve with the kth constant
        }
    }
}