package week_1; /**
 * User: Yeap Hooi Tong
 * Matric No: A0111736M
 * Date: 20/1/14
 * Time: 2:17 PM
 * Description: the program is used to check whether the input string is a valid identifier
 * where it can only consist of any combination of letters, digits and the underscore character.
 * It may not start with a digit.
 */

import java.util.Scanner;

public class TestIsId {
    /* Test Driver */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s;
        while (scan.hasNext()) {
            s = scan.next();
            if (isId(s, 0)) {
                System.out.println(s + " is an identifier");
            } else {
                System.out.println(s + " is not an identifier");
            }
        }
        return;
    }

    /*
     * This method is used to check whether the parameter string is a valid identifier
     * returns a boolean representing whether the string is a valid identifier
     */
    public static boolean isId(String s, int index) {
        /* if index is at the exceed the string index, return true */
        if (s.length() == index) return true;

        /* check at index position of the provided string */
        int charCode = (int) s.charAt(index);

        /* check whether the character is not a letter or underscore character */
        if (!((charCode >= (int) 'a' && charCode <= (int) 'z') || (charCode >= (int) 'A' && charCode <= (int) 'Z') || (charCode == (int) '_'))) {
            /* check whether the character is a number if index is not equals to 0 */
            if (index == 0 || !(charCode >= (int) '0' && charCode <= (int) '9'))
                return false; /* the string is not a valid java identifier */
        }

        /* call recursive step to check the next character */
        return isId(s, ++index);
    }
}

