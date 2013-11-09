/**
 * Class Name: Incantation
 * Description: Used to return the length of the shortest consecutive sub-series
 *
 * @name: Yeap Hooi Tong
 * @matric: A0111736M
 * @date: 11/9/13
 * @time: 9:48 PM
 */
import java.util.*;
import java.util.LinkedList;

public class Incantation {
    /* main driver method */
    public static void main(String[] args){
        /* read user input */
        Scanner sc = new Scanner(System.in);

        /* N - is the length of the series (String) */
        int N = sc.nextInt();

        /* create array to store user input */
        String[] data = new String[N];

        for(int i = 0; i < N; i++){
            data[i] = sc.next();
        }

        /* process the data and solve the question */
        System.out.println(solve(data));
    }

    /* solve - this method is used to return the shortest consecutive sub-series
     * such as all sub-series are contained and the total length is minimum
     * Pre-condition: given data must be properly initialised
     * Post-condition: the shortest length is returned
     */
    public static int solve(String[] data){
        int maxD = 0; /* contain the number of distinct numbers */
        int stringCount = 0; /* contain the length of the sub-strings in the queue */

        /* create a queue to store the length */
        Queue<String> q = new LinkedList<String>();
        /* create hash map to count occurrence, thanks for sit in lab again */
        HashMap<String, Integer> occurrence = new HashMap<String, Integer>();

        /* used to carry the number of distinct substring in the array */
        int dCount = 0;
        /* used to store the current length of all strings in the queue */
        int sCount = 0;

        /* for each string */
        for(int i = 0; i < data.length; i++){
            /* add into queue */
            q.offer(data[i]);

            /* increment the current string length */
            sCount += data[i].length();

            /* update the occurrence hash map accordingly */
            if(!occurrence.containsKey(data[i])){
                occurrence.put(data[i], 1);
                dCount++;
            }else{
                occurrence.put(data[i], occurrence.get(data[i])+1);
            }

            /* check occurrence at the front of the queue, if more than 1, pop */
            while(!q.isEmpty()){
                int o = occurrence.containsKey(q.peek()) ? occurrence.get(q.peek()) : 0;
                if(o > 1){
                    String rm = q.poll(); /* pop the item out from the queue */
                    occurrence.put(rm, occurrence.get(rm) - 1); /* update occurrence in the hash map */
                    sCount -= rm.length(); /* decrement the current string length count */
                }
                else break; /* cannot pop element from queue, thus break */
            }

            /* if check distinct */
            if(dCount > maxD){
                /* assign the new distinct max */
                maxD = dCount;

                /* update the new length */
                stringCount = sCount;

            } else if(dCount == maxD){
                /* update new length if the length is shorter */
                if(sCount < stringCount) stringCount = sCount;
            }
        }

        /* return least length back to parent */
        return stringCount;
    }
}
