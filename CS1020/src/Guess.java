/**
 * Class Name: Guess
 * Description: Guess the data structure Professor X is giving you!
 *
 * @name: Yeap Hooi Tong
 * @matric: A0111736M
 * @date: 10/17/13
 * @time: 3:20 PM
 */
import java.util.*;
import java.util.LinkedList;

public class Guess {
    /* create boolean flags to keep track of possiblity */
    boolean isStack, isQueue;

    /* create both a queue and a stack for simplicity */
    Queue<Integer> q;
    Stack<Integer> s;

    /* replace the default constructor */
    public Guess(){
        /* instantiate the queue and the stack */
        q = new LinkedList<Integer>();
        s = new Stack<Integer>();
        isStack = true;
        isQueue = true;
    }

    public static void main(String[] args){
        /* create scanner object */
        Scanner sc = new Scanner(System.in);

        /* accept the user input */
        while(sc.hasNext()){
            /* reset the boolean flags */
            Guess g = new Guess();

            /* accept the number of operations */
            int  n = sc.nextInt();
            for(int i = 0 ; i < n; i ++){
                /* process each operation */
                String operation = sc.next();
                if(operation.equals("push")){
                    g.push(sc.nextInt()); /* push integer */
                }else if (operation.equals("pop")){
                    g.pop(sc.nextInt()); /* pop integer */
                }else if(operation.equals("reverse")){
                    g.reverse(); /* reverse array */
                }
            }

            /* based on the boolean flags, print out the result */
            if(g.isStack && g.isQueue){ System.out.println("stack or queue"); }
            else if(g.isStack){ System.out.println("stack"); }
            else if(g.isQueue){ System.out.println("queue"); }
            else { System.out.println("impossible"); }
        }
    }

    /* used to reset the boolean flags in the object */
    public void reset(){
        isStack = true;
        isQueue = true;
    }

    /* This method pushes the integer passed in by the user
     * into both the stack and queue.
     * Post-condition: the integer is successfully inserted into both the queue and stack
     */
    public void push(int i){
        q.add(i); /* add into queue */
        s.push(i); /* add into stack */
    }

    /* This method is used to pop the value from each data structure based on their type and compare
     * with user's expectation and decide on the appropriate boolean flag.
     * Post-condition: The appropriate boolean flag will be changed.
     */
    public void pop(int i){
         /* pop value from stack */
        if(!s.empty()){
            Integer stackValue = s.pop();
            /* compare stack value to expectation */
            if(stackValue != i) { isStack = false; }
        }else { isStack = false; }

        /* de-queue value from queue */
        if(!q.isEmpty()){
            Integer queueValue = q.poll();
            /* compare stack value to expectation */
            if(queueValue != i) { isQueue = false; }
        } else { isQueue = false; }


    }

    /* This method reverses the order of the elements inside both the queue
     * and the stack.
     * Pre-condition: there should be more than one element in the data structures
     * Post-condition: the elements in both data structure is reversed in order
     */
    public void reverse(){
        Collections.reverse((List)q);
        Collections.reverse(s);
    }
}
