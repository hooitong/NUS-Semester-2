/**
 * This class accepts N number of sticks with specified lengths and outputs the number of triangles and
 * right angled triangles that can be formed
 * @author Yeap Hooi Tong
 * @matric A0111736M
 * @date 23/8/13
 * @version 1.0
 */

import java.util.Arrays;
import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        // declare and create scanner object
        Scanner sc = new Scanner(System.in);

        // get sticks array from user input
        int[] sticks = readInput(sc);

        // calculate the number of possible triangles and right angled triangles
        calculateTriangle(sticks);
    }

    /**
     * This method reads the number of integers (N) followed by N lines
     * which contains a single integer which is the length of the i-th stick
     *
     * @param sc The scanner object
     * @return int[] populated array from user
     */
    private static int[] readInput(Scanner sc) {
        // get array size from user
        int size = sc.nextInt();

        // declare and initialise array of integer type
        int[] sticks = new int[size];

        // read array given by user
        for (int iteration = 0; iteration < sticks.length; iteration++) {
            sticks[iteration] = sc.nextInt();
        }

        // return matrix back to parent
        return sticks;
    }

    /**
     * This method calculates the possible combinations of triangles that can be
     * formed with the given sticks by user. It also determines the number of
     * right angled triangle that is possible as well.
     *
     * @param sticks the stick array
     */
    private static void calculateTriangle(int[] sticks) {
        // declare and initialize variables
        int noOfTriangles = 0, noOfRight = 0;

        // sort the array in ascending order to ensure that the number on the right is always the longer edge
        Arrays.sort(sticks);

        // loop through the indexes of 3 temp variables, firstIndex, secondIndex, thirdIndex
        // worst case scenario O(sticks.size combination 3)
        for (int firstIndex = 0; firstIndex < sticks.length - 2; firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex < sticks.length - 1; secondIndex++) {
                for (int thirdIndex = secondIndex + 1; thirdIndex < sticks.length; thirdIndex++) {
                    if (sticks[thirdIndex] < sticks[secondIndex] + sticks[firstIndex]) { // if a + b > c, it is a triangle
                        noOfTriangles++;
                        // pythagoras theorem to check whether its a right angled triangle
                        if ((Math.pow(sticks[thirdIndex], 2)) == (Math.pow(sticks[secondIndex], 2) + Math.pow(sticks[firstIndex], 2)))
                            noOfRight++;
                    }
                }
            }
        }

        // print output
        System.out.println(noOfTriangles + " " + noOfRight);
    }
}
