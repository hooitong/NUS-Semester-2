/**
 * Class Name: PsuedoRMQ
 * Description: Range Minimum Query [Block Design]
 *
 * @author: Hooi Tong
 * @date: 10/17/13
 * @time : 11:54 AM
 */

import java.util.*;

public class PsuedoRMQ {
    int[] numbers; /* stores each individual number provided by the user */
    int[] segments; /* stores the position of the smallest number in each segment */
    int n; /* stores the number of integer in the array */
    int seg_size; /* stores the number of segments in the array */

    public static void main(String[] args){
        /* read input */
        Scanner sc = new Scanner(System.in);
        PsuedoRMQ pr = new PsuedoRMQ(sc);

        /* read user query and pass in the appropriate argument */
        int q = sc.nextInt();

        for(int i = 0; i < q; i++){
            /* print the minimum */
            System.out.println(pr.query(sc.nextInt()-1, sc.nextInt()-1));
        }

    }

    /* default constructor to initialise the arrays */
    public PsuedoRMQ(Scanner sc){
        /* get the length of the integer sequence */
        n = sc.nextInt();
        seg_size = (int)Math.sqrt(n);

        /* initialise both arrays accordingly */
        numbers = new int[n];
        segments = new int[(n/seg_size)+1];

        /* temp variable to keep track on minimum position for the segment */
        int currentMin = -1;

        for(int i = 0; i < n; i++){
            /* store the number into the array */
            numbers[i] = sc.nextInt();
            /* if this is the first number, set current minimum to current position. */
            if(currentMin == -1){ currentMin = i; }
            /* else if the current number is smaller then the current minimum, set the new position of current minimum */
            else if(numbers[i] < numbers[currentMin]) { currentMin = i; }

            /* if this is the last index of the segment */
            if(((i+1)%seg_size == 0) || i == (n-1)) {
                segments[i/seg_size] = currentMin; /* save the minimum position into the other array */
                currentMin = -1; /* reset the current minimum position */
            }
        }
    }

    /* this method is used to find the minimum based on the given segment
     * Pre-condition: 0 <= c <= d <= N, N <= 100000
     * Post-condition: the minimum is returned to the caller
     */
    public int query(int c, int d){
        /* get starting blocks for both start index and end index */
        int startBlock = c / seg_size;
        int endBlock = d / seg_size;

        /* minimum's array position */
        int min_pos = c;

        /* if they are in the same block, basically just get the minimum from c to d */
        if(startBlock == endBlock){
            for(int i = c; i <= d; i++){
                if(numbers[i] < numbers[min_pos]){ min_pos = i; }
            }
        }
        /* if they are in different blocks, get the minimum in startBlock and endBlock and any in between blocks */
        else{
            /* if the starting index, c is the start of a complete block */
            if((c % seg_size) == 0){ min_pos = segments[startBlock];  }
            else{
                /* else if its not the start, check from c to end of that block */
                for(int i = c; i <= (c+(seg_size - ((c%seg_size)+1))); i++){
                    if(numbers[i] < numbers[min_pos]){ min_pos = i; }
                }
            }

            /* check through each seg (if any) */
            for(int i = startBlock+1; i < endBlock; i++){
                if(numbers[segments[i]] < numbers[min_pos]){ min_pos = segments[i]; }
            }


            /* if end index is the end of a complete block */
            if((d+1 % (seg_size) == 0)){
                if(numbers[segments[endBlock]] < numbers[min_pos]){
                    min_pos = segments[endBlock];
                }
            }else{
                /* else check from start of the block to the end for minimum */
                for(int i = (endBlock * seg_size); i <= d; i++){
                    if(numbers[i] < numbers[min_pos]){ min_pos = i; }
                }
            }
        }


        /* return the minimum number */
        return numbers[min_pos];
    }

}
