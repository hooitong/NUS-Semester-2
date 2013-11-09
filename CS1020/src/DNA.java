/**
 * Class Name: DNA
 * Description: Find the number of occurrence of those substring in the DNA
 *
 * @name: Yeap Hooi Tong
 * @matric: A0111736M
 * @date: 11/9/13
 * @time: 8:09 PM
 */
import java.util.*;

public class DNA {
    /* main driver method */
    public static void main(String[] args){
        /* accept user input */
        Scanner sc = new Scanner(System.in);
        /* N - the length of the DNA, K - length of substring */
        int N = sc.nextInt();
        int K = sc.nextInt();

        /* accept DNA sequence of length N */
        String sequence = sc.next();

        /* Q - number of queries from user */
        int Q = sc.nextInt();

        /* create hash map to store pre-processed data */
        HashMap<String, Integer> data = new HashMap<String, Integer>();

        /* pre-process the given sequence for retrieval */
        preproc(sequence, N, K, data);

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
    public static void preproc(String sequence, int N, int K, HashMap<String, Integer> data){
        /* for each character in the sequence */
        for(int i = 0; i < N-K+1; ++i){
            String newSeq = "";
            /* get the substring combination based on length provided, K */
            for(int y = i; y < K+i; y++){
                newSeq += sequence.charAt(y);
            }

            /* increment the value of the key in the hash map by one */
            int count = data.containsKey(newSeq) ? data.get(newSeq) : 0;
            data.put(newSeq, count + 1);
        }
    }

    /* query - this method is used to return the number of occurrence of the given sequence and substring
     * Pre-condition: all the values must be proper instantiated
     * Post-condition: return an int value which denotes the number of occurrence
     */
    public static int query(String sub, HashMap<String, Integer> data){
        return data.containsKey(sub) ? data.get(sub) : 0; /* return the number of occurrence */
    }
}
