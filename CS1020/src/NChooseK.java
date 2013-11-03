/**
 *	name	  :
 *	matric no.:
 */

import java.util.*;

class NChooseK {

    public static void main(String[] args) {
        // declare the necessary variables
        Scanner sc = new Scanner(System.in);
        // declare a Scanner object to read input
        ArrayList<String> test = new ArrayList<String>();
        test = solve(sc.nextInt(), sc.next(), "");

        // read input and process them accordingly
        for(String s : test){
            System.out.println(s);
        }
    }


}