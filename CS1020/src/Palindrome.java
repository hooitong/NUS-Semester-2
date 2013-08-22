/**
 * Given two strings, the class determine whether the concatenation of those strings will form a palindrome word or not.
 * @author Yeap Hooi Tong
 * @matric A0111736M
 * @date 21/8/13
 * @version 1.0
 */

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        // declare and initialise variables required for the methods
        Scanner sc = new Scanner(System.in);

        // call method to read input from user and check whether its palindrome
        // and provide output to the user
        System.out.println(isPalindrome(readInput(sc)) ? "YES" : "NO");

        // exit the application
        System.exit(0);
    }

    /**
     * This method is used to read two strings given by the user.
     *
     * @param sc The scanner object.
     * @return String The concatenated string to determine whether its a palindrome
     */
    private static String readInput(Scanner sc) {
        // read two strings given by the user
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();

        // return concatenated string
        return input1 + input2;
    }

    /**
     * This method is used to determine whether the user's input is a palindrome
     *
     * @param input The user's concatenated input
     * @return Boolean Shows whether it is a palindrome or not
     */
    private static boolean isPalindrome(String input) {
        // declare and initialise variables
        boolean isPalindrome = true;
        char inputArray[] = input.toCharArray();
        char first, last;

        // if it is a palindrome, the mirrored index in the array should be the same
        for (int i = 0; i < inputArray.length / 2; i++) {
            // set the index for both variables to the appropriate position
            first = inputArray[i];
            last = inputArray[inputArray.length - 1 - i];

            // if it does not match, set to false and break
            if (!(first == last)) {
                isPalindrome = false;
                break;
            }
        }

        // return result
        return isPalindrome;
    }
}
