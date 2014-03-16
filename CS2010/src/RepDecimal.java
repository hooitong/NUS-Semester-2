/**
 * Class Name: RepDecimal
 * Description: The class reads numerators and denominators of fractions
 * and determines their repeating cycles.
 *
 * @name: Yeap Hooi Tong
 * @matric: A0111736M
 * @date: 3/15/14
 * @time: 9:43 PM
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class RepDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* Take in the numerator and denominator from console */
        int num = sc.nextInt();
        int denom = sc.nextInt();

        /* print out the initial output message */
        System.out.printf("%d/%d has a cycle (", num, denom);

        /* use the tree map to track for repeating remainders */
        TreeMap<Integer, Integer> remainderCheck = new TreeMap<Integer, Integer>();

        /* create an arraylist to store the decimal digits */
        ArrayList<Integer> decimalNum = new ArrayList<Integer>();

        /* declare local variables */
        int intDiv = num / denom;
        int remainder = num % denom;
        int index = 0;

        /* while there is no repeated remainder, perform long division method */
        while (!remainderCheck.containsKey(remainder)) {
            remainderCheck.put(remainder, index++);
            intDiv = remainder * 10 / denom;
            decimalNum.add(intDiv);
            remainder = (remainder * 10) % denom;
        }

        /* get the index of the cycle */
        int cycleIndex = remainderCheck.get(remainder);

        /* print out every digit in the repeating cycle */
        for (int i = cycleIndex; i < index; i++) {
            System.out.print(decimalNum.get(i));
        }

        /* print out the length of the cycle */
        System.out.printf(") of length %d", index - cycleIndex);
    }
}
