/**
 * Class Name: Find
 * Description: Given two strings, determine whether a particular substring is inside those string
 *
 * @name: Yeap Hooi Tong
 * @matric: A0111736M
 * @date: 11/9/13
 * @time: 10:44 PM
 */
import java.util.HashMap;
import java.util.Scanner;

public class Find {
    /* main driver method */
    public static void main(String[] args){
        /* accept user input */
        Scanner sc = new Scanner(System.in);
        /* N - the length of the DNA, K - length of substring */
        int N = sc.nextInt();
        int K = sc.nextInt();

        /* create hash map to store pre-processed data */
        HashMap<String, Integer> data = new HashMap<String, Integer>();

        /* accept first DNA sequence of length N */
        String sequence = sc.next();

        /* pre-process the first given sequence for retrieval */
        preproc(sequence, N, K, data, 1);

        /* accept the second DNA sequence of length N */
        sequence = sc.next();

        /* pre-process the second given sequence for retrieval */
        preproc(sequence, N, K, data, 2);

         /* Q - number of queries from user */
        int Q = sc.nextInt();

        /* for each query */
        for(int i = 0; i < Q; ++i){
            /* printout the number of occurrence returned */
            System.out.println(query(sc.next(), data));
        }
    }

    /* preproc - pre-process the sequence for N(K) search access in the hash map
     * Pre-condition: all the values must be properly instantiated
     * Post-condition: data is properly filled with the calculated values
     */
    public static void preproc(String sequence, int N, int K, HashMap<String, Integer> data, int T){
        /* for each character in the sequence */
        for(int i = 0; i < N-K+1; ++i){
            String newSeq = "";
            /* get the substring combination based on length provided, K */
            for(int y = i; y < K+i; y++){
                newSeq += sequence.charAt(y);
            }

            /* increment the value of the key in the hash map by one */
            int count = data.containsKey(newSeq) ? data.get(newSeq) : 0;
            if(!(count>=T)) data.put(newSeq, count + T);
        }
    }

    /* query - this method is used to return the proper value to denote the appearance of the string
     * Pre-condition: all the values must be proper instantiated
     * Post-condition: return an int value which denotes the type of appearance of the substring
     */
    public static int query(String sub, HashMap<String, Integer> data){
        return data.containsKey(sub) ? data.get(sub) : 0; /* return type of appearance of the substring */
    }
}
